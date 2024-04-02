package com.example.SCHapi.api.controller;

import java.util.Optional;

import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import com.example.SCHapi.api.dto.ClienteDTO;
import com.example.SCHapi.model.entity.Cliente;
import com.example.SCHapi.model.entity.Endereco;
import com.example.SCHapi.model.entity.Pais;
import com.example.SCHapi.model.entity.Uf;
import com.example.SCHapi.service.ClienteService;
import com.example.SCHapi.service.EnderecoService;
import com.example.SCHapi.service.PaisService;
import com.example.SCHapi.service.UfService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/")
@RequiredArgsConstructor
public class ClienteController {

    private final ClienteService service;
    private final EnderecoService enderecoService;
    private final UfService ufService;
    private final PaisService paisService;

    public Cliente converter(ClienteDTO dto) {
        ModelMapper modelMapper = new ModelMapper();
        Cliente cliente = modelMapper.map(dto, Cliente.class);
        Endereco endereco = modelMapper.map(dto, Endereco.class);
        cliente.setEndereco(endereco);
        if (dto.getIdUf() != null) {
            Optional<Uf> uf = ufService.getUfById(dto.getIdUf());
            if (!uf.isPresent()) {
                cliente.setUf(null);
            } else {
                cliente.setUf(uf.get());
            }
        }
        if (dto.getIdPais() != null) {
            Optional<Pais> pais = paisService.getPaisById(dto.getIdPais());
            if (!pais.isPresent()) {
                cliente.setPais(null);
            } else {
                cliente.setPais(pais.get());
            }
        }
        return cliente;
    }
}
