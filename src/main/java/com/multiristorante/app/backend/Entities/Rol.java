package com.multiristorante.app.backend.Entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "rol")
public class Rol {
    @Id
    private int id;
    private String nombre;
}
