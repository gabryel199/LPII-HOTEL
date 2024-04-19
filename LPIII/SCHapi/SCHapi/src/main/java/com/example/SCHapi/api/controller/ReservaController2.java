package com.example.SCHapi.api.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;

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
public class ReservaController2 {
    private final ReservaService service;
    private final ClienteService clienteService;
    private final HotelService hotelService;
    private final FuncionarioService funcionarioService;
    private final StatusReservaService statusreservaService;
    private final TipoQuartoReservaService tipoQuartoReservaService;
    private final TipoQuartoService tipoQuartoService;

    // @GetMapping()
    // public ResponseEntity get() {
    //    List<Reserva> reservas = service.getReservas();
    //     return ResponseEntity.ok(reservas.stream().map(ReservaDTO::create).collect(Collectors.toList()));
    // } // essa aqui ainda tem q adaptar, mas acho q nao vai influenciar por enquanto

    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable("id") Long id) {
        Optional<Reserva> reserva = service.getReservaById(id);
        List<TipoQuartoReserva> listaQuartos = tipoQuartoReservaService.getTipoQuartoReservaByReserva(reserva);
        //Optional<List<TipoQuartoReserva>> = Optional.of(listaQuartos);
        ReservaDTO2 reservaDTO2 = new ReservaDTO2();
        reservaDTO2 = ReservaDTO2.create(reserva.get(), listaQuartos);
        if (!reserva.isPresent()) {
            return new ResponseEntity("Reserva não encontrada", HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(reservaDTO2);
        // return ResponseEntity.ok(reserva.map(ReservaDTO::create));
    }

    @PostMapping
    public ResponseEntity post(@RequestBody ReservaDTO2 dto) {
        try {
            Reserva reserva = converter(dto);
            reserva = service.salvar(reserva);
            // loop para cada elemento da lista salvar o tipoquartoreserva
            for (TipoQuartoReservaDTO tipoQuartoReservaDto : dto.getListaQuartos()) {
                TipoQuartoReserva tipoQuartoReserva = converterTipoQuartoReserva(tipoQuartoReservaDto, reserva.getId());
                tipoQuartoReservaService.salvar(tipoQuartoReserva);
            }
            return new ResponseEntity(reserva, HttpStatus.CREATED);
        } catch (RegraNegocioException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
    
    public Reserva converter(ReservaDTO2 dto) {
        ModelMapper modelMapper = new ModelMapper();
        Reserva reserva = modelMapper.map(dto, Reserva.class);
        if (dto.getIdCliente() != null) {
            Optional<Cliente> cliente = clienteService.getClienteById(dto.getIdCliente());
            if (!cliente.isPresent()) {
                reserva.setCliente(null);
            } else {
                reserva.setCliente(cliente.get());
            }
        }
        if (dto.getIdHotel() != null) {
            Optional<Hotel> hotel = hotelService.getHotelById(dto.getIdHotel());
            if (!hotel.isPresent()) {
                reserva.setHotel(null);
            } else {
                reserva.setHotel(hotel.get());
            }
        }
        if (dto.getIdFuncionario() != null) {
            Optional<Funcionario> funcionario = funcionarioService.getFuncionarioById(dto.getIdFuncionario());
            if (!funcionario.isPresent()) {
                reserva.setFuncionario(null);
            } else {
                reserva.setFuncionario(funcionario.get());
            }
        }
        if (dto.getIdStatusReserva() != null) {
            Optional<StatusReserva> statusreserva = statusreservaService.getStatusReservaById(dto.getIdStatusReserva());
            if (!statusreserva.isPresent()) {
                reserva.setStatusReserva(null);
            } else {
                reserva.setStatusReserva(statusreserva.get());
            }
        }
        return reserva;
    }

    public TipoQuartoReserva converterTipoQuartoReserva(TipoQuartoReservaDTO dto, Long reservaId) {
        ModelMapper modelMapper = new ModelMapper();
        TipoQuartoReserva tipoQuartoReserva = modelMapper.map(dto, TipoQuartoReserva.class);
        // TipoQuartoReserva tipoQuartoReserva = new TipoQuartoReserva();
        if (reservaId != null) {
            Optional<Reserva> reserva = service.getReservaById(reservaId);
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