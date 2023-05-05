package com.multiristorante.app.backend.Entities;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;

@Table(name="menu")
@Entity
@Data
public class Menu {
    
    @Id
    @GeneratedValue
    private int menu_id;

    private String tipo;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "menu")
    private List<Producto> productos;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_restaurante",insertable = false,updatable = false)
    private Restaurante restaurante;
}
