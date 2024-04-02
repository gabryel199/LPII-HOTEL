package com.example.SCHapi.api.controller;

import org.modelmapper.ModelMapper;
import com.example.SCHapi.api.dto.AvaliacaoHospedagemDTO;
import com.example.SCHapi.model.entity.AvaliacaoHospedagem;
import com.example.SCHapi.service.AvaliacaoHospedagemService;

public class AvaliacaoHospedagemController {

    private final AvaliacaoHospedagemService service;

    public AvaliacaoHospedagem converter(AvaliacaoHospedagemDTO dto) {
        ModelMapper modelMapper = new ModelMapper();
        AvaliacaoHospedagem avaliacaohospedagem = modelMapper.map(dto, AvaliacaoHospedagem.class);
        
        return avaliacaohospedagem;
    }
}