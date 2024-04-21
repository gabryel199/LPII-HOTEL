package com.example.SCHapi.api.controller;

import com.example.SCHapi.api.dto.QuartoDTO;
import com.example.SCHapi.exception.RegraNegocioException;
import com.example.SCHapi.model.entity.Comodidade;
import com.example.SCHapi.model.entity.ComodidadeTipoQuarto;
import com.example.SCHapi.model.entity.Quarto;
import com.example.SCHapi.model.entity.TipoCama;
import com.example.SCHapi.model.entity.TipoCamaTipoQuarto;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

import com.example.SCHapi.api.dto.TipoQuartoDTO;
import com.example.SCHapi.api.dto.dtoList.ComodidadeTipoQuartoDTOList;
import com.example.SCHapi.api.dto.dtoList.TipoCamaTipoQuartoDTOList;
import com.example.SCHapi.model.entity.TipoQuarto;
import com.example.SCHapi.service.ComodidadeService;
import com.example.SCHapi.service.ComodidadeTipoQuartoService;
import com.example.SCHapi.service.TipoCamaService;
import com.example.SCHapi.service.TipoCamaTipoQuartoService;
import com.example.SCHapi.service.TipoQuartoService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/tipoQuartos")
@RequiredArgsConstructor
public class TipoQuartoController {

    private final TipoQuartoService service;
    private final TipoCamaTipoQuartoService tipoCamaTipoQuartoService;
    private final ComodidadeTipoQuartoService comodidadeTipoQuartoService;
    private final TipoCamaService tipoCamaService;
    private final ComodidadeService comodidadeService;

    // @GetMapping()
    // public ResponseEntity get() {
    //    List<TipoQuarto> tipoQuartos = service.getTipoQuartos();
    //     return ResponseEntity.ok(tipoQuartos.stream().map(TipoQuartoDTO::create).collect(Collectors.toList()));
    // }

    // @GetMapping("/{id}")
    // public ResponseEntity get(@PathVariable("id") Long id) {
    //     Optional<TipoQuarto> tipoQuarto = service.getTipoQuartoById(id);
    //     if (!tipoQuarto.isPresent()) {
    //         return new ResponseEntity("TipoQuarto não encontrada", HttpStatus.NOT_FOUND);
    //     }
    //     return ResponseEntity.ok(tipoQuarto.map(TipoQuartoDTO::create));
    // }

    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable("id") Long id) {
        Optional<TipoQuarto> tipoQuarto = service.getTipoQuartoById(id);
        List<TipoCamaTipoQuarto> camaTipoQuarto = tipoCamaTipoQuartoService.getTipoCamaTipoQuartoByTipoQuarto(tipoQuarto);
        List<ComodidadeTipoQuarto> comodidadeTipoQuarto = comodidadeTipoQuartoService.getComodidadeTipoQuartoByTipoQuarto(tipoQuarto);
        //Optional<List<TipoCamaTipoQuarto>> = Optional.of(camaTipoQuarto);
        TipoQuartoDTO tipoQuartoDTO = new TipoQuartoDTO();
        tipoQuartoDTO = TipoQuartoDTO.create(tipoQuarto.get(), comodidadeTipoQuarto, camaTipoQuarto);
        if (!tipoQuarto.isPresent()) {
            return new ResponseEntity("TipoQuarto não encontrada", HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(tipoQuartoDTO);
        // return ResponseEntity.ok(tipoquarto.map(TipoQuartoDTO::create));
    }
    
    @PostMapping
    public ResponseEntity post(@RequestBody TipoQuartoDTO dto) {
        try {
            TipoQuarto tipoQuarto = converter(dto);
            tipoQuarto = service.salvar(tipoQuarto);
            // loop para cada elemento da lista salvar o tipoquartoreserva
            for (TipoCamaTipoQuartoDTOList tipoCamaTipoQuartoDto : dto.getCamaTipoQuarto()) {
                TipoCamaTipoQuarto tipoCamaTipoQuarto = converterTipoCamaTipoQuarto(tipoCamaTipoQuartoDto, tipoQuarto.getId());
                tipoCamaTipoQuartoService.salvar(tipoCamaTipoQuarto);
            }
            // loop para cada elemento da lista salvar o comodidadetipoquarto
            for (ComodidadeTipoQuartoDTOList comodidadeTipoQuartoDto : dto.getComodidadeTipoQuarto()) {
                ComodidadeTipoQuarto comodidadeTipoQuarto = converterComodidadeTipoQuarto(comodidadeTipoQuartoDto, tipoQuarto.getId());
                comodidadeTipoQuartoService.salvar(comodidadeTipoQuarto);
            }
            return new ResponseEntity(tipoQuarto, HttpStatus.CREATED);
        } catch (RegraNegocioException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    public TipoQuarto converter(TipoQuartoDTO dto) {
        ModelMapper modelMapper = new ModelMapper();
        TipoQuarto tipoQuarto = modelMapper.map(dto, TipoQuarto.class);
        tipoQuarto.setLimiteAdultos(dto.getLimiteAdulto()) ;
        tipoQuarto.setLimiteCriancas(dto.getLimiteCrianca()) ;
        return tipoQuarto;
    }

    public TipoCamaTipoQuarto converterTipoCamaTipoQuarto(TipoCamaTipoQuartoDTOList dto, Long tipoQuartoId) {
        ModelMapper modelMapper = new ModelMapper();
        TipoCamaTipoQuarto tipoCamaTipoQuarto = modelMapper.map(dto, TipoCamaTipoQuarto.class);
        if (tipoQuartoId != null) {
            Optional<TipoQuarto> tipoQuarto = service.getTipoQuartoById(tipoQuartoId);
            if (!tipoQuarto.isPresent()) {
                tipoCamaTipoQuarto.setTipoQuarto(null);
            } else {
                tipoCamaTipoQuarto.setTipoQuarto(tipoQuarto.get());
            }
        }
        if (dto.getIdTipoCama() != null) {
            Optional<TipoCama> tipoCama = tipoCamaService.getTipoCamaById(dto.getIdTipoCama());
            if (!tipoCama.isPresent()) {
                tipoCamaTipoQuarto.setTipoCama(null);
            } else {
                tipoCamaTipoQuarto.setTipoCama(tipoCama.get());
            }
        }
        return tipoCamaTipoQuarto;
    }

    public ComodidadeTipoQuarto converterComodidadeTipoQuarto(ComodidadeTipoQuartoDTOList dto, Long tipoQuartoId) {
        ModelMapper modelMapper = new ModelMapper();
        ComodidadeTipoQuarto comodidadeTipoQuarto = modelMapper.map(dto, ComodidadeTipoQuarto.class);
        comodidadeTipoQuarto.setQuantidade(dto.getQtd());
        if (tipoQuartoId != null) {
            Optional<TipoQuarto> tipoQuarto = service.getTipoQuartoById(tipoQuartoId);
            if (!tipoQuarto.isPresent()) {
                comodidadeTipoQuarto.setTipoQuarto(null);
            } else {
                comodidadeTipoQuarto.setTipoQuarto(tipoQuarto.get());
            }
        }
        if (dto.getIdComodidade() != null) {
            Optional<Comodidade> comodidade = comodidadeService.getComodidadeById(dto.getIdComodidade());
            if (!comodidade.isPresent()) {
                comodidadeTipoQuarto.setComodidade(null);
            } else {
                comodidadeTipoQuarto.setComodidade(comodidade.get());
            }
        }
        return comodidadeTipoQuarto;
    }
}