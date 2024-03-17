package com.senai.biblioteca.controller;

import com.senai.biblioteca.entities.BibliotecarioEntity;
import com.senai.biblioteca.service.BibliotecarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/bibliotecarios")
@RequiredArgsConstructor
public class BibliotecarioController {
    private final BibliotecarioService bibliotecarioService;

    @PostMapping
    private BibliotecarioEntity criarBibliotecario(@RequestBody BibliotecarioEntity bibliotecario) throws Exception {
        return bibliotecarioService.salvarBibliotecario(bibliotecario);
    }
}
