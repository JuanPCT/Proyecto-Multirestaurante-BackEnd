package com.multiristorante.app.backend.Entities;

import java.sql.Blob;

import javax.persistence.*;

import lombok.Data;

@Table(name="producto")
@Entity
@Data
public class Producto {
    
    @Id
    private Integer id;
	private String nombre;
    private Blob imagen;
    private double precio;
    @ManyToOne
    @JoinColumn(name = "Menu_id")
    private Menu Menu_id;
}
