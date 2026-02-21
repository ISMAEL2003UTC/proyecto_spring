package com.utc.gestion.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_usu")
    private Long codigoUsu;

    @Column(name = "usuario_usu")
    private String username;

    @Column(name = "password_usu")
    private String password;

    @Column(name = "role")
    private String role;

    // getters y setters
}