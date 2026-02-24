package com.utc.gestion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.utc.gestion.entity.HistoriaClinicaExterna;
import java.util.List;

public interface HistoriaRepository 
        extends JpaRepository<HistoriaClinicaExterna, Long> {

    List<HistoriaClinicaExterna> findByEmpleadoCodigoEmp(Long codigoEmp);
}