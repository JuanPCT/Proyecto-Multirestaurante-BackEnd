package com.multiristorante.app.backend.Shared.dto;

import java.io.Serializable;

import lombok.Data;

@Data
public class UsuarioDto implements Serializable {
    
    private static final long serialVersionUID = 1L;

    private long id;
    private String userId;
    private int documento;
    private String nombre;
    private String apellido;
    private String telefono;
    private String email;
    private String password;
    private String encriptedPassword;
    private Boolean estado;
    private String fecha_nacimiento;
}
