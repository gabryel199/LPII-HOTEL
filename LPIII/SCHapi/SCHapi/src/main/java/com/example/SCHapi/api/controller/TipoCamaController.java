package com.example.SCHapi.api.controller;

import com.example.SCHapi.exception.RegraNegocioException;
import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

import com.example.SCHapi.api.dto.TipoCamaDTO;
import com.example.SCHapi.model.entity.TipoCama;
import com.example.SCHapi.service.TipoCamaService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/tipoCamas")
@RequiredArgsConstructor
public class TipoCamaController {

    private final TipoCamaService service;
    
    @GetMapping()
    public ResponseEntity get() {
       List<TipoCama> tipoCamas = service.getTipoCamas();
        return ResponseEntity.ok(tipoCamas.stream().map(TipoCamaDTO::create).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable("id") Long id) {
        Optional<TipoCama> tipoCama = service.getTipoCamaById(id);
        if (!tipoCama.isPresent()) {
            return new ResponseEntity("TipoCama não encontrada", HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(tipoCama.map(TipoCamaDTO::create));
    }

    @PostMapping
    public ResponseEntity post(@RequestBody TipoCamaDTO dto) {
        try {
            TipoCama tipoCama = converter(dto);
            tipoCama = service.salvar(tipoCama);
            return new ResponseEntity(tipoCama, HttpStatus.CREATED);
        } catch (RegraNegocioException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


    public TipoCama converter(TipoCamaDTO dto) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(dto, TipoCama.class);
    }
}