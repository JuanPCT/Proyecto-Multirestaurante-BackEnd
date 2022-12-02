package com.multiristorante.app.backend.Entities;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
@Table(name = "usuario")
public class Usuario {
    @Id
    private int documento;
    private String nombre;
    private String apellido;
    private String telefono;
    private String email;
    private String password;
    private Boolean estado;
    private Date fecha_nacimiento;
    private Date fecha_creacion;
    @ManyToOne
    @JoinColumn(name="Rol_id")
    private Rol id;
}
