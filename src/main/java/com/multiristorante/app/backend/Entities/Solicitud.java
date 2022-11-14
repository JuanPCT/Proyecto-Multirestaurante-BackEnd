package com.multiristorante.app.backend.Entities;

import lombok.Data;

import javax.persistence.*;
import java.sql.Blob;
import java.util.Date;

@Entity
@Data
@Table(name = "solicitud")
public class Solicitud {
    @Id
    private int id;
    @ManyToOne
    @JoinColumn(name = "documentoA")
    private AdminR documento;
    private String descripcion;
    private Blob imagen;
    private boolean estado;
    private Date fecha;
}
