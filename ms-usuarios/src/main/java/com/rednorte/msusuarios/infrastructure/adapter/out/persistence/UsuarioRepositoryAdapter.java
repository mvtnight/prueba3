package com.rednorte.msusuarios.infrastructure.adapter.out.persistence;

import com.rednorte.msusuarios.application.ports.out.UsuarioRepositoryPort;
import com.rednorte.msusuarios.domain.model.Usuario;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
@RequiredArgsConstructor
public class UsuarioRepositoryAdapter implements UsuarioRepositoryPort {

    private final UsuarioJpaRepository jpaRepository;

    @Override
    public Usuario guardar(Usuario usuario) {
        UsuarioEntity entity = toEntity(usuario);
        UsuarioEntity savedEntity = jpaRepository.save(entity);
        return toDomain(savedEntity);
    }

    @Override
    public Optional<Usuario> buscarPorRut(String rut) {
        return jpaRepository.findByRut(rut).map(this::toDomain);
    }

    @Override
    public List<Usuario> findAll() {
        return jpaRepository.findAll().stream().map(this::toDomain).collect(Collectors.toList());
    }

    @Override
    public void eliminar(Usuario usuario) {
        jpaRepository.findByRut(usuario.getRut()).ifPresent(jpaRepository::delete);
    }

    // Mappers
    private UsuarioEntity toEntity(Usuario domain) {
        if (domain == null) return null;
        return new UsuarioEntity(
                domain.getId(),
                domain.getRut(),
                domain.getEmail(),
                domain.getContrasena(),
                domain.getNombreCompleto(),
                domain.getFechaNacimiento(),
                domain.getNumeroTelefono(),
                domain.getRol()
        );
    }

    private Usuario toDomain(UsuarioEntity entity) {
        if (entity == null) return null;
        return new Usuario(
                entity.getId(),
                entity.getRut(),
                entity.getEmail(),
                entity.getContrasena(),
                entity.getNombreCompleto(),
                entity.getFechaNacimiento(),
                entity.getNumeroTelefono(),
                entity.getRol()
        );
    }
}
