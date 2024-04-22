package com.example.SCHapi.api.dto.Estadia;

import com.example.SCHapi.api.dto.Estadia.Lista.ProdutoSolicitadoDTOList;
import com.example.SCHapi.api.dto.Estadia.Lista.QuartoHospedagemDTOList;
import com.example.SCHapi.model.entity.Estadia.Hospedagem;
import com.example.SCHapi.model.entity.Estadia.Lista.ProdutoSolicitado;
import com.example.SCHapi.model.entity.Estadia.Lista.QuartoHospedagem;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class HospedagemDTO {

    private Long id;
    private Long status;
    private String dataInicio;
    private String dataFim1;
    private String dataFim2;
    private Float valorEstadia;
    private String statusValorEstadia;
    private Float valorConsumo;
    private Float valorServicos;
    private Float valorEstadiaAdicional;
    private Float valorTotal;
    private Long idCliente;
    private Long idFuncionario;
    private Long idHotel;
    private Long idStatusHospedagem;
    private Long idAvaliacaoHospedagem;
    private Long idReserva;
    
    private List<QuartoHospedagemDTOList> listaQuartos;
    private List<ProdutoSolicitadoDTOList> produtoHospedagem;


    public static HospedagemDTO create(Hospedagem hospedagem, List<QuartoHospedagem> listaQuartos, List<ProdutoSolicitado> produtoHospedagem) {
        // ModelMapper modelMapper = new ModelMapper();
        // HospedagemDTO dto = modelMapper.map(hospedagem, HospedagemDTO.class);

        
        HospedagemDTO dto = new HospedagemDTO();
        dto.id = hospedagem.getId();
        dto.status = hospedagem.getStatusHospedagem().getId();
        dto.dataInicio = hospedagem.getDataInicio();
        dto.dataFim1 = hospedagem.getDataFim1();
        dto.dataFim2 = hospedagem.getDataFim2();
        dto.valorEstadia = hospedagem.getValorEstadia();
        dto.statusValorEstadia = hospedagem.getStatusValorEstadia();
        dto.valorConsumo = hospedagem.getValorConsumo();
        dto.valorServicos = hospedagem.getValorServicos();
        dto.valorEstadiaAdicional = hospedagem.getValorEstadiaAdicional();
        dto.valorTotal = hospedagem.getValorTotalPago();
        dto.idCliente = hospedagem.getCliente().getId();
        dto.idFuncionario = hospedagem.getFuncionario().getId();
        dto.idHotel = hospedagem.getHotel().getId();
        dto.idStatusHospedagem = hospedagem.getStatusHospedagem().getId();
        if(hospedagem.getAvaliacaoHospedagem()!=null)
            dto.idAvaliacaoHospedagem = hospedagem.getAvaliacaoHospedagem().getId();
        else 
            dto.idAvaliacaoHospedagem = null;
        if(hospedagem.getReserva()!=null)
            dto.idReserva = hospedagem.getReserva().getId();
        else
            dto.idReserva = null;

        dto.listaQuartos = QuartoHospedagemDTOList.createList(listaQuartos);
        dto.produtoHospedagem = ProdutoSolicitadoDTOList.createList(produtoHospedagem);

        //dto.status = hospedagem.getStatusHospedagem().getId();
        // dto.idHotel = hospedagem.getHotel().getId();
        // dto.idCliente = hospedagem.getCliente().getId();
        // dto.idFuncionario = hospedagem.getFuncionario().getId();
        // dto.idStatusHospedagem = hospedagem.getStatusHospedagem().getId();
        // dto.idTipoQuarto = hospedagem.getTipoQuarto().getId();
        // dto.idReserva = hospedagem.getReserva().getId();
        // dto.idAvaliacaoHospedagem = hospedagem.getAvaliacaoHospedagem().getId();
        return dto;
    }
}
