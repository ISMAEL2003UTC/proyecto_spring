package com.utc.gestion.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "empleado")
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_emp")
    private Long codigoEmp;

    @Column(name = "nombre_emp")
    private String nombre;

    @Column(name = "apellido_emp")
    private String apellido;

    @Column(name = "identificacion_emp")
    private String identificacion;

    @Column(name = "email_emp")
    private String email;

    // RELACIÓN 1:N
    @OneToMany(mappedBy = "empleado", cascade = CascadeType.ALL)
    private List<HistoriaClinicaExterna> historias;

    // getters y setters
}