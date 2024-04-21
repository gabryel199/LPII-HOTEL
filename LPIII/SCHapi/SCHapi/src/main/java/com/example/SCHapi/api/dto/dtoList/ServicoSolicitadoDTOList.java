package com.example.SCHapi.api.dto.dtoList;

import java.util.ArrayList;
import java.util.List;

import com.example.SCHapi.model.entity.TipoQuartoReserva;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ServicoSolicitadoDTOList {
    private Long id;
    private Long tipoQuarto;
    private Integer qtd;

    public static ServicoSolicitadoDTOList create(TipoQuartoReserva tipoQuartoReserva) {
        ServicoSolicitadoDTOList dto = new ServicoSolicitadoDTOList();
        dto.setId(tipoQuartoReserva.getId());
        dto.setTipoQuarto(tipoQuartoReserva.getTipoQuarto().getId());
        dto.setQtd(tipoQuartoReserva.getQtd());
        return dto;
    }

    public static List<ServicoSolicitadoDTOList> createList (List<TipoQuartoReserva> list) {
        List<ServicoSolicitadoDTOList> listDto = new ArrayList<ServicoSolicitadoDTOList>();
        for (TipoQuartoReserva tipoQuartoReserva : list) {
            listDto.add(ServicoSolicitadoDTOList.create(tipoQuartoReserva));
        }
        return listDto;
    }
}

