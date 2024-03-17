package com.senai.biblioteca.service;

import com.senai.biblioteca.entities.VisitanteEntity;
import com.senai.biblioteca.repository.VisitanteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VisitanteService {
    private final VisitanteRepository visitanteRepository;

    public VisitanteEntity salvarVisitante(VisitanteEntity visitante) throws Exception {
        if(validar(visitante)) {
            return visitanteRepository.save(visitante);
        }
        return null;
    }

    private boolean validar(VisitanteEntity visitante) throws Exception {
        if(
                visitante.getNome() == null ||
                visitante.getNome().isBlank() ||
                visitante.getNome().length() < 3
        ) {
            throw new Exception("Nome não pode estar em branco e deve conter no mínimo três caracteres.");
        }
        if (
                visitante.getTelefone() == null ||
                visitante.getTelefone().isBlank() ||
                visitante.getTelefone().length() < 10
        ) {
            throw new Exception("Telefone não é valido.");
        }
        return true;
    }
}
