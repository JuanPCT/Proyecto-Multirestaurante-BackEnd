package com.multiristorante.app.backend.Entities;


import javax.persistence.*;

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
    private String imagen;
    private Boolean estado;
    private String url_video;
    @ManyToOne
    @JoinColumn(name = "id",insertable = false,updatable = false)
    private Categoria categoria_id;

}