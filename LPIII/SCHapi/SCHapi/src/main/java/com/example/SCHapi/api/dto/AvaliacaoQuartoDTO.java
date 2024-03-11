package com.example.SCHapi.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AvaliacaoQuartoDTO {
    private Long id;
    private String nota;
    private String comentario;
    private Long idTipoQuarto;
}
