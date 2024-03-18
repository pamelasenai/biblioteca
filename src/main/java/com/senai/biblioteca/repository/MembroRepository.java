package com.senai.biblioteca.repository;

import com.senai.biblioteca.entities.MembroEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface MembroRepository extends JpaRepository<MembroEntity, Long> {
    @Query(value = "SELECT COUNT(*) FROM emprestimos WHERE id_membro = :id", nativeQuery = true)
    int countVinculos(Long id);

    @Modifying
    @Transactional
    @Query("UPDATE MembroEntity m SET m.nome = :nome, m.endereco = :endereco, m.telefone = :telefone WHERE m.id = :id")
    void update(
            @Param("id") Long id,
            @Param("nome") String nome,
            @Param("endereco") String endereco,
            @Param("telefone") String telefone
    );
}
