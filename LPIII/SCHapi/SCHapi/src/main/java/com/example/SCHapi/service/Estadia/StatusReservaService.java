package com.example.SCHapi.service.Estadia;

import com.example.SCHapi.exception.RegraNegocioException;
import com.example.SCHapi.model.entity.Estadia.StatusReserva;
import com.example.SCHapi.model.entity.Quarto.StatusQuarto;
import com.example.SCHapi.model.repository.Estadia.StatusReservaRepository;
import com.example.SCHapi.model.repository.Quarto.StatusQuartoRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
@Service
public class StatusReservaService {

    private StatusReservaRepository repository;

    public StatusReservaService(StatusReservaRepository repository) {
        this.repository = repository;
    }

    public List<StatusReserva> getStatusReserva(){
        return repository.findAll();
    }

    public Optional<StatusReserva> getStatusReservaById(Long id) {
        return repository.findById(id);
    }

    @Transactional
    public StatusReserva salvar(StatusReserva statusReserva) {
        validar(statusReserva);
        return repository.save(statusReserva);
    }

    public void validar(StatusReserva statusReserva) {
       
        if (statusReserva.getTitulo() == null || statusReserva.getTitulo().trim().equals("")) {
            throw new RegraNegocioException("Titulo Invalido!!! Insira uma titulo valido.");
        }
    }
}
