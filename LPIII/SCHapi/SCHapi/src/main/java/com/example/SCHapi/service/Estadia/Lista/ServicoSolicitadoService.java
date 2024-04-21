package com.example.SCHapi.service.Estadia.Lista;

import com.example.SCHapi.model.entity.Estadia.Hospedagem;
import com.example.SCHapi.model.entity.Estadia.Lista.ServicoSolicitado;
import com.example.SCHapi.model.entity.Servico.Servico;
import com.example.SCHapi.model.repository.Estadia.Lista.ServicoSolicitadoRepository;
import com.example.SCHapi.model.repository.Servico.ServicoRepository;

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
