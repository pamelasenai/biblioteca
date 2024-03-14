package com.senai.biblioteca.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "membros")
public class MembroEntity {
    @Id
    private Integer id;

    private String nome;
    private String endereco;
    private String telefone;
}
