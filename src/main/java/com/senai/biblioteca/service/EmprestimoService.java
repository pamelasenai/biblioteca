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
