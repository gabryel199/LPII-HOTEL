package com.example.SCHapi.api.controller.Servico.Lista;


import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.SCHapi.api.dto.Quarto.Lista.ComodidadeTipoQuartoDTO;
import com.example.SCHapi.api.dto.Servico.Lista.RelacaoHorarioServicoDTO;
import com.example.SCHapi.exception.RegraNegocioException;
import com.example.SCHapi.model.entity.Estadia.Lista.ServicoSolicitado;
import com.example.SCHapi.model.entity.Quarto.Comodidade;
import com.example.SCHapi.model.entity.Quarto.TipoQuarto;
import com.example.SCHapi.model.entity.Quarto.Lista.ComodidadeTipoQuarto;
import com.example.SCHapi.model.entity.Servico.HorarioServico;
import com.example.SCHapi.model.entity.Servico.Lista.RelacaoHorarioServico;
import com.example.SCHapi.service.Estadia.Lista.ServicoSolicitadoService;
import com.example.SCHapi.service.Servico.HorarioServicoService;
import com.example.SCHapi.service.Servico.Lista.RelacaoHorarioServicoService;

@RestController
@RequestMapping("/api/v1/relacaoHorarioServicos")
@RequiredArgsConstructor
public class RelacaoHorarioServicoController {

    private final RelacaoHorarioServicoService service;
    private final HorarioServicoService horarioServicoService;
    private final ServicoSolicitadoService servicoSolicitadoService;
    
    @GetMapping()
    public ResponseEntity get() {
       List<RelacaoHorarioServico> relacaoHorarioServicos = service.getRelacaoHorariosServico();
        return ResponseEntity.ok(relacaoHorarioServicos.stream().map(RelacaoHorarioServicoDTO::create).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable("id") Long id) {
        Optional<RelacaoHorarioServico> relacaoHorarioServico = service.getRelacaoHorariosServicoById(id);
        if (!relacaoHorarioServico.isPresent()) {
            return new ResponseEntity("RelaçãoHorarioServiço não encontrado", HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(relacaoHorarioServico.map(RelacaoHorarioServicoDTO::create));
    }

    @PostMapping
    public ResponseEntity post(@RequestBody RelacaoHorarioServicoDTO dto) {
        try {
            RelacaoHorarioServico relacaoHorarioServico = converter(dto);
            relacaoHorarioServico = service.salvar(relacaoHorarioServico);
            return new ResponseEntity(relacaoHorarioServico, HttpStatus.CREATED);
        } catch (RegraNegocioException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    public RelacaoHorarioServico converter(RelacaoHorarioServicoDTO dto) {
        ModelMapper modelMapper = new ModelMapper();
        RelacaoHorarioServico relacaoHorarioServico = modelMapper.map(dto, RelacaoHorarioServico.class);
        if (dto.getIdHorarioServico() != null) {
            Optional<HorarioServico> horarioServico = horarioServicoService.getHorarioServicoById(dto.getIdHorarioServico());
            if (!horarioServico.isPresent()) {
                relacaoHorarioServico.setHorarioServico(null);
            } else {
                relacaoHorarioServico.setHorarioServico(horarioServico.get());
            }
        }
        if (dto.getIdServicoSolicitado() != null) {
            Optional<ServicoSolicitado> servicoSolicitado = servicoSolicitadoService.getServicoSolicitadoById(dto.getIdServicoSolicitado());
            if (!servicoSolicitado.isPresent()) {
                relacaoHorarioServico.setServicoSolicitado(null);
            } else {
                relacaoHorarioServico.setServicoSolicitado(servicoSolicitado.get());
            }
        }
        return relacaoHorarioServico;
    }
}
