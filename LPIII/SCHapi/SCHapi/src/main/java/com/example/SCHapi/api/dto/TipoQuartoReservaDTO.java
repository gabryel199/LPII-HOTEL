package com.example.SCHapi.api.dto;

import com.example.SCHapi.model.entity.TipoQuartoReserva;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TipoQuartoReservaDTO {

    private Long id;
    private Long idReserva;
    private Long idTipoQuarto;

    public static TipoQuartoReservaDTO create(TipoQuartoReserva tipoQuartoReserva) {
        ModelMapper modelMapper = new ModelMapper();
        TipoQuartoReservaDTO dto = modelMapper.map(tipoQuartoReserva, TipoQuartoReservaDTO.class);

        return dto;
    }
}
