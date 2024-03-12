package com.example.SCHapi.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class ListaQuartosHospedagemDTO {
    private Long id;
    private Integer qtd;
    private Float idQuarto;
    private Long idTipoQuarto;////////
}