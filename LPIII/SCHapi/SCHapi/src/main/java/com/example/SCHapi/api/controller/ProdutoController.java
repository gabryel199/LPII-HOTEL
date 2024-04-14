package com.example.SCHapi.api.controller;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.example.SCHapi.exception.RegraNegocioException;
import com.example.SCHapi.model.entity.TipoProduto;
import com.example.SCHapi.service.TipoProdutoService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;

import com.example.SCHapi.api.dto.ProdutoDTO;
import com.example.SCHapi.model.entity.Produto;
import com.example.SCHapi.model.entity.Hotel;
import com.example.SCHapi.service.ProdutoService;
import com.example.SCHapi.service.HotelService;
import com.example.SCHapi.service.ProdutoService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/produtos")
@RequiredArgsConstructor
public class ProdutoController {

    private final ProdutoService service;
    private final HotelService hotelService;
    private final TipoProdutoService tipoProdutoService;

    @GetMapping()
    public ResponseEntity get() {
       List<Produto> produtos = service.getProdutos();
        return ResponseEntity.ok(produtos.stream().map(ProdutoDTO::create).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable("id") Long id) {
        Optional<Produto> produto = service.getProdutoById(id);
        if (!produto.isPresent()) {
            return new ResponseEntity("Produto não encontrada", HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(produto.map(ProdutoDTO::create));
    }

    @PostMapping
    public ResponseEntity post(@RequestBody ProdutoDTO dto) {
        try {
            Produto produto = converter(dto);
            produto = service.salvar(produto);
            return new ResponseEntity(produto, HttpStatus.CREATED);
        } catch (RegraNegocioException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }


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
        if (dto.getIdTipoProduto() != null) {
            Optional<TipoProduto> tipoProduto = tipoProdutoService.getTipoProdutoById(dto.getIdTipoProduto());
            if (!tipoProduto.isPresent()) {
                produto.setTipoProduto(null);
            } else {
                produto.setTipoProduto(tipoProduto.get());
            }
        }
        return produto;
    }
}