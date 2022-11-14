package com.multiristorante.app.backend.repository;

import com.multiristorante.app.backend.Entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
public interface UsuarioRepository extends JpaRepository<Usuario,Integer> {
}
