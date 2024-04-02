package com.example.SCHapi.api.controller;

import java.util.Optional;

import org.modelmapper.ModelMapper;

import com.example.SCHapi.api.dto.FuncionarioDTO;
import com.example.SCHapi.model.entity.Funcionario;
import com.example.SCHapi.model.entity.Hotel;
import com.example.SCHapi.model.entity.Cargo;
import com.example.SCHapi.model.entity.Endereco;
import com.example.SCHapi.model.entity.Pais;
import com.example.SCHapi.model.entity.Uf;
import com.example.SCHapi.service.CargoService;
import com.example.SCHapi.service.ClienteService;
import com.example.SCHapi.service.EnderecoService;
import com.example.SCHapi.service.HotelService;
import com.example.SCHapi.service.PaisService;
import com.example.SCHapi.service.UfService;

public class FuncionarioController {

    private final ClienteService service;
    private final EnderecoService enderecoService;
    private final UfService ufService;
    private final PaisService paisService;
    private final HotelService hotelService;
    private final CargoService cargoService;

    public Funcionario converter(FuncionarioDTO dto) {
        ModelMapper modelMapper = new ModelMapper();
        Funcionario funcionario = modelMapper.map(dto, Funcionario.class);
        Endereco endereco = modelMapper.map(dto, Endereco.class);
        funcionario.setEndereco(endereco);
        if (dto.getIdUf() != null) {
            Optional<Uf> uf = ufService.getUfById(dto.getIdUf());
            if (!uf.isPresent()) {
                funcionario.setUf(null);
            } else {
                funcionario.setUf(uf.get());
            }
        }
        if (dto.getIdPais() != null) {
            Optional<Pais> pais = paisService.getPaisById(dto.getIdPais());
            if (!pais.isPresent()) {
                funcionario.setPais(null);
            } else {
                funcionario.setPais(pais.get());
            }
        }
        if (dto.getIdHotel() != null) {
            Optional<Hotel> hotel = hotelService.getHotelById(dto.getIdHotel());
            if (!hotel.isPresent()) {
                funcionario.setHotel(null);
            } else {
                funcionario.setHotel(hotel.get());
            }
        }
        if (dto.getIdCargo() != null) {
            Optional<Cargo> cargo = cargoService.getCargoById(dto.getIdCargo());
            if (!cargo.isPresent()) {
                funcionario.setCargo(null);
            } else {
                funcionario.setCargo(cargo.get());
            }
        }
        return funcionario;
    }
}