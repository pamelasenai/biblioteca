package com.senai.biblioteca.controller;

import com.senai.biblioteca.entities.EmprestimoEntity;
import com.senai.biblioteca.service.EmprestimoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/emprestimos")
@RequiredArgsConstructor
public class EmprestimoController {
    private final EmprestimoService emprestimoService;

    @PostMapping
    private EmprestimoEntity criarEmprestimo(@RequestBody EmprestimoEntity emprestimo){
        return emprestimoService.salvarEmprestimo(emprestimo);
    }
}
