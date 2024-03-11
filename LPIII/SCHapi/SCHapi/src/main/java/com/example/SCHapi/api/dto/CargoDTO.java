package com.example.SCHapi.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CargoDTO {
    private Long id;
    private String cargo;
    private String descricao;
    private Float salarioBase;
    private Long idHotel;
}
