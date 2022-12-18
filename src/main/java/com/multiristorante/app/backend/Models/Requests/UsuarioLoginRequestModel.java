package com.multiristorante.app.backend.models.requests;

import lombok.Data;

@Data
public class UsuarioLoginRequestModel {
    private String email;
    private String password;
}
