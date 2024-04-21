package com.example.SCHapi.service.Quarto;

import com.example.SCHapi.model.entity.Estadia.StatusHospedagem;
import com.example.SCHapi.model.entity.Quarto.StatusQuarto;
import com.example.SCHapi.model.repository.Estadia.StatusHospedagemRepository;
import com.example.SCHapi.model.repository.Quarto.StatusQuartoRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class StatusQuartoService {

    private StatusQuartoRepository repository;

    public StatusQuartoService(StatusQuartoRepository repository) {
        this.repository = repository;
    }

    public List<StatusQuarto> getStatusQuarto(){
        return repository.findAll();
    }

    public Optional<StatusQuarto> getStatusQuartoById(Long id) {
        return repository.findById(id);
    }
}
