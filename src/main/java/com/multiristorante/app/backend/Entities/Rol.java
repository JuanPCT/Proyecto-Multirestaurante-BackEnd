package com.multiristorante.app.backend.Entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Table(name="rol")
@Entity
@Data
public class Rol {
    
    @Id
    private Integer id;

    private String nombre;
}
