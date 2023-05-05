package com.multiristorante.app.backend.controllers;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

import com.multiristorante.app.backend.service.StorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.multiristorante.app.backend.Entities.Restaurante;
import com.multiristorante.app.backend.repository.RestauranteRepository;
import org.springframework.web.multipart.MultipartFile;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/restaurantes")
public class RestauranteController {
    
    @Autowired
    RestauranteRepository restauranteRepository;
	@Autowired
	private StorageService service;

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
	public Restaurante postRestaurantes( Restaurante restaurante,@RequestParam("file") MultipartFile file) throws IOException {
		restaurante.setImagen(file.getOriginalFilename());
		service.uploadFile(file);
		restauranteRepository.save(restaurante);
		return restaurante;
	}
	
	
	@PutMapping("/{id}")
	public Restaurante putRestaurantesbyId(@PathVariable Integer id, @RequestBody Restaurante restaurante,@RequestParam("file") MultipartFile file) {
		
		Optional<Restaurante> restauranteCurrent = restauranteRepository.findById(id);
		
		if (restauranteCurrent.isPresent()) {
			
			Restaurante restauranteReturn = restauranteCurrent.get();
			
			
			restauranteReturn.setNombre(restaurante.getNombre());
			restauranteReturn.setDireccion(restaurante.getDireccion());
			restauranteReturn.setTelefono(restaurante.getTelefono());
			restauranteReturn.setEmail(restaurante.getEmail());
			if (!file.isEmpty()) {
                restauranteReturn.setImagen(file.getOriginalFilename());
                service.uploadFile(file);
            }
			restauranteReturn.setUrl_video(restaurante.getUrl_video());
			
			
			restauranteRepository.save(restauranteReturn);
			
			return restauranteReturn;
		}
		
		return null;

	}
	
	// @DeleteMapping("/{id}")
	// public Restaurante deleteRestaurantesbyId(@PathVariable Integer id) {
		
	// 	Optional<Restaurante> restaurante = restauranteRepository.findById(id);
		
	// 	if (restaurante.isPresent()) {
			
	// 		Restaurante restauranteReturn = restaurante.get();
			
	// 		restauranteRepository.deleteById(id);
			
	// 		return restauranteReturn;
	// 	}
		
	// 	return null;

	// }
}
