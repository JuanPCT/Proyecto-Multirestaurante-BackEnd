package com.multiristorante.app.backend.Entities;

import lombok.Data;

import javax.persistence.Column;
import java.io.Serializable;

@Data
public class DetallePK implements Serializable {
    @Column(name = "id_factura")
    private int id_factura;
    private int id_detalle;
}
