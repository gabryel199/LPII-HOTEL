package com.example.SCHapi.api.controller;

import java.util.Optional;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;

import com.example.SCHapi.api.dto.ProdutoDTO;
import com.example.SCHapi.model.entity.Produto;
import com.example.SCHapi.model.entity.Hotel;
import com.example.SCHapi.service.ProdutoService;
import com.example.SCHapi.service.HotelService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/")
@RequiredArgsConstructor
public class ProdutoController {

    private final ProdutoService service;
    private final HotelService hotelService;

    public Produto converter(ProdutoDTO dto) {
        ModelMapper modelMapper = new ModelMapper();
        Produto produto = modelMapper.map(dto, Produto.class);
        if (dto.getIdHotel() != null) {
            Optional<Hotel> hotel = hotelService.getHotelById(dto.getIdHotel());
            if (!hotel.isPresent()) {
                produto.setHotel(null);
            } else {
                produto.setHotel(hotel.get());
            }
        }
        return produto;
    }
}