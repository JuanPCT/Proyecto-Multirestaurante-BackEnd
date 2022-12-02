package com.multiristorante.app.backend.repository;

import com.multiristorante.app.backend.Entities.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria,Integer> {
}
