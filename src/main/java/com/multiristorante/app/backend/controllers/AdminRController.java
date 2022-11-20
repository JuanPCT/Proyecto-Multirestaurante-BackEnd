package com.multiristorante.app.backend.controllers;

import com.multiristorante.app.backend.Entities.AdminR;
import com.multiristorante.app.backend.Entities.Usuario;
import com.multiristorante.app.backend.repository.AdminRRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/administradoresR")
public class AdminRController {

    @Autowired
    AdminRRepository adminRRepository;

    @GetMapping("/all")
    public List<AdminR> getAdminRAll(){
        return adminRRepository.findAll();
    }

    @GetMapping("/{id}")
    public AdminR getAdministradoresbyId(@PathVariable Integer documento) {

        Optional<AdminR> adminR = adminRRepository.findById(documento);

        if (adminR.isPresent()) {
            return adminR.get();
        }

        return null;

    }

    @PostMapping
    public AdminR postAdministradores(@RequestBody AdminR adminR) {
        adminRRepository.save(adminR);
        return adminR;
    }


    @PutMapping("/{id}")
    public AdminR putAdministradorbyId(@PathVariable Integer documento, @RequestBody AdminR adminR) {

        Optional<AdminR> AdminRCurrent = adminRRepository.findById(documento);

        if (AdminRCurrent.isPresent()) {

            AdminR adminRReturn = AdminRCurrent.get();


            adminRReturn.setNombre(adminR.getNombre());


            adminRRepository.save(adminRReturn);

            return adminRReturn;
        }

        return null;

    }

    @DeleteMapping("/{id}")
    public AdminR deleteAdministradorbyId(@PathVariable Integer documento) {

        Optional<AdminR> adminR = adminRRepository.findById(documento);

        if (adminR.isPresent()) {

            AdminR adminRReturn = adminR.get();

            adminRRepository.deleteById(documento);

            return adminRReturn;
        }

        return null;

    }
}
