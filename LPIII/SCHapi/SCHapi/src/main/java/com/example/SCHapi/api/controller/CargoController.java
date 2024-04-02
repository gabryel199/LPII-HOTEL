package com.example.SCHapi.api.controller;

import java.util.Optional;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import com.example.SCHapi.api.dto.CargoDTO;
import com.example.SCHapi.model.entity.Cargo;

import com.example.SCHapi.service.CargoService;
import com.example.SCHapi.service.HotelService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/")
@RequiredArgsConstructor
public class CargoController {

    private final CargoService service;
    private final HotelService hotelService;

    public Cargo converter(CargoDTO dto) {
        ModelMapper modelMapper = new ModelMapper();
        Cargo cargo = modelMapper.map(dto, Cargo.class);
        if (dto.getIdHotel() != null) {
            Optional<Hotel> hotel = hotelService.getHotelById(dto.getIdHotel());
            if (!hotel.isPresent()) {
                cargo.setHotel(null);
            } else {
                cargo.setHotel(hotel.get());
            }
        }
        return cargo;
    }
}