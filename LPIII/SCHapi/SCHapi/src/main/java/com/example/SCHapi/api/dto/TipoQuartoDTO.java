package com.example.SCHapi.api.dto;

import com.example.SCHapi.model.entity.CamaTipoQuarto;
import com.example.SCHapi.model.entity.ComodidadeTipoQuarto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TipoQuartoDTO {
    private Long id;
    private String titulo;
    private String descricao;
    private Integer limiteAdulto;
    private Integer limiteCrianca;
    private Float precoBase;
    private Float avaliacaoMedia;
    private Integer diasCancelarReserva;
    private Float area;
    private CamaTipoQuarto CamaTipoQuarto;
    private ComodidadeTipoQuarto ComodidadeTipoQuarto;
}
