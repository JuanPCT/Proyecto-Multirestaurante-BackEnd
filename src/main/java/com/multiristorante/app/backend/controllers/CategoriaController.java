package com.multiristorante.app.backend.controllers;


import com.multiristorante.app.backend.Entities.Categoria;
import com.multiristorante.app.backend.repository.CategoriaRepository;
import com.multiristorante.app.backend.service.StorageService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/categorias")
public class CategoriaController {
    @Autowired
    CategoriaRepository categoriaRepository;
    @Autowired
    StorageService storageService;

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
    public Categoria postProductos(Categoria categoria ,@RequestParam("file") MultipartFile file) {
        categoria.setImagen(file.getOriginalFilename());
        storageService.uploadFile(file);
        categoriaRepository.save(categoria);
        return categoria;
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
