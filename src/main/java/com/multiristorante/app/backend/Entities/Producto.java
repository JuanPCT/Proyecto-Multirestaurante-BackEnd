package com.multiristorante.app.backend.Entities;


import javax.persistence.*;

import lombok.Data;

@Table(name="producto")
@Entity
@Data
public class Producto {
    
    @Id
    @GeneratedValue
    private Integer producto_id;
	private String nombre;
    private String imagen;
    private double precio;

    @ManyToOne
    @JoinColumn(name = "menu_id",insertable = false,updatable = false)
    private Menu menu;
}
