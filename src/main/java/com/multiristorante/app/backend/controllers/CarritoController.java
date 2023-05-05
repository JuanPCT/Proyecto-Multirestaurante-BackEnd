package com.multiristorante.app.backend.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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
import com.multiristorante.app.backend.Entities.Producto;
import com.multiristorante.app.backend.Entities.Usuario;
import com.multiristorante.app.backend.Shared.dto.UsuarioDto;
import com.multiristorante.app.backend.repository.CarritoRepository;
import com.multiristorante.app.backend.repository.ProductoRepository;
import com.multiristorante.app.backend.repository.UsuarioRepository;
import com.multiristorante.app.backend.service.UsuarioService;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/carrito")
public class CarritoController {

    @Autowired
    CarritoRepository carritoRepository;
    @Autowired
    UsuarioRepository usuarioRepository;
    @Autowired
    ProductoRepository productoRepository;

    @PostMapping("/{id}")
    public Carrito postCarrito(@PathVariable Integer id) {
        Carrito carritoRet = new Carrito();

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String email = authentication.getPrincipal().toString();
        Usuario usuario =  usuarioRepository.findByEmail(email);
        carritoRet.setProducto(productoRepository.findById(id).get());
        carritoRet.setUsuario(usuario);
        carritoRepository.save(carritoRet);

        return carritoRet;
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