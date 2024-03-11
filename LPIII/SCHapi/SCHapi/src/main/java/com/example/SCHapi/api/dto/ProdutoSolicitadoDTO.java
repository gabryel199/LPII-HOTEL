package com.example.SCHapi.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProdutoSolicitadoDTO {
    private Long id;
    private Integer quant;
    private Float valorTotal;
    private Long idProduto;
}
