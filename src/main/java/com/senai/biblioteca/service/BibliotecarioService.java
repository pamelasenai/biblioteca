package com.senai.biblioteca.service;

import com.senai.biblioteca.entities.BibliotecarioEntity;
import com.senai.biblioteca.repository.BibliotecarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BibliotecarioService {
    private final BibliotecarioRepository bibliotecarioRepository;

    public BibliotecarioEntity salvarBibliotecario(BibliotecarioEntity bibliotecario) throws Exception {
        if (validar(bibliotecario)){
            return bibliotecarioRepository.save(bibliotecario);
        }
        return null;
    }

    public List<BibliotecarioEntity> buscarTodosBibliotecarios() {
        return bibliotecarioRepository.findAll();
    }

    public Optional<BibliotecarioEntity> buscarPorId(Long id) throws Exception {
        try {
            return bibliotecarioRepository.findById(id);
        } catch (Exception e) {
            throw new Exception("Bibliotecário com o ID informado não encontrado.");
        }
    }

    public boolean deletarBibliotecario(Long id) throws Exception {
        verificarCadastro(id);
        boolean ahVinculos = bibliotecarioRepository.countVinculos(id) > 0;
        if (ahVinculos){
            throw new IllegalStateException(
                    "O bibliotecário está vinculado a um empréstimo e não pode ser excluído." +
                    "Delete todos os empréstimos deste bibliotecário antes de deleta-lo."
            );
        }
        bibliotecarioRepository.deleteById(id);
        return true;
    }

    public Optional<BibliotecarioEntity> atualizarBibliotecario(BibliotecarioEntity bibliotecario) throws Exception {
        try {
            bibliotecarioRepository.update(
                    bibliotecario.getId(),
                    bibliotecario.getNome(),
                    bibliotecario.getEmail(),
                    bibliotecario.getSenha()
            );
            return buscarPorId(bibliotecario.getId());
        } catch (Exception e) {
            verificarCadastro(bibliotecario.getId());
            throw new Exception("Não foi possível atualizar bibliotecário.");
        }
    }

    private void verificarCadastro(Long id) throws Exception {
        if (buscarPorId(id).isEmpty()) {
            throw new IllegalArgumentException("Bibliotecário com o ID informado não encontrado.");
        }
    }

    private boolean validar(BibliotecarioEntity bibliotecario) throws Exception {
        if(
            bibliotecario.getNome() == null ||
            bibliotecario.getNome().isBlank() ||
            bibliotecario.getNome().length() < 3
        ) {
            throw new Exception("Nome não pode estar em branco e deve conter no mínimo três caracteres.");
        }
        if (
            bibliotecario.getSenha() == null ||
            bibliotecario.getSenha().isBlank() ||
            bibliotecario.getSenha().length() < 8
        ) {
            throw new Exception("Senha não pode estar em branco e deve conter no mínimo oito caracteres.");
        }
        if (
                bibliotecario.getEmail() == null ||
                bibliotecario.getEmail().isBlank() ||
                !bibliotecario.getEmail().contains("@") ||
                !bibliotecario.getEmail().contains(".")
        ) {
            throw new Exception("Email não é valido.");
        }
        return true;
    }
}
