package com.senai.biblioteca.controller;

import com.senai.biblioteca.entities.LivroEntity;
import com.senai.biblioteca.entities.VisitanteEntity;
import com.senai.biblioteca.repository.LivroRepository;
import com.senai.biblioteca.repository.VisitanteRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vistantes")
public class VisitanteController {
    private final VisitanteRepository visitanteRepository;

    public VisitanteController(VisitanteRepository visitanteRepository) {
        this.visitanteRepository = visitanteRepository;
    }


    @PostMapping
    private VisitanteEntity criarVisitante(@RequestBody VisitanteEntity visitante){
        return visitanteRepository.save(visitante);
    }
}
