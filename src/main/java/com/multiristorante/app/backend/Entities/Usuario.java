package com.multiristorante.app.backend.Entities;

import lombok.Data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Data
@Entity(name = "usuario")
@Table(indexes = { @Index(columnList = "userId", name = "index_userid", unique = true),
@Index(columnList = "email", name = "index_email", unique = true)})
public class Usuario implements Serializable{

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue
    private long id;

    @Column(nullable = false)
    public String userId;

    @Column(nullable = false, length = 50)
    private String nombre;

    @Column(nullable = false, length = 50)
    private String apellido;

    @Column(nullable = false, length = 10)
    private String telefono;

    @Column(nullable = false, length = 255)
    private String email;

    @Column(nullable = false)
    private String encryptedPassword;

    @Column(nullable = false)   
    private String fecha_nacimiento;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Comentarios> comentarios = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "usuario")
    private List<Carrito> carritos = new ArrayList<>();
}
