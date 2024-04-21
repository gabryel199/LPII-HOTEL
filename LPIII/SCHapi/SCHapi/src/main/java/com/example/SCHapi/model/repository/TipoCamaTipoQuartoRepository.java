package com.example.SCHapi.model.repository;

import com.example.SCHapi.model.entity.TipoCamaTipoQuarto;
import com.example.SCHapi.model.entity.TipoQuarto;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TipoCamaTipoQuartoRepository extends JpaRepository<TipoCamaTipoQuarto, Long> {
    List<TipoCamaTipoQuarto> findByTipoQuarto(Optional<TipoQuarto> tipoQuarto);
}
