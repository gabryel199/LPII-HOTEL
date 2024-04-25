package com.example.SCHapi.api.controller.Estadia;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.SCHapi.api.dto.Estadia.StatusHospedagemDTO;
import com.example.SCHapi.exception.RegraNegocioException;
import com.example.SCHapi.model.entity.Estadia.StatusHospedagem;
import com.example.SCHapi.service.Estadia.StatusHospedagemService;

@RestController
@RequestMapping("/api/v1/statusHospedagens")
@RequiredArgsConstructor
public class StatusHospedagemController {
    
    private final StatusHospedagemService service;

    @GetMapping()
    public ResponseEntity get() {
       List<StatusHospedagem> statusHospedagems = service.getStatusHospedagem();
        return ResponseEntity.ok(statusHospedagems.stream().map(StatusHospedagemDTO::create).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable("id") Long id) {
        Optional<StatusHospedagem> statusHospedagem = service.getStatusHospedagemById(id);
        if (!statusHospedagem.isPresent()) {
            return new ResponseEntity("Status de Hospedagem não encontrado", HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(statusHospedagem.map(StatusHospedagemDTO::create));
    }

    @PostMapping
    public ResponseEntity post(@RequestBody StatusHospedagemDTO dto) {
        try {
            StatusHospedagem statusHospedagem = converter(dto);
            statusHospedagem = service.salvar(statusHospedagem);
            return new ResponseEntity(statusHospedagem, HttpStatus.CREATED);
        } catch (RegraNegocioException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    public StatusHospedagem converter(StatusHospedagemDTO dto) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(dto, StatusHospedagem.class);
    }
}
