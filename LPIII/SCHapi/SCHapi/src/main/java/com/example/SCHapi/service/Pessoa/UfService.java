package com.example.SCHapi.service.Pessoa;

import com.example.SCHapi.model.entity.Pessoa.Uf;
import com.example.SCHapi.model.entity.Quarto.TipoCama;
import com.example.SCHapi.model.repository.Pessoa.UfRepository;
import com.example.SCHapi.model.repository.Quarto.TipoCamaRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UfService {
    private UfRepository repository;

    public UfService(UfRepository repository) {
        this.repository = repository;
    }

    public List<Uf> getUfs(){
        return repository.findAll();
    }

    public Optional<Uf> getUfById(Long id) {
        return repository.findById(id);
    }
}
