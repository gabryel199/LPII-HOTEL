package com.example.SCHapi.api.controller;

import java.util.Optional;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;

import com.example.SCHapi.api.dto.ComodidadeDTO;
import com.example.SCHapi.model.entity.TipoComodidade;
import com.example.SCHapi.model.entity.Comodidade;
import com.example.SCHapi.service.TipoComodidadeService;
import com.example.SCHapi.service.ComodidadeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/")
@RequiredArgsConstructor
public class ComodidadeController {

    private final ComodidadeService service;
    private final TipoComodidadeService tipoComodidadeService;
    
    public Comodidade converter(ComodidadeDTO dto) {
        ModelMapper modelMapper = new ModelMapper();
        Comodidade comodidade = modelMapper.map(dto, Comodidade.class);
        if (dto.getIdTipoComodidade() != null) {
            Optional<TipoComodidade> tipoComodidade = tipoComodidadeService.getTipoComodidadeById(dto.getIdTipoComodidade());
            if (!tipoComodidade.isPresent()) {
                comodidade.setTipoComodidade(null);
            } else {
                comodidade.setTipoComodidade(tipoComodidade.get());
            }
        }
        return comodidade;
    }
}