package com.senai.biblioteca.repository;

import com.senai.biblioteca.entities.LivroEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LivroRepository extends JpaRepository<LivroEntity, Long> {
    @Query(value = "SELECT COUNT(*) FROM emprestimos WHERE id_livro = :id", nativeQuery = true)
    int countVinculos(Long id);

    @Query(
            "update LivroRepository livro set livro.titulo = :titulo" +
            " livro.autor = :autor " +
            " livro.senha = :senha" +
            " livro.anoPublicacao = :anoPublicacao" +
            " where livro.id = :id"
    )
    LivroRepository update(
            @Param("titulo") String titulo,
            @Param("autor") String autor,
            @Param("anoPublicacao") Integer anoPublicacao
    );
}
