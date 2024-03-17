package com.senai.biblioteca.controller;

import com.senai.biblioteca.entities.VisitanteEntity;
import com.senai.biblioteca.service.VisitanteService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/vistantes")
@RequiredArgsConstructor
public class VisitanteController {
    private final VisitanteService visitanteService;

    @PostMapping
    public VisitanteEntity criarVisitante(@RequestBody VisitanteEntity visitante) throws Exception {
        return visitanteService.salvarVisitante((visitante));
    }

    @GetMapping("/buscar-todos")
    public List<VisitanteEntity> buscarTodosVisitantes() {
        return visitanteService.buscarTodosVisitantes();
    }

    @GetMapping("/id/{id}")
    public Optional<VisitanteEntity> buscarPorId(@PathVariable Long id) {
        return visitanteService.buscarPorId(id);
    }

    @DeleteMapping("/deletar/{id}")
    public boolean deletarVisitante(@PathVariable Long id) {
        return visitanteService.deletarVisitante(id);
    }
}
