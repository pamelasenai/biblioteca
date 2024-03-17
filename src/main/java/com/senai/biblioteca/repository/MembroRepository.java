package com.senai.biblioteca.repository;

import com.senai.biblioteca.entities.MembroEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MembroRepository extends JpaRepository<MembroEntity, Long> {
    @Query(value = "SELECT COUNT(*) FROM emprestimos WHERE id_membro = :id", nativeQuery = true)
    int countVinculos(Long id);

    @Query(
            "update MembroEntity membro set membro.nome = :nome" +
            " membro.endereco = :endereco " +
            " membro.telefone = :telefone" +
            " where membro.id = :id"
    )
    MembroEntity update(
            @Param("nome") String nome,
            @Param("endereco") String endereco,
            @Param("telefone") String telefone
    );
}
