package com.multiristorante.app.backend.Entities;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Data
@Table(name = "solicitud")
public class Solicitud implements Serializable {
    @Id
    private int id;
    @ManyToOne
    @JoinColumn(name = "documentoA")
    private AdminR documento;
    private String descripcion;
    private String imagen;
    private Boolean estado;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private Date fecha;
}
