package com.multiristorante.app.backend.controllers;

import com.multiristorante.app.backend.Entities.Menu;
import com.multiristorante.app.backend.Entities.Rol;
import com.multiristorante.app.backend.repository.MenuRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/menus")
public class MenuController {

    @Autowired
    MenuRepository menuRepository;

    @GetMapping("/all")
    public List<Menu> getMenulAll(){
        return menuRepository.findAll();
    }

    @GetMapping("/{id}")
    public Menu getMenusbyId(@PathVariable Integer id) {

        Optional<Menu> menu = menuRepository.findById(id);

        if (menu.isPresent()) {
            return menu.get();
        }

        return null;

    }

    @PostMapping
    public Menu postMenus(@RequestBody Menu menu) {
        menuRepository.save(menu);
        return menu;
    }


    @PutMapping("/{id}")
    public Menu putMenusbyId(@PathVariable Integer id, @RequestBody Menu menu) {

        Optional<Menu> menuCurrent = menuRepository.findById(id);

        if (menuCurrent.isPresent()) {

            Menu menuReturn = menuCurrent.get();


            menuReturn.setTipo(menu.getTipo());


            menuRepository.save(menuReturn);

            return menuReturn;
        }

        return null;

    }

    @DeleteMapping("/{id}")
    public Menu deleteMenusbyId(@PathVariable Integer id) {

        Optional<Menu> menu = menuRepository.findById(id);

        if (menu.isPresent()) {

            Menu menuReturn = menu.get();

            menuRepository.deleteById(id);

            return menuReturn;
        }

        return null;

    }
}
