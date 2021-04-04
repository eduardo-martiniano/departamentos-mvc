package com.departamentos.services;

import com.departamentos.domain.etities.Funcionario;
import com.departamentos.repositories.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    public void salvar(Funcionario funcionario) {
        funcionarioRepository.save(funcionario);
    }

    public List<Funcionario> lista() {
        return funcionarioRepository.findAll();
    }

    public void excluir(Long id) {
        funcionarioRepository.delete(funcionarioRepository.findById(id).orElse(null));
    }
}
