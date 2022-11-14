package com.multiristorante.app.backend.repository;

import com.multiristorante.app.backend.Entities.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoRepository extends JpaRepository<Producto,Integer> {
}
