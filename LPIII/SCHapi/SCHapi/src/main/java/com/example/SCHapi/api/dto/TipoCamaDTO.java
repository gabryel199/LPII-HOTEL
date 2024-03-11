package com.example.SCHapi.api.dto;

import com.example.SCHapi.model.entity.CamaTipoQuarto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TipoCamaDTO {

    private Long id;
    private String titulo;
    private String descricao;
    private Integer ocupantes;
}
