package com.multiristorante.app.backend.Entities;

import java.sql.Blob;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Table(name="producto")
@Entity
@Data
public class Producto {
    
    @Id
    private Integer id;
	
	private String nombre;
    private Blob imagen;
    private int precio;
    private int Menu_id;
}
