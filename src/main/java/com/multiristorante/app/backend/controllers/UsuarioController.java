package com.multiristorante.app.backend.controllers;

import com.multiristorante.app.backend.Entities.Rol;
import com.multiristorante.app.backend.Entities.Usuario;
import com.multiristorante.app.backend.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/usuarios")
public class UsuarioController {

    @Autowired
    UsuarioRepository usuarioRepository;

    @GetMapping("/all")
    public List<Usuario> getUsuarioAll(){
        return usuarioRepository.findAll();
    }

    @GetMapping("/{id}")
    public Usuario getUsuariosbyId(@PathVariable Integer documento) {

        Optional<Usuario> Usuario = usuarioRepository.findById(documento);

        if (Usuario.isPresent()) {
            return Usuario.get();
        }

        return null;

    }

    @PostMapping
    public Usuario postUsuarios(@RequestBody Usuario usuario) {
        usuarioRepository.save(usuario);
        return usuario;
    }


    @PutMapping("/{id}")
    public Usuario putUsuariobyId(@PathVariable Integer id, @RequestBody Usuario usuario) {

        Optional<Usuario> usuarioCurrent = usuarioRepository.findById(id);

        if (usuarioCurrent.isPresent()) {

            Usuario usuarioReturn = usuarioCurrent.get();


            usuarioReturn.setNombre(usuario.getNombre());


            usuarioRepository.save(usuarioReturn);

            return usuarioReturn;
        }

        return null;

    }

    @DeleteMapping("/{id}")
    public Usuario deleteUsuariosbyId(@PathVariable Integer id) {

        Optional<Usuario> usuario = usuarioRepository.findById(id);

        if (usuario.isPresent()) {

            Usuario usuarioReturn = usuario.get();

            usuarioRepository.deleteById(id);

            return usuarioReturn;
        }

        return null;

    }
}
