package com.multiristorante.app.backend.service;

import com.multiristorante.app.backend.Entities.Rol;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RolService {
    public List<Rol> listarRoles();

    public void guardar(Rol rol);

    public void eliminar(Rol rol);

    public Rol encontrarRol(Rol rol);
}
