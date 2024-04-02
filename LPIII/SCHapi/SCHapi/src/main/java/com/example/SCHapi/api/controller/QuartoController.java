package com.example.SCHapi.api.controller;

import com.example.SCHapi.service.QuartoService;
import com.example.SCHapi.service.StatusQuartoService;
import com.example.SCHapi.service.TipoQuartoService;
import com.example.SCHapi.service.HotelService;

import java.util.Optional;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;

import com.example.SCHapi.api.dto.QuartoDTO;
import com.example.SCHapi.model.entity.Quarto;
import com.example.SCHapi.model.entity.StatusQuarto;
import com.example.SCHapi.model.entity.TipoQuarto;
import com.example.SCHapi.model.entity.Hotel;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/")
@RequiredArgsConstructor
public class QuartoController {

    private final QuartoService service;
    private final HotelService hotelService;
    private final TipoQuartoService tipoquartoService;
    private final StatusQuartoService statusquartoService;

    public Quarto converter(QuartoDTO dto) {
        ModelMapper modelMapper = new ModelMapper();
        Quarto quarto = modelMapper.map(dto, Quarto.class);
        if (dto.getIdHotel() != null) {
            Optional<Hotel> hotel = hotelService.getHotelById(dto.getIdHotel());
            if (!hotel.isPresent()) {
                quarto.setHotel(null);
            } else {
                quarto.setHotel(hotel.get());
            }
        }
        if (dto.getIdTipoQuarto() != null) {
            Optional<TipoQuarto> tipoquarto = tipoquartoService.getTipoQuartoById(dto.getIdTipoQuarto());
            if (!tipoquarto.isPresent()) {
                quarto.setTipoQuarto(null);
            } else {
                quarto.setTipoQuarto(tipoquarto.get());
            }
        }
        if (dto.getIdStatusQuarto() != null) {
            Optional<StatusQuarto> statusquarto = statusquartoService.getStatusQuartoById(dto.getIdStatusQuarto());
            if (!statusquarto.isPresent()) {
                quarto.setStatusQuarto(null);
            } else {
                quarto.setStatusQuarto(statusquarto.get());
            }
        }
        return quarto;
    }
}