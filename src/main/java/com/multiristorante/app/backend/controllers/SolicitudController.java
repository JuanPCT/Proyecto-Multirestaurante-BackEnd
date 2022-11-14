package com.multiristorante.app.backend.controllers;

import com.multiristorante.app.backend.Entities.Rol;
import com.multiristorante.app.backend.Entities.Solicitud;
import com.multiristorante.app.backend.repository.SolicitudRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/solicitudes")
public class SolicitudController {
    @Autowired
    SolicitudRepository solicitudRepository;
    @GetMapping
    public List<Solicitud> getSolicitudlAll(){
        return solicitudRepository.findAll();
    }

    @GetMapping("/{id}")
    public Solicitud getSolicitudbyId(@PathVariable Integer id) {

        Optional<Solicitud> solicitud = solicitudRepository.findById(id);

        if (solicitud.isPresent()) {
            return solicitud.get();
        }

        return null;

    }

    @PostMapping
    public Solicitud postSolicitudes(@RequestBody Solicitud solicitud) {
        solicitudRepository.save(solicitud);
        return solicitud;
    }


    @PutMapping("/{id}")
    public Solicitud putSolicitudesbyId(@PathVariable Integer id, @RequestBody Solicitud solicitud) {

        Optional<Solicitud> solicitudCurrent = solicitudRepository.findById(id);

        if (solicitudCurrent.isPresent()) {

            Solicitud solicitudReturn = solicitudCurrent.get();


            solicitudReturn.setDescripcion(solicitud.getDescripcion());


            solicitudRepository.save(solicitudReturn);

            return solicitudReturn;
        }

        return null;

    }

    @DeleteMapping("/{id}")
    public Solicitud deleteSolicitudesbyId(@PathVariable Integer id) {

        Optional<Solicitud> solicitud = solicitudRepository.findById(id);

        if (solicitud.isPresent()) {

            Solicitud solicitudReturn = solicitud.get();

            solicitudRepository.deleteById(id);

            return solicitudReturn;
        }

        return null;

    }
}
