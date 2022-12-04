package com.multiristorante.app.backend.Entities;


import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import lombok.Data;

@Table(name="restaurante")
@Entity
@Data
public class Restaurante {
    
    @Id
    @GeneratedValue
    private Integer restaurante_id;
    @Column(nullable = false)
    private String nombre;
    @Column(nullable = false)
    private String direccion;
    @Column(nullable = false)
    private String telefono;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String imagen;
    @Column
    private String url_video;

    @ManyToOne
    @JoinColumn(name = "categoria_id",insertable = false,updatable = false)
    private Categoria categoria_id;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "restaurante")
    private List<Comentarios> comentarios = new ArrayList<>();

}