package com.senai.biblioteca.service;

import com.senai.biblioteca.entities.EmprestimoEntity;
import com.senai.biblioteca.repository.EmprestimoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EmprestimoService {
    private final EmprestimoRepository emprestimoRepository;

    public EmprestimoEntity salvarEmprestimo(EmprestimoEntity emprestimo) {
        return emprestimoRepository.save(emprestimo);
    }
}
