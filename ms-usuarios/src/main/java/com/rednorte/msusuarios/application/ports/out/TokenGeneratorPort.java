package com.rednorte.msusuarios.application.ports.out;

public interface TokenGeneratorPort {
    String generateToken(String rut, String rol);
}
