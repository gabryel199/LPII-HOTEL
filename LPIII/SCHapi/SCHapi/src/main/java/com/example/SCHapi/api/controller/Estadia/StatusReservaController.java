package com.example.SCHapi.api.controller.Estadia;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.SCHapi.api.dto.Estadia.StatusReservaDTO;
import com.example.SCHapi.exception.RegraNegocioException;
import com.example.SCHapi.model.entity.Estadia.StatusReserva;
import com.example.SCHapi.service.Estadia.StatusReservaService;

@RestController
@RequestMapping("/api/v1/statusReservas")
@RequiredArgsConstructor
public class StatusReservaController {
    
    private final StatusReservaService service;

    @GetMapping()
    public ResponseEntity get() {
       List<StatusReserva> statusReservas = service.getStatusReserva();
        return ResponseEntity.ok(statusReservas.stream().map(StatusReservaDTO::create).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable("id") Long id) {
        Optional<StatusReserva> statusReserva = service.getStatusReservaById(id);
        if (!statusReserva.isPresent()) {
            return new ResponseEntity("Status de Reserva não encontrado", HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(statusReserva.map(StatusReservaDTO::create));
    }

    @PostMapping
    public ResponseEntity post(@RequestBody StatusReservaDTO dto) {
        try {
            StatusReserva statusReserva = converter(dto);
            statusReserva = service.salvar(statusReserva);
            return new ResponseEntity(statusReserva, HttpStatus.CREATED);
        } catch (RegraNegocioException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    public StatusReserva converter(StatusReservaDTO dto) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(dto, StatusReserva.class);
    }
}
