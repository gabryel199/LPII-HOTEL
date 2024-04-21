package com.example.SCHapi.model.repository;

import com.example.SCHapi.model.entity.Hospedagem;
import com.example.SCHapi.model.entity.QuartoHospedagem;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;




public interface QuartoHospedagemRepository extends JpaRepository<QuartoHospedagem, Long> {
    List<QuartoHospedagem> findByHospedagem(Optional<Hospedagem> hospedagem);

}