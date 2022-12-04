package com.multiristorante.app.backend.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.multiristorante.app.backend.Entities.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria,Integer> {
    
}
