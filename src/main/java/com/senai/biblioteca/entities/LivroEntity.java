package com.senai.biblioteca.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "livro")
public class LivroEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String autor;
    @Column(name = "ano_publicacao")
    private Integer anoPublicacao;
}
