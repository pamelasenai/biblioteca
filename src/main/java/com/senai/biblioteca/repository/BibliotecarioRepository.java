package com.senai.biblioteca.repository;

import com.senai.biblioteca.entities.BibliotecarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface BibliotecarioRepository extends JpaRepository<BibliotecarioEntity, Long> {
    @Query(value = "SELECT COUNT(*) FROM emprestimos WHERE id_bibliotecario = :id", nativeQuery = true)
    int countVinculos(Long id);

    @Modifying
    @Transactional
    @Query("UPDATE BibliotecarioEntity b SET b.nome = :nome, b.email = :email, b.senha = :senha WHERE b.id = :id")
    void update(
            @Param("id") Long id,
            @Param("nome") String nome,
            @Param("email") String email,
            @Param("senha") String senha
    );
}
