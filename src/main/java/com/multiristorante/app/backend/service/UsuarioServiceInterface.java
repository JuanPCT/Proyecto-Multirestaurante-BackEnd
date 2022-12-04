package com.multiristorante.app.backend.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.multiristorante.app.backend.Shared.dto.UsuarioDto;

public interface UsuarioServiceInterface extends UserDetailsService{

    public UsuarioDto createUsuario(UsuarioDto usuarioDto);
    public UsuarioDto getUser(String email);
    
}
