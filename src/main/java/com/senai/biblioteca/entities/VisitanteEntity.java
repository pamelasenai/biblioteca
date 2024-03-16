package com.senai.biblioteca.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "visitante")
public class VisitanteEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String telefone;
}
