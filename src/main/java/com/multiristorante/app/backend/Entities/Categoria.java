package com.multiristorante.app.backend.Entities;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import java.util.List;

@Entity
@Data
public class Categoria {

	@Id
	private Integer categoria_id;
	@Column(nullable = false)
	private String nombre;
	
	@OneToMany(mappedBy="categoria_id")
	private List<Restaurante> restaurante;
	
}
