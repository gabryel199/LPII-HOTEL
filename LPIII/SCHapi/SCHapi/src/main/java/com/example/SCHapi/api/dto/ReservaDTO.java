package com.example.SCHapi.api.dto;

import com.example.SCHapi.model.entity.Reserva;
import com.example.SCHapi.model.entity.TipoQuartoReserva;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;


import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ReservaDTO {

    private Long id;
    //private Long status;
    private String dataInicio;
    private String dataFim;
    private Float valorReserva;
    private Long idCliente;
    private Long idFuncionario;
    private Long idHotel;
    private Long idStatusReserva;
    List<TipoQuartoReserva> listaQuartos;



    public static ReservaDTO create(Reserva reserva) {
        ModelMapper modelMapper = new ModelMapper();
        ReservaDTO dto = modelMapper.map(reserva, ReservaDTO.class);
        
        // dto.status = reserva.getStatusReserva().getId();
        //dto.status = dto.idStatusReserva;

        //aqui tem q pegar o TipoQuartoReserva e criar o ListaQuartos
       // TipoQuartoReservaService tipoQuartoReservaService = new TipoQuartoReservaService(factory.getRepository(TipoQuartoRepository.class);
        // ReservaService reservaService = new ReservaService(null);
        // Optional<Reserva> reservaO = reservaService.getReservaById(dto.getId());
        //dto.listaQuartos = tipoQuartoReservaService.getTipoQuartoReservaByReserva(Optional.of(reserva));
        dto.listaQuartos = null;
        // dto.idHotel = reserva.getHotel().getId();
        // dto.idCliente = reserva.getCliente().getId();
        // dto.idFuncionario = reserva.getFuncionario().getId();
        // dto.idTipoQuarto = reserva.getTipoQuarto().getId();
        // dto.idStatusReserva = reserva.getStatusReserva().getId();

        return dto;
    }
}
