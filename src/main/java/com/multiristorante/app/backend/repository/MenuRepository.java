package com.multiristorante.app.backend.repository;

import com.multiristorante.app.backend.Entities.Menu;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MenuRepository extends JpaRepository<Menu,Integer> {
    
    @Query(value = "SELECT * FROM menu m WHERE m.id_restaurante = :id", nativeQuery = true )
    public List<Menu> findByRestaurante(@Param("id")Integer id);
}
