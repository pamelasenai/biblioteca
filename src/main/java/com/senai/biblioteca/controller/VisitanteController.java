package com.senai.biblioteca.controller;

import com.senai.biblioteca.entities.VisitanteEntity;
import com.senai.biblioteca.service.VisitanteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vistantes")
@RequiredArgsConstructor
public class VisitanteController {
    private final VisitanteService visitanteService;

    @PostMapping
    private VisitanteEntity criarVisitante(@RequestBody VisitanteEntity visitante) throws Exception {
        return visitanteService.salvarVisitante((visitante));
    }
}
