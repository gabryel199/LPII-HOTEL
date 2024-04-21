package com.example.SCHapi.service;

import com.example.SCHapi.exception.RegraNegocioException;
import com.example.SCHapi.model.entity.*;
import com.example.SCHapi.model.repository.TipoCamaTipoQuartoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;



@Service
public class TipoCamaTipoQuartoService {

    private TipoCamaTipoQuartoRepository repository;

    public TipoCamaTipoQuartoService(TipoCamaTipoQuartoRepository repository) {
        this.repository = repository;
    }

    public List<TipoCamaTipoQuarto> getTipoCamaTipoQuartos() {
        return repository.findAll();
    }

    public Optional<TipoCamaTipoQuarto> getTipoCamaTipoQuartoById(Long id) {
        return repository.findById(id);
    }

    public List<TipoCamaTipoQuarto> getTipoCamaTipoQuartoByTipoQuarto(Optional<TipoQuarto> tipoQuarto) {
        return repository.findByTipoQuarto(tipoQuarto);
    }

    @Transactional
    public TipoCamaTipoQuarto salvar(TipoCamaTipoQuarto tipoCamaTipoQuarto) {
        // validar(tipoCamaTipoQuarto);
        return repository.save(tipoCamaTipoQuarto);
    }

}