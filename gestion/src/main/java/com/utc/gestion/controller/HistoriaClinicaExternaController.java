package com.utc.gestion.controller;

import com.utc.gestion.entity.HistoriaClinicaExterna;
import com.utc.gestion.entity.Empleado;
import com.utc.gestion.repository.HistoriaClinicaExternaRepository;
import com.utc.gestion.repository.EmpleadoRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/historias")
public class HistoriaClinicaExternaController {

    private final HistoriaClinicaExternaRepository historiaRepository;
    private final EmpleadoRepository empleadoRepository;

    public HistoriaClinicaExternaController(HistoriaClinicaExternaRepository historiaRepository,
                                             EmpleadoRepository empleadoRepository) {
        this.historiaRepository = historiaRepository;
        this.empleadoRepository = empleadoRepository;
    }

    // ===== LISTAR =====
    @GetMapping
    public String listar(Model model) {
        model.addAttribute("historias", historiaRepository.findAll());
        return "historias/lista";
    }

    // ===== NUEVO =====
    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("historia", new HistoriaClinicaExterna());
        model.addAttribute("empleados", empleadoRepository.findAll());
        return "historias/form";
    }

    // ===== GUARDAR (crear y actualizar) =====
    @PostMapping("/guardar")
    public String guardar(@ModelAttribute HistoriaClinicaExterna historia,
                          @RequestParam(value = "empleadoId", required = false) Long empleadoId) {
        if (empleadoId != null) {
            Empleado emp = empleadoRepository.findById(empleadoId).orElse(null);
            historia.setEmpleado(emp);
        }
        historiaRepository.save(historia);
        return "redirect:/historias";
    }

    // ===== EDITAR =====
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        HistoriaClinicaExterna historia = historiaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Historia no encontrada: " + id));
        model.addAttribute("historia", historia);
        model.addAttribute("empleados", empleadoRepository.findAll());
        return "historias/form";
    }

    // ===== ELIMINAR =====
    @PostMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        historiaRepository.deleteById(id);
        return "redirect:/historias";
    }
}