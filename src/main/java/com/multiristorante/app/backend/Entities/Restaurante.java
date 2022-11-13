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
	
<<<<<<< HEAD
	private String descripcion;
=======
>>>>>>> 33e9fc3f473c0e534ff5351c640eba47148cf8a6
    
}