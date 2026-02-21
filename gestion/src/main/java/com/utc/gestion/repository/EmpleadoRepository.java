package com.utc.gestion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.utc.gestion.entity.Empleado;

public interface EmpleadoRepository extends JpaRepository<Empleado, Long> {
}