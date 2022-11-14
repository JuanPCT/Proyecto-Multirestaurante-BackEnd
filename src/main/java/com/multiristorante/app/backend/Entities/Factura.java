package com.multiristorante.app.backend.Entities;

import java.sql.Date;

import javax.persistence.*;

import lombok.Data;

@Table(name="factura")
@Entity
@Data
@SequenceGenerator(name = "SQ_CUSTOMER", sequenceName = "SQ_CUSTOMER")
public class Factura {
    
    @Id
    private int id_factura;
    @ManyToOne
    @JoinColumn(name = "documento")
    private Usuario documento;
    private Date fecha;

}
