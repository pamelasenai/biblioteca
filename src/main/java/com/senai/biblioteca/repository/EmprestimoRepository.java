package com.senai.biblioteca.repository;

import com.senai.biblioteca.entities.BibliotecarioEntity;
import com.senai.biblioteca.entities.EmprestimoEntity;
import com.senai.biblioteca.entities.LivroEntity;
import com.senai.biblioteca.entities.MembroEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface EmprestimoRepository extends JpaRepository<EmprestimoEntity, Long> {
    @Modifying
    @Transactional
    @Query("UPDATE EmprestimoEntity e SET e.dataEmprestimo = :dataEmprestimo, " +
            "e.dataDevolucao = :dataDevolucao, " +
            "e.livro = :livro, " +
            "e.membro = :membro, " +
            "e.bibliotecario = :bibliotecario " +
            "WHERE e.id = :id"
    )
    void update(
            @Param("id") Long id,
            @Param("dataEmprestimo") String dataEmprestimo,
            @Param("dataDevolucao") String dataDevolucao,
            @Param("livro") LivroEntity livro,
            @Param("membro") MembroEntity membro,
            @Param("bibliotecario") BibliotecarioEntity bibliotecario
    );
}
