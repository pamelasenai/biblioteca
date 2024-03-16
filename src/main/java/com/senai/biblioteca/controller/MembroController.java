package com.senai.biblioteca.controller;

import com.senai.biblioteca.entities.MembroEntity;
import com.senai.biblioteca.service.MembroService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/membros")
@RequiredArgsConstructor
public class MembroController {
    private final MembroService membroService;

    @PostMapping
    private MembroEntity criarMembro(@RequestBody MembroEntity membro){
        return membroService.salvarMembro(membro);
    }
}
