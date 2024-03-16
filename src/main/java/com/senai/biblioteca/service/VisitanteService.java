package com.senai.biblioteca.service;

import com.senai.biblioteca.entities.VisitanteEntity;
import com.senai.biblioteca.repository.VisitanteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VisitanteService {
    private final VisitanteRepository visitanteRepository;

    public VisitanteEntity salvarVisitante(VisitanteEntity visitante) {
        return visitanteRepository.save(visitante);
    }
}
