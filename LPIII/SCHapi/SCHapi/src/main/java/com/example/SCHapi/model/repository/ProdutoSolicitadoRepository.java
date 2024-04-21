package com.example.SCHapi.model.repository;

import com.example.SCHapi.model.entity.Hospedagem;
import com.example.SCHapi.model.entity.ProdutoSolicitado;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdutoSolicitadoRepository extends JpaRepository<ProdutoSolicitado, Long> {
    List<ProdutoSolicitado> findByHospedagem(Optional<Hospedagem> hospedagem);
}
