package com.example.SCHapi.api.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;

import com.example.SCHapi.api.dto.ReservaDTO;
import com.example.SCHapi.api.dto.ReservaDTO2;
import com.example.SCHapi.api.dto.TipoQuartoReservaDTO;
import com.example.SCHapi.exception.RegraNegocioException;
import com.example.SCHapi.model.entity.Reserva;
import com.example.SCHapi.model.entity.Cliente;
import com.example.SCHapi.model.entity.Funcionario;
import com.example.SCHapi.model.entity.Hotel;
import com.example.SCHapi.model.entity.StatusReserva;
import com.example.SCHapi.model.entity.TipoQuarto;
import com.example.SCHapi.model.entity.TipoQuartoReserva;
import com.example.SCHapi.service.ClienteService;
import com.example.SCHapi.service.FuncionarioService;
import com.example.SCHapi.service.ReservaService;
import com.example.SCHapi.service.HotelService;
import com.example.SCHapi.service.StatusReservaService;
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
@RequestMapping("/api/v1/reservas2")
@RequiredArgsConstructor
public class TipoQuartoReservaController {
    private final TipoQuartoReservaService service;
    private final TipoQuartoService tipoQuartoService;
    private final ReservaService reservaService;

    // @GetMapping()
    // public ResponseEntity get() {
    //    List<TipoQuartoReserva> tipoquartoreservas = service.getTipoQuartoReservas();
    //     return ResponseEntity.ok(tipoquartoreservas.stream().map(TipoQuartoReservaController::create).collect(Collectors.toList()));
    // } // essa aqui ainda tem q adaptar, mas acho q nao vai influenciar por enquanto

    // @GetMapping("/{id}")
    // public ResponseEntity get(@PathVariable("id") Long id) {
    //     Optional<Reserva> reserva = service.getReservaById(id);
    //     List<TipoQuartoReserva> listaQuartos = tipoQuartoReservaService.getTipoQuartoReservaByReserva(reserva);
    //     //Optional<List<TipoQuartoReserva>> = Optional.of(listaQuartos);
    //     ReservaDTO2 reservaDTO2 = new ReservaDTO2();
    //     reservaDTO2 = ReservaDTO2.create(reserva.get(), listaQuartos);
    //     if (!reserva.isPresent()) {
    //         return new ResponseEntity("Reserva não encontrada", HttpStatus.NOT_FOUND);
    //     }
    //     return ResponseEntity.ok(reservaDTO2);
    //     // return ResponseEntity.ok(reserva.map(ReservaDTO::create));
    // }

    // @PostMapping
    // public ResponseEntity post(@RequestBody TipoQuartoReservaDTO dto) {
    //     try {
    //         TipoQuartoReserva tipoquartoreserva = converter(dto);
    //         tipoquartoreserva = service.salvar(tipoquartoreserva);
    //         return new ResponseEntity(tipoquartoreserva, HttpStatus.CREATED);
    //     } catch (RegraNegocioException e) {
    //         return ResponseEntity.badRequest().body(e.getMessage());
    //     }
    // }
    
    public TipoQuartoReserva converter(TipoQuartoReservaDTO dto, Long reservaId) {
        ModelMapper modelMapper = new ModelMapper();
        TipoQuartoReserva tipoQuartoReserva = modelMapper.map(dto, TipoQuartoReserva.class);
        // TipoQuartoReserva tipoQuartoReserva = new TipoQuartoReserva();
        if (reservaId != null) {
            Optional<Reserva> reserva = reservaService.getReservaById(reservaId);
            if (!reserva.isPresent()) {
                tipoQuartoReserva.setReserva(null);
            } else {
                tipoQuartoReserva.setReserva(reserva.get());
            }
        }
        if (dto.getTipoQuarto() != null) {
            Optional<TipoQuarto> tipoQuarto = tipoQuartoService.getTipoQuartoById(dto.getTipoQuarto());
            if (!tipoQuarto.isPresent()) {
                tipoQuartoReserva.setTipoQuarto(null);
            } else {
                tipoQuartoReserva.setTipoQuarto(tipoQuarto.get());
            }
        }
        return tipoQuartoReserva;
    }
}