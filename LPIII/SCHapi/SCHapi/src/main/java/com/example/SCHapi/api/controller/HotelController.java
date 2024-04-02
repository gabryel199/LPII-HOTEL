package com.example.SCHapi.api.controller;

import java.util.Optional;

import org.modelmapper.ModelMapper;

import com.example.SCHapi.api.dto.HotelDTO;
import com.example.SCHapi.model.entity.Hotel;
import com.example.SCHapi.model.entity.Endereco;
import com.example.SCHapi.model.entity.Pais;
import com.example.SCHapi.model.entity.Uf;
import com.example.SCHapi.service.HotelService;
import com.example.SCHapi.service.EnderecoService;
import com.example.SCHapi.service.PaisService;
import com.example.SCHapi.service.UfService;

public class HotelController {

    private final HotelService service;
    private final EnderecoService enderecoService;
    private final UfService ufService;
    private final PaisService paisService;

    public Hotel converter(HotelDTO dto) {
        ModelMapper modelMapper = new ModelMapper();
        Hotel hotel = modelMapper.map(dto, Hotel.class);
        Endereco endereco = modelMapper.map(dto, Endereco.class);
        hotel.setEndereco(endereco);
        if (dto.getIdUf() != null) {
            Optional<Uf> uf = ufService.getUfById(dto.getIdUf());
            if (!uf.isPresent()) {
                hotel.setUf(null);
            } else {
                hotel.setUf(uf.get());
            }
        }
        if (dto.getIdPais() != null) {
            Optional<Pais> pais = paisService.getPaisById(dto.getIdPais());
            if (!pais.isPresent()) {
                hotel.setPais(null);
            } else {
                hotel.setPais(pais.get());
            }
        }
        return hotel;
    }
}