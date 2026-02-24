package com.utc.gestion.entity;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "historia_clinica_externa")
public class HistoriaClinicaExterna {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo_historia_externa")
    private Long codigoHistoria;

    @Column(name = "tipo_historia_ext")
    private String tipo;

    @Column(name = "fecha_historia_ext")
    private LocalDate fecha;

    @Column(name = "detalle_revision_historia_ext")
    private String detalle;

    // 🔥 RELACIÓN MUCHOS A UNO
    @ManyToOne
    @JoinColumn(name = "fk_codigo_emp")
    private Empleado empleado;

    // getters y setters
}