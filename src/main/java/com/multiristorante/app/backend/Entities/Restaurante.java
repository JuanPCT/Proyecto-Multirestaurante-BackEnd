package com.multiristorante.app.backend.Entities;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Restaurante {
    
    @Id
    private Integer id;
	
	private String nombre;
	
    
}