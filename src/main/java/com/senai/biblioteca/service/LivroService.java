package com.senai.biblioteca.service;

import com.senai.biblioteca.entities.LivroEntity;
import com.senai.biblioteca.repository.LivroRepository;
import com.senai.biblioteca.utils.Datas;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LivroService {
    private final LivroRepository livroRepository;

    public LivroEntity salvarLivro(LivroEntity livro) throws Exception {
        if(validar(livro)) {
            return livroRepository.save(livro);
        }
        return null;
    }

    public List<LivroEntity> buscarTodosLivros() {
        return livroRepository.findAll();
    }

    public Optional<LivroEntity> buscarPorId(Long id) {
        return livroRepository.findById(id);
    }

    public boolean deletarLivro(Long id) throws Exception {
        boolean ahVinculos = livroRepository.countVinculos(id) > 0;
        verificarCadastro(id);
        if (ahVinculos){
            throw new IllegalStateException(
                    "O Livro está vinculado a um empréstimo e não pode ser excluído." +
                    "Delete todos os empréstimos deste livro antes de deleta-lo."
            );
        }
        livroRepository.deleteById(id);
        return true;
    }

    public Optional<LivroEntity> atualizarLivro(LivroEntity livro) throws Exception {
        try {
            livroRepository.update(
                    livro.getId(),
                    livro.getTitulo(),
                    livro.getAutor(),
                    livro.getAnoPublicacao()
            );
            return buscarPorId(livro.getId());
        } catch (Exception e) {
            verificarCadastro(livro.getId());
            throw new Exception("Não foi possível atualizar o livro.");
        }
    }

    private void verificarCadastro(Long id) throws Exception {
        if (buscarPorId(id).isEmpty()) {
            throw new IllegalArgumentException("Livro com o ID informado não encontrado.");
        }
    }

    private boolean validar(LivroEntity livro) throws Exception {
        if(
                livro.getTitulo() == null ||
                livro.getTitulo().isBlank()
        ) {
            throw new Exception("Título não pode estar em branco.");
        }
        if (
                livro.getAutor() == null ||
                livro.getAutor().isBlank() ||
                livro.getAutor().length() < 3
        ) {
            throw new Exception("Autor não pode estar em branco e deve conter no mínimo três caracteres.");
        }
        if (
                livro.getAnoPublicacao() == null ||
                livro.getAnoPublicacao() > Datas.anoAtual() ||
                livro.getAnoPublicacao() <= 1000
        ) {
            throw new Exception("Ano de publicação invalido.");
        }
        return true;
    }
}
