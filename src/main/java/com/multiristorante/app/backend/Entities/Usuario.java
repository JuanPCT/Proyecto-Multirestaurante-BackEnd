package com.multiristorante.app.backend.Entities;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import java.util.Date;

@Entity
@Data
@Table(name = "usuario")
public class Usuario {

    @Id
    private int documento;
    @NotEmpty
    private String nombre;

    private String apellido;

    private String telefono;

    private String email;

    private String password;
<<<<<<< HEAD

    private boolean estado;

=======
    private Boolean estado;
>>>>>>> 3d9d87e28868adae449eda7b7cdc7cf3fd3710ef
    private Date fecha_nacimiento;

    private Date fecha_creacion;
    
    @ManyToOne
    @JoinColumn(name="Rol_id")
    private Rol id;
}
