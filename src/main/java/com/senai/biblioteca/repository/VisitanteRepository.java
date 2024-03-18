package com.senai.biblioteca.repository;

import com.senai.biblioteca.entities.VisitanteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface VisitanteRepository extends JpaRepository<VisitanteEntity, Long> {
    @Modifying
    @Transactional
    @Query("UPDATE VisitanteEntity v SET v.nome = :nome, v.telefone = :telefone WHERE v.id = :id")
    void update(
            @Param("id") Long id,
            @Param("nome") String nome,
            @Param("telefone") String telefone
    );
}
