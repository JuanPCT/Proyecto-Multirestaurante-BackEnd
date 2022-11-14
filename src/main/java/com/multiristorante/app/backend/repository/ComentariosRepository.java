package com.multiristorante.app.backend.repository;

import com.multiristorante.app.backend.Entities.Comentarios;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComentariosRepository extends JpaRepository<Comentarios,Integer> {
}
