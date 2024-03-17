package com.senai.biblioteca.repository;

import com.senai.biblioteca.entities.BibliotecarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BibliotecarioRepository extends JpaRepository<BibliotecarioEntity, Long> {
    @Query(value = "SELECT COUNT(*) FROM emprestimos WHERE id_bibliotecario = :id", nativeQuery = true)
    int countVinculos(Long id);
}
