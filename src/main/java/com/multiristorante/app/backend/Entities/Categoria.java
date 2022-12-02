package com.multiristorante.app.backend.Entities;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

@Entity
@Data
@Table(name = "categoria")
public class Categoria implements Serializable {
    @Id
    private int id;
    private String nombre;
}
