package com.utc.gestion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.utc.gestion.entity.Usuario;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByUsername(String username);
}