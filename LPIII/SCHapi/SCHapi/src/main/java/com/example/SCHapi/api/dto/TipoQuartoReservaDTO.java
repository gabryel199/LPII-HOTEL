package com.example.SCHapi.api.dto;

import java.util.ArrayList;
import java.util.List;

import com.example.SCHapi.model.entity.TipoQuartoReserva;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TipoQuartoReservaDTO {
    private Long id;
    private Long tipoQuarto;
    private Integer qtd;

    public static TipoQuartoReservaDTO create(TipoQuartoReserva tipoQuartoReserva) {
        TipoQuartoReservaDTO dto = new TipoQuartoReservaDTO();
        dto.setId(tipoQuartoReserva.getId());
        dto.setTipoQuarto(tipoQuartoReserva.getTipoQuarto().getId());
        dto.setQtd(tipoQuartoReserva.getQtd());
        return dto;
    }

    public static List<TipoQuartoReservaDTO> createList (List<TipoQuartoReserva> listaQuartos) {
        List<TipoQuartoReservaDTO> listDto = new ArrayList<TipoQuartoReservaDTO>();
        for (TipoQuartoReserva tipoQuartoReserva : listaQuartos) {
            listDto.add(TipoQuartoReservaDTO.create(tipoQuartoReserva));
        }
        return listDto;
    }
}

