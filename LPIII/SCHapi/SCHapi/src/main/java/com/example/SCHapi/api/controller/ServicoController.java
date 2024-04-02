package com.example.SCHapi.api.controller;

import java.util.Optional;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;

import com.example.SCHapi.api.dto.ServicoDTO;
import com.example.SCHapi.model.entity.Hotel;
import com.example.SCHapi.model.entity.Servico;
import com.example.SCHapi.model.entity.StatusServico;
import com.example.SCHapi.model.entity.TipoServico;
import com.example.SCHapi.service.HotelService;
import com.example.SCHapi.service.ServicoService;
import com.example.SCHapi.service.StatusServicoService;
import com.example.SCHapi.service.TipoServicoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/")
@RequiredArgsConstructor
public class ServicoController {
    private final ServicoService service;
    private final HotelService hotelService;
    private final TipoServicoService tipoServicoService;
    private final StatusServicoService statusServicoService;

    public Servico converter(ServicoDTO dto) {
        ModelMapper modelMapper = new ModelMapper();
        Servico servico = modelMapper.map(dto, Servico.class);
        if (dto.getIdHotel() != null) {
            Optional<Hotel> hotel = hotelService.getHotelById(dto.getIdHotel());
            if (!hotel.isPresent()) {
                servico.setHotel(null);
            } else {
                servico.setHotel(hotel.get());
            }
        }
        if (dto.getIdTipoServico() != null) {
            Optional<TipoServico> tiposervico = tipoServicoService.getTipoServicoById(dto.getIdTipoServico());
            if (!tiposervico.isPresent()) {
                servico.setTipoServico(null);
            } else {
                servico.setTipoServico(tiposervico.get());
            }
        }
        if (dto.getIdStatusServico() != null) {
            Optional<StatusServico> statusservico = statusServicoService.getStatusServicoById(dto.getIdStatusServico());
            if (!statusservico.isPresent()) {
                servico.setStatusServico(null);
            } else {
                servico.setStatusServico(statusservico.get());
            }
        }
        return servico;
    }
}