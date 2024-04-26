package com.example.SCHapi.api.controller.Pessoa;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.example.SCHapi.api.dto.Pessoa.UfDTO;
import com.example.SCHapi.exception.RegraNegocioException;
import com.example.SCHapi.model.entity.Pessoa.Pais;
import com.example.SCHapi.model.entity.Pessoa.Uf;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;

import com.example.SCHapi.service.Pessoa.PaisService;
import com.example.SCHapi.service.Pessoa.UfService;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/ufs")
@RequiredArgsConstructor
public class UfController {
    
    private final UfService service;
    private final PaisService paisService;

    @GetMapping()
    public ResponseEntity get() {
        List<Uf> ufs = service.getUfs(); 
        return ResponseEntity.ok(ufs.stream().map(UfDTO::create).collect(Collectors.toList()));
    }

    @GetMapping("/{id}")
    public ResponseEntity get(@PathVariable("id") Long id) {
        Optional<Uf> uf = service.getUfById(id);
        if (!uf.isPresent()) {
            return new ResponseEntity("UF não encontrado", HttpStatus.NOT_FOUND);
        }
        return ResponseEntity.ok(uf.map(UfDTO::create));
    }

    @PostMapping
    public ResponseEntity post(@RequestBody UfDTO dto) {
        try {
            Uf uf = converter(dto);
            uf = service.salvar(uf);
            return new ResponseEntity(uf, HttpStatus.CREATED);
        } catch (RegraNegocioException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity excluir(@PathVariable("id") Long id) {
        Optional<Uf> uf = service.getUfById(id);
        if (!uf.isPresent()) {
            return new ResponseEntity("Uf não encontrada", HttpStatus.NOT_FOUND);
        }
        try {
            service.excluir(uf.get());
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        } catch (RegraNegocioException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    public Uf converter(UfDTO dto) {
        ModelMapper modelMapper = new ModelMapper();
        Uf uf = modelMapper.map(dto, Uf.class);
        
        if (dto.getIdPais() != null) {
            Optional<Pais> pais = paisService.getPaisById(dto.getIdPais());
            if (!pais.isPresent()) {
                uf.setPais(null);
            } else {
                uf.setPais(pais.get());
            }
        }
        return uf;
    }
}
