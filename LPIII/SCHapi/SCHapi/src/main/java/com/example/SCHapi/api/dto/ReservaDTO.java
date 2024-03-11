package com.example.SCHapi.api.dto;
import java.util.Date;

import com.example.SCHapi.model.entity.ProdutoSolicitado;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReservaDTO {
    private Long id;
    private String status;
    private Date dataInicio;
    private Date dataFim;
    private String valorReserva;
    private Long idCliente;
    private Long idFuncionario;
    private Long idHotel;
    private Long idTipoQuarto;
    private Long idReserva;

    private ListaQuartosReservaDTO listaQuartos;
}
