package com.multiristorante.app.backend.models.requests;

import lombok.Data;

@Data
public class UsuarioDetailsRequestModel {
    
    private int documento;
    private String nombre;
    private String apellido;
    private String telefono;
    private String email;
    private String password;
    private String fecha_nacimiento;
}
