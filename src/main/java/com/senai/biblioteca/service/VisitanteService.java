package com.senai.biblioteca.service;

import com.senai.biblioteca.entities.VisitanteEntity;
import com.senai.biblioteca.repository.VisitanteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    public List<VisitanteEntity> buscarTodosVisitantes() {
        return visitanteRepository.findAll();
    }

    public Optional<VisitanteEntity> buscarPorId(Long id) {
        return visitanteRepository.findById(id);
    }

    public boolean deletarVisitante(Long id) {
        if (buscarPorId(id).isEmpty()) {
            throw new IllegalArgumentException("Visitante com o ID " + id + " não encontrado.");
        }
        visitanteRepository.deleteById(id);
        return true;
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
