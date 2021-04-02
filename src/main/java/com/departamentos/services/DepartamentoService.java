package com.departamentos.services;

import com.departamentos.domain.etities.Departamento;
import com.departamentos.repositories.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartamentoService {

    @Autowired
    private DepartamentoRepository departamentoRepository;

    public Departamento salvar(Departamento departamento) {
        return departamentoRepository.save(departamento);
    }

    public List<Departamento> lista() {
        return departamentoRepository.findAll();
    }
}
