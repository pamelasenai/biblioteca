package com.senai.biblioteca.controller;

import com.senai.biblioteca.entities.MembroEntity;
import com.senai.biblioteca.service.MembroService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/membros")
@RequiredArgsConstructor
public class MembroController {
    private final MembroService membroService;

    @PostMapping
    public MembroEntity criarMembro(@RequestBody MembroEntity membro) throws Exception {
        return membroService.salvarMembro(membro);
    }

    @GetMapping
    public List<MembroEntity> buscarTodosMembros() {
        return membroService.buscarTodosMembros();
    }

    @GetMapping("{id}")
    public Optional<MembroEntity> buscarPorId(@PathVariable Long id) {
        return membroService.buscarPorId(id);
    }

    @DeleteMapping("{id}")
    public boolean deletarMembro(@PathVariable Long id) {
        return membroService.deletarMembro(id);
    }
}
