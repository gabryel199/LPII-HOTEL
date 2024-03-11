package com.example.SCHapi.api.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AvaliacaoHospedagemDTO {
    private Long id;
    private Integer nota;
    private String comentario;
    private Long idHotel;
}
