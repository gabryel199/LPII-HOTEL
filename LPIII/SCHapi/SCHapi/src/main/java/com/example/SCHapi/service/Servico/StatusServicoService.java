package com.example.SCHapi.service.Servico;

import com.example.SCHapi.model.entity.Estadia.Reserva;
import com.example.SCHapi.model.entity.Servico.StatusServico;
import com.example.SCHapi.model.repository.Estadia.ReservaRepository;
import com.example.SCHapi.model.repository.Servico.StatusServicoRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class StatusServicoService {

    private StatusServicoRepository repository;

    public StatusServicoService(StatusServicoRepository repository) {
        this.repository = repository;
    }

    public List<StatusServico> getStatusServico(){
        return repository.findAll();
    }

    public Optional<StatusServico> getStatusServicoById(Long id) {
        return repository.findById(id);
    }
}
