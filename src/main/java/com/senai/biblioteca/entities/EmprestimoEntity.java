package com.senai.biblioteca.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "emprestimos")
public class EmprestimoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "data_emprestimo")
    private String dataEmprestimo;
    @Column(name = "data_devolucao")
    private String dataDevolucao;

    @ManyToOne
    @JoinColumn(name = "id_livro", referencedColumnName = "id")
    private LivroEntity idLivro;

    @ManyToOne
    @JoinColumn(name = "id_membro", referencedColumnName = "id")
    private MembroEntity idMembro;

    @ManyToOne
    @JoinColumn(name = "id_bibliotecario", referencedColumnName = "id")
    private BibliotecarioEntity idBibliotecario;
}
