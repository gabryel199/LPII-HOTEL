package com.example.SCHapi.api.dto;

import java.util.Date;

import com.example.SCHapi.model.entity.ProdutoSolicitado;
import com.example.SCHapi.model.entity.QuartosHospedagem;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HospedagemDTO {
    private Long id;
    private String status;
    private Date dataInicio;
    private Date dataFim1;
    private Date dataFim2;
    private Float valorEstadia;
    private String statusValorEstadia;
    private Float valorConsumo;
    private Float valorServicos;
    private Float valorEstadiaAdicional;
    private Float valorTotal;
    private Long idCliente;
    private Long idFuncionario;
    private Long idHotel;
    private Long idAvaliacoesHospedagem;
    private Long idQuartoHospedagem;
    private Long idReserva;

    private ListaQuartosHospedagemDTO listaQuartos;
    private ProdutoSolicitado produtoHospedagem;
}
