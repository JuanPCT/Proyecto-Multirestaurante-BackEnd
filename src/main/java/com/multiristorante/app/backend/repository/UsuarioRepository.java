package com.multiristorante.app.backend.repository;

import com.multiristorante.app.backend.Entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario,Long> {
    Usuario findByEmail(String email);
    Usuario findByUserId(int user_id);
}
