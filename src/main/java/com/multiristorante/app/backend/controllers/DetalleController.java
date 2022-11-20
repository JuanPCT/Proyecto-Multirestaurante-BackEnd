package com.multiristorante.app.backend.controllers;

import com.multiristorante.app.backend.Entities.Detalle;
import com.multiristorante.app.backend.Entities.Rol;
import com.multiristorante.app.backend.repository.DetalleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/detalles")
public class DetalleController {

    @Autowired
    DetalleRepository detalleRepository;

    @GetMapping("/all")
    public List<Detalle> getDetallelAll(){
        return detalleRepository.findAll();
    }

    @GetMapping("/{id}")
    public Detalle getDetallesbyId(@PathVariable Integer id) {

        Optional<Detalle> detalle = detalleRepository.findById(id);

        if (detalle.isPresent()) {
            return detalle.get();
        }

        return null;

    }

    @PostMapping
    public Detalle postDetalles(@RequestBody Detalle detalle) {
        detalleRepository.save(detalle);
        return detalle;
    }


    @PutMapping("/{id}")
    public Detalle putDetallesbyId(@PathVariable Integer id, @RequestBody Detalle detalle) {

        Optional<Detalle> detalleCurrent = detalleRepository.findById(id);

        if (detalleCurrent.isPresent()) {

            Detalle detalleReturn = detalleCurrent.get();


            detalleReturn.setCantidad(detalle.getCantidad());


            detalleRepository.save(detalleReturn);

            return detalleReturn;
        }

        return null;

    }

    @DeleteMapping("/{id}")
    public Detalle deleteDetallesbyId(@PathVariable Integer id) {

        Optional<Detalle> detalle = detalleRepository.findById(id);

        if (detalle.isPresent()) {

            Detalle detalleReturn = detalle.get();

            detalleRepository.deleteById(id);

            return detalleReturn;
        }

        return null;

    }
}
