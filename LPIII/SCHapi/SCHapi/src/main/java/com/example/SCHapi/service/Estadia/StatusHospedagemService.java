package com.example.SCHapi.service.Estadia;

import com.example.SCHapi.model.entity.Estadia.StatusHospedagem;
import com.example.SCHapi.model.entity.Estadia.Lista.ServicoSolicitado;
import com.example.SCHapi.model.repository.Estadia.StatusHospedagemRepository;
import com.example.SCHapi.model.repository.Estadia.Lista.ServicoSolicitadoRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class StatusHospedagemService {
    private StatusHospedagemRepository repository;

    public StatusHospedagemService(StatusHospedagemRepository repository) {
        this.repository = repository;
    }

    public List<StatusHospedagem> getStatusHospedagem(){
        return repository.findAll();
    }

    public Optional<StatusHospedagem> getStatusHospedagemById(Long id) {
        return repository.findById(id);
    }
}
