package com.multiristorante.app.backend.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.multiristorante.app.backend.Entities.Carrito;
import com.multiristorante.app.backend.repository.CarritoRepository;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/carrito")
public class CarritoController {

    @Autowired
    CarritoRepository carritoRepository;

    @PostMapping
    public Carrito postUsuarios(@RequestBody Carrito carrito) {

        carritoRepository.save(carrito);

        return carrito;
    }

    @GetMapping("/{id}")
    public Carrito getProductosbyId(@PathVariable Integer id) {

        Optional<Carrito> carrito = carritoRepository.findById(id);

        if (carrito.isPresent()) {
            return carrito.get();
        }

        return null;
    }

    @DeleteMapping("/{id}")
    public Carrito deleteProductobyId(@PathVariable Integer id) {

        Optional<Carrito> carrito = carritoRepository.findById(id);

        if (carrito.isPresent()) {

            Carrito carritoReturn = carrito.get();

            carritoRepository.deleteById(id);

            return carritoReturn;
        }

        return null;

    }

}