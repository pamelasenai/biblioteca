package com.senai.biblioteca.controller;

import com.senai.biblioteca.entities.LivroEntity;
import com.senai.biblioteca.service.LivroService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/livros")
@RequiredArgsConstructor
public class LivroController {
    private final LivroService livroService;

    @PostMapping
    private LivroEntity criarLivro(@RequestBody LivroEntity livro) throws Exception {
        return livroService.salvarLivro(livro);
    }
}
