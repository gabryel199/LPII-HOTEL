package com.example.SCHapi.api.dto;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HorarioServicoDTO {
    private Long id;
    private String status;
    private int vagasTotal;
    private int vagasOcupadas;
    private Date data;
    private String horarioInicio;
    private String horarioFim;
}
