package com.example.SCHapi.api.controller.Estadia.Lista;

import com.example.SCHapi.api.dto.Estadia.Lista.ServicoSolicitadoDTO;
import com.example.SCHapi.exception.RegraNegocioException;
import com.example.SCHapi.model.entity.Estadia.Hospedagem;
import com.example.SCHapi.model.entity.Estadia.Lista.ServicoSolicitado;
import com.example.SCHapi.model.entity.Servico.Servico;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

import com.example.SCHapi.service.Estadia.HospedagemService;
import com.example.SCHapi.service.Estadia.Lista.ServicoSolicitadoService;
import com.example.SCHapi.service.Servico.ServicoService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/servicoSolicitados")
@RequiredArgsConstructor
public class ServicoSolicitadoController {

    private final ServicoSolicitadoService service;
    private final HospedagemService hospedagemService;
    private final ServicoService servicoService;

    @GetMapping()
    public ResponseEntity get() {
       List<ServicoSolicitado> servicoSolicitados = service.getServicoSolicitados();
        return ResponseEntity.ok(servicoSolicitados.stream().map(ServicoSolicitadoDTO::create).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable("id") Long id) {
        Optional<ServicoSolicitado> servicoSolicitado = service.getServicoSolicitadoById(id);
        if (!servicoSolicitado.isPresent()) {
            return new ResponseEntity("ServicoSolicitado não encontrada", HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(servicoSolicitado.map(ServicoSolicitadoDTO::create));
    }

    @PostMapping
    public ResponseEntity post(@RequestBody ServicoSolicitadoDTO dto) {
        try {
            ServicoSolicitado servicoSolicitado = converter(dto);
            servicoSolicitado = service.salvar(servicoSolicitado);
            return new ResponseEntity(servicoSolicitado, HttpStatus.CREATED);
        } catch (RegraNegocioException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    public ServicoSolicitado converter(ServicoSolicitadoDTO dto) {
        ModelMapper modelMapper = new ModelMapper();
        ServicoSolicitado servicoSolicitado = modelMapper.map(dto, ServicoSolicitado.class);
        if (dto.getIdHospedagem() != null) {
            Optional<Hospedagem> hospedagem = hospedagemService.getHospedagemById(dto.getIdHospedagem());
            if (!hospedagem.isPresent()) {
                servicoSolicitado.setHospedagem(null);
            } else {
                servicoSolicitado.setHospedagem(hospedagem.get());
            }
        }
        if (dto.getIdServico() != null) {
            Optional<Servico> servico = servicoService.getServicoById(dto.getIdServico());
            if (!servico.isPresent()) {
                servicoSolicitado.setServico(null);
            } else {
                servicoSolicitado.setServico(servico.get());
            }
        }
        return servicoSolicitado;
    }
}