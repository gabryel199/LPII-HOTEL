package com.example.SCHapi.api.controller;

import java.util.Optional;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import com.example.SCHapi.api.dto.AvaliacaoQuartoDTO;
import com.example.SCHapi.model.entity.AvaliacaoQuarto;
import com.example.SCHapi.model.entity.TipoQuarto;
import com.example.SCHapi.service.AvaliacaoQuartoService;
import com.example.SCHapi.service.TipoQuartoService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/")
@RequiredArgsConstructor
public class AvaliacaoQuartoController {

    private final AvaliacaoQuartoService service;
    private final TipoQuartoService tipoQuartoService;
    
    public AvaliacaoQuarto converter(AvaliacaoQuartoDTO dto) {
        ModelMapper modelMapper = new ModelMapper();
        AvaliacaoQuarto avaliacaoQuarto = modelMapper.map(dto, AvaliacaoQuarto.class);
        if (dto.getIdTipoQuarto() != null) {
            Optional<TipoQuarto> tipoQuarto = tipoQuartoService.getTipoQuartoById(dto.getIdTipoQuarto());
            if (!tipoQuarto.isPresent()) {
                avaliacaoQuarto.setTipoQuarto(null);
            } else {
                avaliacaoQuarto.setTipoQuarto(tipoQuarto.get());
            }
        }
        return avaliacaoQuarto;
    }
}