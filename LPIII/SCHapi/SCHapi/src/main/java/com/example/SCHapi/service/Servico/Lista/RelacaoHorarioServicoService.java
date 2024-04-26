package com.example.SCHapi.service.Servico.Lista;

import com.example.SCHapi.exception.RegraNegocioException;
import com.example.SCHapi.model.entity.*;
import com.example.SCHapi.model.entity.Quarto.Lista.TipoCamaTipoQuarto;
import com.example.SCHapi.model.entity.Servico.Lista.RelacaoHorarioServico;
import com.example.SCHapi.model.repository.Servico.Lista.RelacaoHorarioServicoRepository;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Transactional
    public RelacaoHorarioServico salvar(RelacaoHorarioServico relacaoHorarioServico) {
        // validar(tipoCamaTipoQuarto);
        return repository.save(relacaoHorarioServico);
    }
}
