package com.departamentos.services;

import com.departamentos.domain.etities.Cargo;
import com.departamentos.domain.etities.Departamento;
import com.departamentos.repositories.CargoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CargoService {

    @Autowired
    private CargoRepository cargoRepository;

    public void salvar(Cargo cargo) {
        cargoRepository.save(cargo);
    }

    public List<Cargo> lista() {
        return cargoRepository.findAll();
    }

    public void excluir(Long id) {
        cargoRepository.delete(cargoRepository.findById(id).orElse(null));
    }

    public void editar(Cargo cargo) {
        cargoRepository.findById(cargo.getId()).map(c -> {
            c.setNome(cargo.getNome());
            c.setDepartamento(cargo.getDepartamento());
            cargoRepository.save(c);
            return true;
        });
    }
}
