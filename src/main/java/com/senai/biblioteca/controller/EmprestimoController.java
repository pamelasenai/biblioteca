package com.senai.biblioteca.controller;

import com.senai.biblioteca.entities.EmprestimoEntity;
import com.senai.biblioteca.service.EmprestimoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/emprestimos")
@RequiredArgsConstructor
public class EmprestimoController {
    private final EmprestimoService emprestimoService;

    @PostMapping
    public EmprestimoEntity criarEmprestimo(@RequestBody EmprestimoEntity emprestimo) throws Exception {
        return emprestimoService.salvarEmprestimo(emprestimo);
    }

    @GetMapping("/buscar-todos")
    public List<EmprestimoEntity> buscarTodosEmprestimos() {
        return emprestimoService.buscarTodosEmprestimos();
    }

    @GetMapping("/id/{id}")
    public Optional<EmprestimoEntity> buscarPorId(@PathVariable Long id) {
        return emprestimoService.buscarPorId(id);
    }

    @DeleteMapping("/deletar/{id}")
    public boolean deletarEmprestimo(@PathVariable Long id) throws Exception {
        return emprestimoService.deletarEmprestimo(id);
    }

    @PutMapping("/atualizar")
    public Optional<EmprestimoEntity> atualizarEmprestimo(@RequestBody EmprestimoEntity emprestimo) throws Exception {
        return emprestimoService.atualizarEmprestimo(emprestimo);
    }
}
