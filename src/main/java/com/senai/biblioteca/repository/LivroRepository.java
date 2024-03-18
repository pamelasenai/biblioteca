package com.senai.biblioteca.repository;

import com.senai.biblioteca.entities.LivroEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface LivroRepository extends JpaRepository<LivroEntity, Long> {
    @Query(value = "SELECT COUNT(*) FROM emprestimos WHERE id_livro = :id", nativeQuery = true)
    int countVinculos(Long id);

    @Modifying
    @Transactional
    @Query("UPDATE LivroEntity l SET l.titulo = :titulo, l.autor = :autor, l.anoPublicacao = :anoPublicacao WHERE l.id = :id")
    void update(
            @Param("id") Long id,
            @Param("titulo") String titulo,
            @Param("autor") String autor,
            @Param("anoPublicacao") Integer anoPublicacao
    );
}
