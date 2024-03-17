package com.senai.biblioteca.repository;

import com.senai.biblioteca.entities.LivroEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroRepository extends JpaRepository<LivroEntity, Long> {
    @Query(value = "SELECT COUNT(*) FROM emprestimos WHERE id_livro = :id", nativeQuery = true)
    int countVinculos(Long id);
}
