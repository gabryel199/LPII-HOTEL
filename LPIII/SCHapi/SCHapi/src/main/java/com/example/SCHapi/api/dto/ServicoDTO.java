package com.example.SCHapi.api.dto;
import com.example.SCHapi.model.entity.HorarioServico;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServicoDTO {
    private Long id;
    private String titulo;
    private String descricao;
    private Float valorhorario;
    private String status;
    private String tipoReserva;
    private Long idHotel;
    private Long idTipoServico;
    private HorarioServicoDTO horarioServico;
}
