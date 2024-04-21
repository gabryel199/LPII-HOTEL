package com.example.SCHapi.model.repository;

import com.example.SCHapi.model.entity.Hospedagem;
import com.example.SCHapi.model.entity.ServicoSolicitado;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;


public interface ServicoSolicitadoRepository extends JpaRepository<ServicoSolicitado, Long> {
    List<ServicoSolicitado> findByHospedagem(Optional<Hospedagem> hospedagem);

}