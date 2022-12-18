package com.multiristorante.app.backend.Entities;

import lombok.Data;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.List;

@Entity
@Data
@Table(name = "categoria")
public class Categoria {

	@Id
	private Integer categoria_id;
	@Column(nullable = false)
	private String nombre;
	
	@JsonIgnore
	@OneToMany(mappedBy="categoria_id")
	private List<Restaurante> restaurante;
	
}
