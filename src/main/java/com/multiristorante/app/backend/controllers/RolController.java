package com.multiristorante.app.backend.controllers;

import com.multiristorante.app.backend.Entities.Rol;
import com.multiristorante.app.backend.repository.RolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/roles")
public class RolController {
    @Autowired
    RolRepository rolRepository;

    @GetMapping("/all")
    public List<Rol> getRollAll(){
        return rolRepository.findAll();
    }

    @GetMapping("/{id}")
    public Rol getRolesbyId(@PathVariable Integer id) {

        Optional<Rol> Rol = rolRepository.findById(id);

        if (Rol.isPresent()) {
            return Rol.get();
        }

        return null;

    }

    @PostMapping
    public Rol postRoles(@RequestBody Rol rol) {
        rolRepository.save(rol);
        return rol;
    }


    @PutMapping("/{id}")
    public Rol putRolesbyId(@PathVariable Integer id, @RequestBody Rol rol) {

        Optional<Rol> rolCurrent = rolRepository.findById(id);

        if (rolCurrent.isPresent()) {

            Rol rolReturn = rolCurrent.get();


            rolReturn.setNombre(rol.getNombre());


            rolRepository.save(rolReturn);

            return rolReturn;
        }

        return null;

    }

    @DeleteMapping("/{id}")
    public Rol deleteRolesbyId(@PathVariable Integer id) {

        Optional<Rol> rol = rolRepository.findById(id);

        if (rol.isPresent()) {

            Rol rolReturn = rol.get();

            rolRepository.deleteById(id);

            return rolReturn;
        }

        return null;

    }
}
