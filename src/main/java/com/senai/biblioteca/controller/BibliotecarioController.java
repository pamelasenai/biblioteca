package com.senai.biblioteca.controller;

import com.senai.biblioteca.entities.BibliotecarioEntity;
import com.senai.biblioteca.repository.BibliotecarioRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bibliotecarios")
public class BibliotecarioController {
    private final BibliotecarioRepository bibliotecarioRepository;

    public BibliotecarioController(BibliotecarioRepository bibliotecarioRepository) {
        this.bibliotecarioRepository = bibliotecarioRepository;
    }

    @PostMapping
    private BibliotecarioEntity criarBibliotecario(@RequestBody BibliotecarioEntity bibliotecario){
        return bibliotecarioRepository.save(bibliotecario);
    }
}
