package com.senai.biblioteca.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "livro")
public class LivroEntity {
    @Id
    private Integer id;

    private String titulo;
    private String autor;
    @Column(name = "ano_publicacao")
    private Integer anoPublicacao;
}
