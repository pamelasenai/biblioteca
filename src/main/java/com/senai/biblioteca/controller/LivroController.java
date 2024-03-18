package com.senai.biblioteca.controller;

import com.senai.biblioteca.entities.LivroEntity;
import com.senai.biblioteca.service.LivroService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/livros")
@RequiredArgsConstructor
public class LivroController {
    private final LivroService livroService;

    @PostMapping
    public LivroEntity criarLivro(@RequestBody LivroEntity livro) throws Exception {
        return livroService.salvarLivro(livro);
    }

    @GetMapping("/buscar-todos")
    public List<LivroEntity> buscarTodosLivros() {
        return livroService.buscarTodosLivros();
    }

    @GetMapping("/id/{id}")
    public Optional<LivroEntity> buscarPorId(@PathVariable Long id) {
        return livroService.buscarPorId(id);
    }

    @DeleteMapping("/deletar/{id}")
    public boolean deletarLivro(@PathVariable Long id) throws Exception {
        return livroService.deletarLivro(id);
    }

    @PutMapping("/atualizar")
    public Optional<LivroEntity> atualizarLivro(@RequestBody LivroEntity livro) throws Exception {
        return livroService.atualizarLivro(livro);
    }
}
