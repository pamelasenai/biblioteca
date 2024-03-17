package com.senai.biblioteca.service;

import com.senai.biblioteca.entities.MembroEntity;
import com.senai.biblioteca.repository.MembroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MembroService {
    private final MembroRepository membroRepository;

    public MembroEntity salvarMembro(MembroEntity membro) throws Exception {
        if(validar(membro)) {
            return membroRepository.save(membro);
        }
        return null;
    }

    public List<MembroEntity> buscarTodosMembros() {
        return membroRepository.findAll();
    }

    public Optional<MembroEntity> buscarPorId(Long id) {
        return membroRepository.findById(id);
    }

    private boolean validar(MembroEntity membro) throws Exception {
        if(
                membro.getNome() == null ||
                membro.getNome().isBlank() ||
                membro.getNome().length() < 3
        ) {
            throw new Exception("Nome não pode estar em branco e deve conter no mínimo três caracteres.");
        }
        if (
                membro.getEndereco() == null ||
                membro.getEndereco().isBlank() ||
                membro.getEndereco().length() < 8
        ) {
            throw new Exception("Endereço não pode estar em branco e deve conter no mínimo oito caracteres.");
        }
        if (
                membro.getTelefone() == null ||
                membro.getTelefone().isBlank() ||
                membro.getTelefone().length() < 10
        ) {
            throw new Exception("Telefone não é valido.");
        }
        return true;
    }
}
