package com.multiristorante.app.backend.controllers;

import com.multiristorante.app.backend.Entities.Factura;
import com.multiristorante.app.backend.Entities.Usuario;
import com.multiristorante.app.backend.repository.FacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/facturas")
public class FacturaController {

    @Autowired
    FacturaRepository facturaRepository;

    @GetMapping("/all")
    public List<Factura> getFacturaAll(){
        return facturaRepository.findAll();
    }

    @GetMapping("/{id}")
    public Factura getFacturasbyId(@PathVariable Integer documento) {

        Optional<Factura> factura = facturaRepository.findById(documento);

        if (factura.isPresent()) {
            return factura.get();
        }

        return null;

    }

    @PostMapping
    public Factura postFacturas(@RequestBody Factura factura) {
        facturaRepository.save(factura);
        return factura;
    }


    @PutMapping("/{id}")
    public Factura putFacturabyId(@PathVariable Integer id, @RequestBody Factura factura) {

        Optional<Factura> facturaCurrent = facturaRepository.findById(id);

        if (facturaCurrent.isPresent()) {

            Factura facturaReturn = facturaCurrent.get();


            facturaReturn.setDocumento(factura.getDocumento());


            facturaRepository.save(facturaReturn);

            return facturaReturn;
        }

        return null;

    }

    @DeleteMapping("/{id}")
    public Factura deleteFacturabyId(@PathVariable Integer id) {

        Optional<Factura> factura = facturaRepository.findById(id);

        if (factura.isPresent()) {

            Factura facturaReturn = factura.get();

            facturaRepository.deleteById(id);

            return facturaReturn;
        }

        return null;

    }
}
