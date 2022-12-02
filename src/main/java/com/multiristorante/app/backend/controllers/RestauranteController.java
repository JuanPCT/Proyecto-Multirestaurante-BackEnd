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

import com.multiristorante.app.backend.Entities.Restaurante;
import com.multiristorante.app.backend.repository.RestauranteRepository;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/restaurantes")
public class RestauranteController {
    
    @Autowired
    RestauranteRepository restauranteRepository;

    @GetMapping("/all")
    public List<Restaurante> getRestauranteAll(){
        return restauranteRepository.findAll();
    }

    @GetMapping("/{id}")
	public Restaurante getRestaurantesbyId(@PathVariable Integer id) {
		
		Optional<Restaurante> Restaurante = restauranteRepository.findById(id);
		
		if (Restaurante.isPresent()) {
			return Restaurante.get();
		}
		
		return null;

	}
	
	@PostMapping
	public Restaurante postRestaurantes(@RequestBody Restaurante Restaurante) {
		restauranteRepository.save(Restaurante);
		return Restaurante;
	}
	
	
	@PutMapping("/{id}")
	public Restaurante putRestaurantesbyId(@PathVariable Integer id, @RequestBody Restaurante restaurante) {
		
		Optional<Restaurante> restauranteCurrent = restauranteRepository.findById(id);
		
		if (restauranteCurrent.isPresent()) {
			
			Restaurante restauranteReturn = restauranteCurrent.get();
			
			
			restauranteReturn.setNombre(restaurante.getNombre());
			restauranteReturn.setDireccion(restaurante.getDireccion());
			restauranteReturn.setTelefono(restaurante.getTelefono());
			restauranteReturn.setEmail(restaurante.getEmail());
			restauranteReturn.setPassword(restaurante.getPassword());
			restauranteReturn.setImagen(restaurante.getImagen());
			restauranteReturn.setEstado(restaurante.getEstado());
			restauranteReturn.setUrl_video(restaurante.getUrl_video());
			
			
			restauranteRepository.save(restauranteReturn);
			
			return restauranteReturn;
		}
		
		return null;

	}
	
	@DeleteMapping("/{id}")
	public Restaurante deleteRestaurantesbyId(@PathVariable Integer id) {
		
		Optional<Restaurante> restaurante = restauranteRepository.findById(id);
		
		if (restaurante.isPresent()) {
			
			Restaurante restauranteReturn = restaurante.get();
			
			restauranteRepository.deleteById(id);
			
			return restauranteReturn;
		}
		
		return null;

	}
}
