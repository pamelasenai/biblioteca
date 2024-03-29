package com.senai.biblioteca.service;

import com.senai.biblioteca.entities.EmprestimoEntity;
import com.senai.biblioteca.repository.EmprestimoRepository;
import com.senai.biblioteca.utils.Datas;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class EmprestimoService {
    private final EmprestimoRepository emprestimoRepository;

    public EmprestimoEntity salvarEmprestimo(EmprestimoEntity emprestimo) throws Exception {
        if(validar(emprestimo)) {
            return emprestimoRepository.save(emprestimo);
        }
        return null;
    }

    public List<EmprestimoEntity> buscarTodosEmprestimos() {
        return emprestimoRepository.findAll();
    }

    public Optional<EmprestimoEntity> buscarPorId(Long id) {
        return emprestimoRepository.findById(id);
    }

    public boolean deletarEmprestimo(Long id) throws Exception {
        verificarCadastro(id);
        emprestimoRepository.deleteById(id);
        return true;
    }

    public Optional<EmprestimoEntity> atualizarEmprestimo(EmprestimoEntity emprestimo) throws Exception {
        try {
            emprestimoRepository.update(
                    emprestimo.getId(),
                    emprestimo.getDataEmprestimo(),
                    emprestimo.getDataDevolucao(),
                    emprestimo.getLivro(),
                    emprestimo.getMembro(),
                    emprestimo.getBibliotecario()
            );
            return buscarPorId(emprestimo.getId());
        } catch (Exception e){
            verificarCadastro(emprestimo.getId());
            throw new Exception("Não foi possível atualizar empréstimo.");
        }
    }

    private void verificarCadastro(Long id) {
        if (buscarPorId(id).isEmpty()) {
            throw new IllegalArgumentException("Empréstimo com o ID informado não encontrado.");
        }
    }

    private boolean validar(EmprestimoEntity emprestimo) throws Exception {
        if(emprestimo.getDataEmprestimo() == null || ehDataInvalida(emprestimo.getDataEmprestimo())){
            throw new Exception("Data deve estar no formato: DD/MM/AAAA.");
        }
        if(emprestimo.getDataDevolucao() == null || ehDataInvalida(emprestimo.getDataDevolucao())){
            throw new Exception("Data deve estar no formato: DD/MM/AAAA.");
        }
        return true;
    }

    private boolean ehDataInvalida(String dataString) throws Exception {
        try {
            Datas.stringToDate(dataString);
            return false;
        } catch (ParseException e) {
            return true;
        }
    }
}
