package com.example.SCHapi.service;

import com.example.SCHapi.exception.RegraNegocioException;
import com.example.SCHapi.model.entity.*;
import com.example.SCHapi.model.repository.CargoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;



@Service
public class CargoService {

    private CargoRepository repository;

    public CargoService(CargoRepository repository) {
        this.repository = repository;
    }

    public List<Cargo> getCargos() {
        return repository.findAll();
    }

    public Optional<Cargo> getCargoById(Long id) {
        return repository.findById(id);
    }

    @Transactional
    public Cargo salvar(Cargo cargo) {
        validar(cargo);
        return repository.save(cargo);
    }

    public void validar(Cargo cargo) {

        Float salarioBase = cargo.getSalarioBase();

        if (cargo.getCargo() == null || cargo.getCargo().trim().equals("")){
            throw new RegraNegocioException("Titulo Invalido!!! Insira um titulo valido.");
        }
        if (cargo.getDescricao() == null || cargo.getDescricao().trim().equals("")) {
            throw new RegraNegocioException("Descrição Invalida!!! Insira uma descrição valida.");
        }
        if (cargo.getSalarioBase() < 1412.00 || salarioBase == null) {
            throw new RegraNegocioException("O salario base do cargo tem que maior ou igualque o piso da classe e maior que o salario minimo.");
        }
        if (cargo.getHotel() == null || cargo.getHotel().getId() == null || cargo.getHotel().getId() == 0) {
            throw new RegraNegocioException("Hotel inválid0!!!!");
        }
    }


}