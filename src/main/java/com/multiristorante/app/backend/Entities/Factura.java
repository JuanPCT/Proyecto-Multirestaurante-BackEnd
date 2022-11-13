package com.multiristorante.app.backend.Entities;

import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Table(name="factura")
@Entity
@Data
public class Factura {
    
    @Id
    private int id;

    private int documento;

    private Date fecha;
}
