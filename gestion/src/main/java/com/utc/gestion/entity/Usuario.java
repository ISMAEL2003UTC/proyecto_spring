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

    // ===== GETTERS Y SETTERS =====

    public Long getCodigoUsu() {
        return codigoUsu;
    }

    public void setCodigoUsu(Long codigoUsu) {
        this.codigoUsu = codigoUsu;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}