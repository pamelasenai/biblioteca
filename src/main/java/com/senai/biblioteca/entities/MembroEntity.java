package com.senai.biblioteca.entities;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "membros")
public class MembroEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String endereco;
    private String telefone;
}
