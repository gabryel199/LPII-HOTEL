package com.example.SCHapi.api.controller;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import com.example.SCHapi.api.dto.UfDTO;
import com.example.SCHapi.model.entity.Uf;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/")
@RequiredArgsConstructor
public class UfController {
    public Uf converter(UfDTO dto) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(dto, Uf.class);
    }
}