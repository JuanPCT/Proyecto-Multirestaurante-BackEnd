package com.multiristorante.app.backend.controllers;

import com.multiristorante.app.backend.Entities.Comentarios;
import com.multiristorante.app.backend.Entities.Rol;
import com.multiristorante.app.backend.repository.ComentariosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/comentarios")
public class ComentariosController {
    @Autowired
    ComentariosRepository comentariosRepository;
    @GetMapping
    public List<Comentarios> getComentarioslAll(){
        return comentariosRepository.findAll();
    }

    @GetMapping("/{id}")
    public Comentarios getComentariobyId(@PathVariable Integer id) {

        Optional<Comentarios> comentarios = comentariosRepository.findById(id);

        if (comentarios.isPresent()) {
            return comentarios.get();
        }

        return null;

    }

    @PostMapping
    public Comentarios postComentarios(@RequestBody Comentarios comentarios) {
        comentariosRepository.save(comentarios);
        return comentarios;
    }


    @PutMapping("/{id}")
        public Comentarios putComentariosbyId(@PathVariable Integer id, @RequestBody Comentarios comentarios) {

        Optional<Comentarios> comCurrent = comentariosRepository.findById(id);

        if (comCurrent.isPresent()) {

            Comentarios comReturn = comCurrent.get();


            comReturn.setDescripcion(comentarios.getDescripcion());


            comentariosRepository.save(comReturn);

            return comReturn;
        }

        return null;

    }

    @DeleteMapping("/{id}")
    public Comentarios deleteComentariossbyId(@PathVariable Integer id) {

        Optional<Comentarios> comentarios = comentariosRepository.findById(id);

        if (comentarios.isPresent()) {

            Comentarios comReturn = comentarios.get();

            comentariosRepository.deleteById(id);

            return comReturn;
        }

        return null;

    }
}
