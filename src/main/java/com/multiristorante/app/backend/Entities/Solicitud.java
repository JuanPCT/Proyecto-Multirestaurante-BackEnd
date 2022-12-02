package com.multiristorante.app.backend.Entities;

import lombok.Data;

import javax.persistence.*;
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
    private String imagen;
    private Boolean estado;
    private Date fecha;
}
