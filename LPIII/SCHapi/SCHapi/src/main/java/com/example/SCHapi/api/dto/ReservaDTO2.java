package com.example.SCHapi.api.dto;

import com.example.SCHapi.model.entity.Reserva;
import com.example.SCHapi.model.entity.TipoQuartoReserva;
import com.example.SCHapi.model.repository.TipoQuartoRepository;
import com.example.SCHapi.service.ReservaService;
import com.example.SCHapi.service.TipoQuartoReservaService;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;


import java.util.Date;
import java.util.List;
import java.util.Optional;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class ReservaDTO2 {

    private Long id;
    private Date dataInicio;
    private Date dataFim;
    private String valorReserva;
    private Long idCliente;
    private Long idFuncionario;
    private Long idHotel;
    private Long idStatusReserva;
    private List<TipoQuartoReserva> listaQuartos;



    public static ReservaDTO2 create(Reserva reserva, List<TipoQuartoReserva> listaQuartos) {
        ModelMapper modelMapper = new ModelMapper();
        ReservaDTO2 dto = modelMapper.map(reserva, ReservaDTO2.class);

        //aqui tem q pegar o TipoQuartoReserva e criar o ListaQuartos
       // TipoQuartoReservaService tipoQuartoReservaService = new TipoQuartoReservaService(factory.getRepository(TipoQuartoRepository.class);
        // ReservaService reservaService = new ReservaService(null);
        // Optional<Reserva> reservaO = reservaService.getReservaById(dto.getId());
        //dto.listaQuartos = tipoQuartoReservaService.getTipoQuartoReservaByReserva(Optional.of(reserva));
        dto.listaQuartos = listaQuartos;
        // dto.idHotel = reserva.getHotel().getId();
        // dto.idCliente = reserva.getCliente().getId();
        // dto.idFuncionario = reserva.getFuncionario().getId();
        // dto.idTipoQuarto = reserva.getTipoQuarto().getId();
        // dto.idStatusReserva = reserva.getStatusReserva().getId();

        return dto;
    }
}
