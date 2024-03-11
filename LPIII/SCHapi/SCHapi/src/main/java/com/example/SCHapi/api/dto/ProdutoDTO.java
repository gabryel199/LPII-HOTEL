package com.example.SCHapi.api.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProdutoDTO {
    private Long id;
    private String titulo;
    private String descricao;
    private Float preco;
    private Integer quantidadeestoque;
    private Long idHotel;
    private Long idTipoProduto;
}
