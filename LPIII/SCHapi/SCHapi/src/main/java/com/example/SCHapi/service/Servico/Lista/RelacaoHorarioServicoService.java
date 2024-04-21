package com.example.SCHapi.service.Servico.Lista;

import com.example.SCHapi.model.entity.Servico.Lista.RelacaoHorarioServico;
import com.example.SCHapi.model.repository.Servico.Lista.RelacaoHorarioServicoRepository;

import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RelacaoHorarioServicoService {
    private RelacaoHorarioServicoRepository repository;

    public RelacaoHorarioServicoService(RelacaoHorarioServicoRepository repository) {
        this.repository = repository;
    }

    public List<RelacaoHorarioServico> getRelacaoHorariosServico(){
        return repository.findAll();
    }

    public Optional<RelacaoHorarioServico> getRelacaoHorariosServicoById(Long id) {
        return repository.findById(id);
    }
}
