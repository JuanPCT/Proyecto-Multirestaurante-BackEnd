package com.multiristorante.app.backend.Entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "adminr")
public class AdminR {
    @Id
    private int documento;
    private String nombre;
    private String apellido;
    private String telefono;
    private String email;
    private String password;
    @ManyToOne
    @JoinColumn(name = "Rol_id")
    private Rol id_rol;
    @ManyToOne
    @JoinColumn(name = "id_Restaurante", insertable = false, updatable = false)
    private Restaurante id;

}
