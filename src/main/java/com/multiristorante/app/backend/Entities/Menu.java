package com.multiristorante.app.backend.Entities;

import java.util.List;

import javax.persistence.*;

import lombok.Data;

@Table(name="menu")
@Entity
@Data
public class Menu {
    
    @Id
    private int Menu_id;

    private String tipo;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "menu")
    private List<Producto> productos;

    @ManyToOne
    @JoinColumn(name = "id_restaurante",insertable = false,updatable = false)
    private Restaurante restaurante;
}
