package com.senai.biblioteca.repository;

import com.senai.biblioteca.entities.EmprestimoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EmprestimoRepository extends JpaRepository<EmprestimoEntity, Long> {
    @Query(
            "update EmprestimoEntity emprestimo set emprestimo.dataEmprestimo = :dataEmprestimo" +
            " emprestimo.dataDevolucao = :dataDevolucao " +
            " emprestimo.livro = :livro" +
            " emprestimo.membro = :membro" +
            " emprestimo.bibliotecario = :bibliotecario" +
            " where emprestimo.id = :id"
    )
    EmprestimoEntity update(
            @Param("dataEmprestimo") String dataEmprestimo,
            @Param("dataDevolucao") String dataDevolucao,
            @Param("livro") Long livro,
            @Param("membro") Long membro,
            @Param("bibliotecario") Long bibliotecario
    );
}
