package com.multiristorante.app.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.multiristorante.app.backend.Entities.Restaurante;

public interface RestauranteRepository extends JpaRepository<Restaurante, Integer>{
    
}
