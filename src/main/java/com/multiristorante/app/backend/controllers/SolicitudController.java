package com.multiristorante.app.backend.controllers;

import com.multiristorante.app.backend.Entities.Solicitud;
import com.multiristorante.app.backend.repository.SolicitudRepository;
import com.multiristorante.app.backend.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/solicitudes")
public class SolicitudController {

    @Autowired
    SolicitudRepository solicitudRepository;

    private final FileService fileService;

    @Autowired
    public SolicitudController(FileService fileService) {
        this.fileService = fileService;
    }

    @GetMapping("/all")
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
    public Solicitud postSolicitudes(Solicitud solicitud,@RequestParam("file") MultipartFile file) throws IOException {
        solicitud.setImagen(file.getOriginalFilename());
        fileService.storeFile(file);
        solicitudRepository.save(solicitud);
        return solicitud;
    }


    @PutMapping("/{id}")
    public Solicitud putSolicitudesbyId(@PathVariable Integer id, @RequestBody Solicitud solicitud) {

        Optional<Solicitud> solicitudCurrent = solicitudRepository.findById(id);

        if (solicitudCurrent.isPresent()) {

            Solicitud solicitudReturn = solicitudCurrent.get();


            solicitudReturn.setDescripcion(solicitud.getDescripcion());
            solicitudReturn.setImagen(solicitud.getImagen());
            solicitudReturn.setEstado(solicitud.getEstado());
            solicitudReturn.setFecha(solicitud.getFecha());



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
