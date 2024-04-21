package com.example.SCHapi.service;

import com.example.SCHapi.model.entity.Hospedagem;
import com.example.SCHapi.model.entity.Servico;
import com.example.SCHapi.model.entity.ServicoSolicitado;
import com.example.SCHapi.model.repository.ServicoRepository;
import com.example.SCHapi.model.repository.ServicoSolicitadoRepository;

import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

@Service
public class ServicoSolicitadoService {

    private ServicoSolicitadoRepository repository;

    public ServicoSolicitadoService(ServicoSolicitadoRepository repository) {
        this.repository = repository;
    }

    public List<ServicoSolicitado> getServicoSolicitados(){
        return repository.findAll();
    }

    public Optional<ServicoSolicitado> getServicoSolicitadoById(Long id) {
        return repository.findById(id);
    }

    public List<ServicoSolicitado> getServicoSolicitadoByHospedagem(Optional<Hospedagem> hospedagem) {
        return repository.findByHospedagem(hospedagem);
    }

    @Transactional
    public ServicoSolicitado salvar(ServicoSolicitado servicoSolicitado) {
        // validar(servicoSolicitado);
        return repository.save(servicoSolicitado);
    }
}
