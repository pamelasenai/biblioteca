package com.senai.biblioteca.controller;

import com.senai.biblioteca.entities.EmprestimoEntity;
import com.senai.biblioteca.repository.EmprestimoRepository;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/emprestimos")
public class EmprestimoController {
    private final EmprestimoRepository emprestimoRepository;

    public EmprestimoController(EmprestimoRepository emprestimoRepository) {
        this.emprestimoRepository = emprestimoRepository;
    }

    @PostMapping
    private EmprestimoEntity criarEmprestimo(@RequestBody EmprestimoEntity emprestimo){
        return emprestimoRepository.save(emprestimo);
    }
}
