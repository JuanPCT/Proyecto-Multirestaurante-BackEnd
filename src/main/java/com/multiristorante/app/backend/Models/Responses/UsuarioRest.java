package com.multiristorante.app.backend.models.responses;

import lombok.Data;

@Data
public class UsuarioRest {
    
    private String userId;
    private int documento;
    private String nombre;
    private String telefono;
    private String email;
    private String fecha_nacimiento;
}
