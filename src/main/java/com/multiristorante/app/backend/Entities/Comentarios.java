package com.multiristorante.app.backend.Entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "comentarios")
public class Comentarios {
    @Id
    private int id;
    @ManyToOne
    @JoinColumn(name = "id_restaurante")
    private Restaurante id_restaurante;
    @ManyToOne
    @JoinColumn(name = "documentoU")
    private Usuario documento;
    private String descripcion;
    private double calificacion;
}
