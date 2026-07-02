package com.rednorte.msusuarios.infrastructure.adapter.out.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface UsuarioJpaRepository extends JpaRepository<UsuarioEntity, String> {
    Optional<UsuarioEntity> findByRut(String rut);
}
