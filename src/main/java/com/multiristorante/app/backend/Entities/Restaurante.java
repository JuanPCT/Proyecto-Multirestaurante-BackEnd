package com.multiristorante.app.backend.Entities;

import java.sql.Blob;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Table(name="restaurante")
@Entity
@Data
public class Restaurante {
    
    @Id
    private Integer id;
    private String nombre;
    private String direccion;
    private String telefono;
    private String email;
    private String password;
    private Blob imagen;
    private boolean estado;
    private String url_video;

}