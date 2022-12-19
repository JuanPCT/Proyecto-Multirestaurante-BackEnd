package com.multiristorante.app.backend.controllers;


import com.multiristorante.app.backend.Entities.Categoria;
import com.multiristorante.app.backend.repository.CategoriaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/categorias")
public class CategoriaController {
    @Autowired
    CategoriaRepository categoriaRepository;

    @GetMapping("/all")
    public List<Categoria> getProductoAll(){
        return categoriaRepository.findAll();
    }

    @GetMapping("/{id}")
    public Categoria getProductosbyId(@PathVariable Integer id) {

        Optional<Categoria> categorias = categoriaRepository.findById(id);

        if (categorias.isPresent()) {
            return categorias.get();
        }

        return null;

    }

    @PostMapping
    public Categoria postProductos(@RequestBody Categoria categoria) {

        categoriaRepository.save(categoria);
        return categoria;
    }


    @PutMapping("/{id}")
    public Categoria putProductosbyId(@PathVariable Integer id, @RequestBody Categoria categoria) {

        Optional<Categoria> categoriaCurrent = categoriaRepository.findById(id);

        if (categoriaCurrent.isPresent()) {

            Categoria categoriaReturn = categoriaCurrent.get();


            categoriaReturn.setNombre(categoria.getNombre());



            categoriaRepository.save(categoriaReturn);

            return categoriaReturn;
        }

        return null;

    }

    @DeleteMapping("/{id}")
    public Categoria deleteProductobyId(@PathVariable Integer id) {

        Optional<Categoria> categoria = categoriaRepository.findById(id);

        if (categoria.isPresent()) {

            Categoria categoriaReturn = categoria.get();

            categoriaRepository.deleteById(id);

            return categoriaReturn;
        }

        return null;

    }
}
