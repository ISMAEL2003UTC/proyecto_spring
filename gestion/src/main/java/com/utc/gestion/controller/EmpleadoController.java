package com.utc.gestion.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.utc.gestion.repository.EmpleadoRepository;
import com.utc.gestion.entity.Empleado;

@Controller
@RequestMapping("/empleados")
public class EmpleadoController {

    private final EmpleadoRepository empleadoRepository;

    public EmpleadoController(EmpleadoRepository empleadoRepository) {
        this.empleadoRepository = empleadoRepository;
    }

    // ===== LISTAR =====
    @GetMapping
    public String listar(Model model) {
        model.addAttribute("empleados", empleadoRepository.findAll());
        return "empleados/lista";
    }

    // ===== NUEVO =====
    @GetMapping("/nuevo")
    public String nuevo(Model model) {
        model.addAttribute("empleado", new Empleado());
        return "empleados/form";
    }

    // ===== GUARDAR (crear) =====
    @PostMapping("/guardar")
    public String guardar(@ModelAttribute Empleado empleado) {
        empleadoRepository.save(empleado);
        return "redirect:/empleados";
    }

    // ===== EDITAR — carga el formulario con los datos del empleado =====
    @GetMapping("/editar/{id}")
    public String editar(@PathVariable Long id, Model model) {
        Empleado empleado = empleadoRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Empleado no encontrado: " + id));
        model.addAttribute("empleado", empleado);
        return "empleados/form";   // reutiliza el mismo formulario
    }

    // ===== ELIMINAR =====
    @PostMapping("/eliminar/{id}")
    public String eliminar(@PathVariable Long id) {
        empleadoRepository.deleteById(id);
        return "redirect:/empleados";
    }
}