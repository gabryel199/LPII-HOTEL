package com.example.SCHapi.api.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuartoDTO {
    private Long id;
    private Integer numero;
    private Integer andar;
    private Integer bloco;
    private String status;
    private Long idHhotel;
    private Long idTipoQuarto;
}
