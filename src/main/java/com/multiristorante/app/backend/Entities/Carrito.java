package com.multiristorante.app.backend.Entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class Carrito {
    
    @Id
    private int id_carrito;

    @ManyToOne
    @JoinColumn(name = "producto_id",insertable = false,updatable = false)
    private Producto producto;

    @ManyToOne
    @JoinColumn(name = "user_id",insertable = false,updatable = false)
    private Usuario usuario;

}
