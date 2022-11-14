package com.multiristorante.app.backend.Entities;

import javax.persistence.*;

import lombok.Data;

@Table(name="menu")
@Entity
@Data
public class Menu {
    
    @Id
    private int Menu_id;

    private String tipo;
    @ManyToOne
    @JoinColumn(name = "id_restaurante")
    private Restaurante id;
}
