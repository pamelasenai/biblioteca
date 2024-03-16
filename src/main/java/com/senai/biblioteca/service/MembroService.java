package com.senai.biblioteca.service;

import com.senai.biblioteca.entities.MembroEntity;
import com.senai.biblioteca.repository.MembroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MembroService {
    private final MembroRepository membroRepository;

    public MembroEntity salvarMembro(MembroEntity membro) {
        return membroRepository.save(membro);
    }
}
