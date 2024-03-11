package com.example.SCHapi.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ComodidadeDTO {
    private Long id;
    private String titulo;
    private String descricao;
    private Long idTipoComodidade;
}
