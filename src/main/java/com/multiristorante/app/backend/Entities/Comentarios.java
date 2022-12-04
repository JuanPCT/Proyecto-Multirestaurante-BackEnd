package com.multiristorante.app.backend.Entities;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "comentarios")
@Table
public class Comentarios {

    @Id
    @GeneratedValue
    private int comentario_id;

    @ManyToOne
    @JoinColumn(name = "restaurante_id")
    private Restaurante restaurante;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Usuario user;

    @Column(nullable = false)
    private String descripcion;

    @Column(nullable = false)
    private double calificacion;

}
