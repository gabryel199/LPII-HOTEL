package com.example.SCHapi.api.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TipoProdutoDTO {
    private Long id;
    private String titulo;
    private String descricao;
}
