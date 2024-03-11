package com.example.SCHapi.api.dto;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HotelDTO {
    private Long id;
    private String titulo;
    private String descricao;
    private Float avaliacaoMedia;
    private Integer ddd1;
    private Integer num1;
    private Integer ddi2;
    private Integer ddd2;
    private Integer num2;
    private Integer numero;
    private String complemento;
    private String logradouro;
    private String bairro;
    private String cep;
    private String cidade;
    private Long idUf;
    private Long idPais;
}
