package com.example.SCHapi.api.controller;

import com.example.SCHapi.exception.RegraNegocioException;
import com.example.SCHapi.model.entity.Produto;
import com.example.SCHapi.model.entity.ProdutoSolicitado;
import com.example.SCHapi.model.entity.Hospedagem;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;

import com.example.SCHapi.api.dto.ProdutoSolicitadoDTO;
import com.example.SCHapi.service.ProdutoSolicitadoService;
import com.example.SCHapi.service.ProdutoService;
import com.example.SCHapi.service.HospedagemService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/produtoSolicitados")
@RequiredArgsConstructor
public class ProdutoSolicitadoController {

    private final ProdutoSolicitadoService service;
    private final ProdutoService produtoService;
    private final HospedagemService hospedagemService;

    @GetMapping()
    public ResponseEntity get() {
       List<ProdutoSolicitado> produtoSolicitados = service.getProdutoSolicitados();
        return ResponseEntity.ok(produtoSolicitados.stream().map(ProdutoSolicitadoDTO::create).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable("id") Long id) {
        Optional<ProdutoSolicitado> produtoSolicitado = service.getProdutoSolicitadoById(id);
        if (!produtoSolicitado.isPresent()) {
            return new ResponseEntity("ProdutoSolicitado não encontrada", HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(produtoSolicitado.map(ProdutoSolicitadoDTO::create));
    }

    @PostMapping
    public ResponseEntity post(@RequestBody ProdutoSolicitadoDTO dto) {
        try {
            ProdutoSolicitado produtoSolicitado = converter(dto);
            produtoSolicitado = service.salvar(produtoSolicitado);
            return new ResponseEntity(produtoSolicitado, HttpStatus.CREATED);
        } catch (RegraNegocioException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    public ProdutoSolicitado converter(ProdutoSolicitadoDTO dto) {
        ModelMapper modelMapper = new ModelMapper();
        ProdutoSolicitado produtoSolicitado = modelMapper.map(dto, ProdutoSolicitado.class);
        if (dto.getIdProduto() != null) {
            Optional<Produto> produto = produtoService.getProdutoById(dto.getIdProduto());
            if (!produto.isPresent()) {
                produtoSolicitado.setProduto(null);
            } else {
                produtoSolicitado.setProduto(produto.get());
            }
        }
        if (dto.getIdHospedagem() != null) {
            Optional<Hospedagem> hospedagem = hospedagemService.getHospedagemById(dto.getIdHospedagem());
            if (!hospedagem.isPresent()) {
                produtoSolicitado.setHospedagem(null);
            } else {
                produtoSolicitado.setHospedagem(hospedagem.get());
            }
        }
        return produtoSolicitado;
    }
}