package com.senai.biblioteca.controller;

import com.senai.biblioteca.entities.BibliotecarioEntity;
import com.senai.biblioteca.service.BibliotecarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/bibliotecarios")
@RequiredArgsConstructor
public class BibliotecarioController {
    private final BibliotecarioService bibliotecarioService;

    @PostMapping
    public BibliotecarioEntity criarBibliotecario(@RequestBody BibliotecarioEntity bibliotecario) throws Exception {
        return bibliotecarioService.salvarBibliotecario(bibliotecario);
    }

    @GetMapping("/buscar-todos")
    public List<BibliotecarioEntity> buscarTodosBibliotecarios() {
        return bibliotecarioService.buscarTodosBibliotecarios();
    }

    @GetMapping("/id/{id}")
    public Optional<BibliotecarioEntity> buscarPorId(@PathVariable Long id) throws Exception {
        return bibliotecarioService.buscarPorId(id);
    }

    @DeleteMapping("/deletar/{id}")
    public boolean deletarBibliotecario(@PathVariable Long id) throws Exception {
        return bibliotecarioService.deletarBibliotecario(id);
    }

    @PutMapping("/atualizar")
    public Optional<BibliotecarioEntity> atualizarBibliotecario(@RequestBody BibliotecarioEntity bibliotecario) throws Exception {
        return bibliotecarioService.atualizarBibliotecario(bibliotecario);
    }
}
