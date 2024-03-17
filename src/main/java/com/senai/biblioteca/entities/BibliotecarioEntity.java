package com.senai.biblioteca.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "bibliotecario")
public class BibliotecarioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;
    private String senha;
}
