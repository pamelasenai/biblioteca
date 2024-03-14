package com.senai.biblioteca.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "visitante")
public class VisitanteEntity {
    @Id
    private Integer id;

    private String nome;
    private String telefone;
}
