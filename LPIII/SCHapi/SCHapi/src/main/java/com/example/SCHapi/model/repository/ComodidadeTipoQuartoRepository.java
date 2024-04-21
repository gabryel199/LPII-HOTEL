package com.example.SCHapi.model.repository;

import com.example.SCHapi.model.entity.ComodidadeTipoQuarto;
import com.example.SCHapi.model.entity.TipoQuarto;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ComodidadeTipoQuartoRepository extends JpaRepository<ComodidadeTipoQuarto, Long> {
    List<ComodidadeTipoQuarto> findByTipoQuarto(Optional<TipoQuarto> tipoQuarto);
}
