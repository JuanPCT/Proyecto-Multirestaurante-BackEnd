package com.multiristorante.app.backend.implement;

import com.multiristorante.app.backend.Entities.Rol;
import com.multiristorante.app.backend.repository.RolRepository;
import com.multiristorante.app.backend.service.RolService;

import java.util.List;

public class RolImplement implements RolService {
    private RolRepository rolRepository;
    @Override
    public List<Rol> listarRoles() {
        return (List<Rol>) rolRepository.findAll();
    }

    @Override
    public void guardar(Rol rol) {
        rolRepository.save(rol);
    }

    @Override
    public void eliminar(Rol rol) {
        rolRepository.delete(rol);
    }

    @Override
    public Rol encontrarRol(Rol rol) {
        return rolRepository.findById(rol.getId()).orElse(null);
    }
}
