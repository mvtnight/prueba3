package com.rednorte.msusuarios.application.ports.out;

import com.rednorte.msusuarios.domain.model.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepositoryPort {
    Usuario guardar(Usuario usuario);
    Optional<Usuario> buscarPorRut(String rut);
    List<Usuario> findAll();
    void eliminar(Usuario usuario);
}
