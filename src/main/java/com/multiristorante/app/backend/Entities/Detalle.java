package com.multiristorante.app.backend.Entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@Table(name = "detalle")
@IdClass(DetallePK.class)
public class Detalle implements Serializable {
    @Id
    private int id_detalle;
    @Id
    private int id_factura;
    @ManyToOne
    @JoinColumn(name = "id_factura",insertable = false,updatable = false)
    private Factura factura;

    @ManyToOne
    @JoinColumn(name = "id_producto")
    private Producto id_producto;
    private int cantidad;
    private double precio;



}
