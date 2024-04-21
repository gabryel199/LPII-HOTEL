package com.example.SCHapi.api.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;

import com.example.SCHapi.api.dto.TipoQuartoReservaDTO;
import com.example.SCHapi.exception.RegraNegocioException;
import com.example.SCHapi.model.entity.Reserva;
import com.example.SCHapi.model.entity.TipoQuarto;
import com.example.SCHapi.model.entity.TipoQuartoReserva;
import com.example.SCHapi.service.ReservaService;
import com.example.SCHapi.service.TipoQuartoReservaService;
import com.example.SCHapi.service.TipoQuartoService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/TipoQuartoReservas")
@RequiredArgsConstructor
public class TipoQuartoReservaController {

    private final TipoQuartoReservaService service;
    private final ReservaService reservaService;
    private final TipoQuartoService tipoQuartoService;

    @GetMapping()
    public ResponseEntity get() {
       List<TipoQuartoReserva> tipoQuartoReservas = service.getTipoQuartoReservas();
        return ResponseEntity.ok(tipoQuartoReservas.stream().map(TipoQuartoReservaDTO::create).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable("id") Long id) {
        Optional<TipoQuartoReserva> tipoQuartoReserva = service.getTipoQuartoReservaById(id);
        if (!tipoQuartoReserva.isPresent()) {
            return new ResponseEntity("TipoQuartoReserva não encontrada", HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(tipoQuartoReserva.map(TipoQuartoReservaDTO::create));
    }

    @PostMapping
    public ResponseEntity post(@RequestBody TipoQuartoReservaDTO dto) {
        try {
            TipoQuartoReserva tipoQuartoReserva = converter(dto);
            tipoQuartoReserva = service.salvar(tipoQuartoReserva);
            return new ResponseEntity(tipoQuartoReserva, HttpStatus.CREATED);
        } catch (RegraNegocioException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    public TipoQuartoReserva converter(TipoQuartoReservaDTO dto) {
        ModelMapper modelMapper = new ModelMapper();
        TipoQuartoReserva tipoQuartoReserva = modelMapper.map(dto, TipoQuartoReserva.class);
        if (dto.getIdReserva() != null) {
            Optional<Reserva> reserva = reservaService.getReservaById(dto.getIdReserva());
            if (!reserva.isPresent()) {
                tipoQuartoReserva.setReserva(null);
            } else {
                tipoQuartoReserva.setReserva(reserva.get());
            }
        }
        if (dto.getIdTipoQuarto() != null) {
            Optional<TipoQuarto> tipoQuarto = tipoQuartoService.getTipoQuartoById(dto.getIdTipoQuarto());
            if (!tipoQuarto.isPresent()) {
                tipoQuartoReserva.setTipoQuarto(null);
            } else {
                tipoQuartoReserva.setTipoQuarto(tipoQuarto.get());
            }
        }
        return tipoQuartoReserva;
    }
}