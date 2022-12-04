package com.multiristorante.app.backend.Models.requests;

import lombok.Data;

@Data
public class UsuarioLoginRequestModel {
    private String email;
    private String password;
}
