package com.example.SCHapi.api.controller.Servico;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.SCHapi.api.dto.Servico.StatusServicoDTO;
import com.example.SCHapi.exception.RegraNegocioException;
import com.example.SCHapi.model.entity.Servico.StatusServico;
import com.example.SCHapi.service.Servico.StatusServicoService;

@RestController
@RequestMapping("/api/v1/statusServicos")
@RequiredArgsConstructor
public class StatusServicoController {
    
    private final StatusServicoService service;

    @GetMapping()
    public ResponseEntity get() {
       List<StatusServico> statusServicos = service.getStatusServico();
        return ResponseEntity.ok(statusServicos.stream().map(StatusServicoDTO::create).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable("id") Long id) {
        Optional<StatusServico> statusServico = service.getStatusServicoById(id);
        if (!statusServico.isPresent()) {
            return new ResponseEntity("Status de Servico não encontrado", HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(statusServico.map(StatusServicoDTO::create));
    }

    @PostMapping
    public ResponseEntity post(@RequestBody StatusServicoDTO dto) {
        try {
            StatusServico statusServico = converter(dto);
            statusServico = service.salvar(statusServico);
            return new ResponseEntity(statusServico, HttpStatus.CREATED);
        } catch (RegraNegocioException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    public StatusServico converter(StatusServicoDTO dto) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(dto, StatusServico.class);
    }
}
