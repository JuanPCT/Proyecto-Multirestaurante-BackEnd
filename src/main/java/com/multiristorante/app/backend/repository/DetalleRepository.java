package com.multiristorante.app.backend.repository;

import com.multiristorante.app.backend.Entities.Detalle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetalleRepository extends JpaRepository<Detalle,Integer> {
}
