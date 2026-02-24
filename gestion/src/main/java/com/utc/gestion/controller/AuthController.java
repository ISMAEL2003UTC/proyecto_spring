package com.utc.gestion.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.utc.gestion.entity.Usuario;
import com.utc.gestion.repository.UsuarioRepository;
import org.springframework.security.crypto.password.PasswordEncoder;

@Controller
public class AuthController {

    private final UsuarioRepository usuarioRepository;
    private final PasswordEncoder passwordEncoder;

    public AuthController(UsuarioRepository usuarioRepository,
                          PasswordEncoder passwordEncoder) {
        this.usuarioRepository = usuarioRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @GetMapping("/registro")
    public String registroForm(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "registro";
    }

    //guardr usuarios
    @PostMapping("/guardarUsuario")
    public String guardarUsuario(@ModelAttribute Usuario usuario) {

        usuario.setPassword(passwordEncoder.encode(usuario.getPassword()));
        usuario.setRole("USER");

        usuarioRepository.save(usuario);

        return "redirect:/login";
    }

    @GetMapping("/home")
    //ruta para acceder al home
    public String home() {
        return "home";
    }
}