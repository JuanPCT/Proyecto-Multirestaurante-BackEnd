package com.multiristorante.app.backend.repository;

import com.multiristorante.app.backend.Entities.Menu;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MenuRepository extends JpaRepository<Menu,Integer> {
}
