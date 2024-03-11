package com.example.SCHapi.api.dto;


import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UfDTO {
    private Long id;
    private String titulo;
    private Long idPais;
}
