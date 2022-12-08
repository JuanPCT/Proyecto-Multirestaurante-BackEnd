package com.multiristorante.app.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.multiristorante.app.backend.Entities.Carrito;

public interface CarritoRepository extends JpaRepository<Carrito, Integer>{
    
}
