package com.multiristorante.app.backend.repository;

import com.multiristorante.app.backend.Entities.Solicitud;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SolicitudRepository extends JpaRepository<Solicitud,Integer> {
}
