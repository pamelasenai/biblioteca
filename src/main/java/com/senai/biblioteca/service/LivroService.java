package com.senai.biblioteca.service;

import com.senai.biblioteca.entities.LivroEntity;
import com.senai.biblioteca.repository.LivroRepository;
import com.senai.biblioteca.utils.Datas;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
