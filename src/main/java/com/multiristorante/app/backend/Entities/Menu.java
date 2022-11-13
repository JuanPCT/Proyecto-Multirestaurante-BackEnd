package com.multiristorante.app.backend.Entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Table(name="menu")
@Entity
@Data
public class Menu {
    
    @Id
    private int Menu_id;

    private String tipo;

    private int id_restaurante;
}
