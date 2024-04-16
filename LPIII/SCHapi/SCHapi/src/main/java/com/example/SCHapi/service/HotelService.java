package com.example.SCHapi.service;

import com.example.SCHapi.exception.RegraNegocioException;
import com.example.SCHapi.model.entity.Hotel;
import com.example.SCHapi.model.entity.*;
import com.example.SCHapi.model.repository.HotelRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;
import java.util.Optional;



@Service
public class HotelService {

    private HotelRepository repository;

    public HotelService(HotelRepository repository) {
        this.repository = repository;
    }

    public List<Hotel> getHoteis() {
        return repository.findAll();
    }

    public Optional<Hotel> getHotelById(Long id) {
        return repository.findById(id);
    }

    @Transactional
    public Hotel salvar(Hotel hotel) {
        validar(hotel);
        return repository.save(hotel);
    }


    public void validar(Hotel hotel) {

        Float avaliacaoMedia = hotel.getAvaliacaoMedia();
        String telefone1 = hotel.getTelefone1();
        String telefone2 = hotel.getTelefone2();

        if (hotel.getTitulo() == null || hotel.getTitulo().trim().equals("")){
            throw new RegraNegocioException("Titulo Invalido!!! Insira um titulo valido.");
        }
        if (hotel.getDescricao() == null || hotel.getDescricao().trim().equals("")) {
            throw new RegraNegocioException("Descrição Invalida!!! Insira uma descrição valida.");
        }
        if (avaliacaoMedia == null || (avaliacaoMedia < 0 || avaliacaoMedia > 5 )) {
            throw new RegraNegocioException("A avaliação media do hotel tem que estar entre 0 e 5 e não pode ser nula, avaliação media invalida.");
        }
        if (telefone1 != null) {
            telefone1 = telefone1.replaceAll("[()\\-]", ""); // Remove parênteses e traços
            if (telefone1.length() != 12 && telefone1.length() != 13) {
                throw new RegraNegocioException("O telefone 1 não pode estar nulo e deve ter 10 ou 11 dígitos.");
            }
        }
        if (telefone2 != null) {
            telefone2 = telefone2.replaceAll("[()\\-]", ""); // Remove parênteses e traços
            if (telefone2.length() != 12 && telefone2.length() != 13) {
                throw new RegraNegocioException("O telefone 2 não pode estar nulo e deve ter 10 ou 11 dígitos.");
            }
        }
        if (hotel.getEndereco() == null || hotel.getEndereco().getId() == null || hotel.getEndereco().getId() == 0) {
            throw new RegraNegocioException("Endereço inválid0!!!!");
        }
    }

}