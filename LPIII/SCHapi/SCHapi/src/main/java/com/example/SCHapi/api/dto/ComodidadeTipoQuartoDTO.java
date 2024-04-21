package com.example.SCHapi.api.dto;

import com.example.SCHapi.model.entity.ComodidadeTipoQuarto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ComodidadeTipoQuartoDTO {

    private Long id;
    private Long idComodidade;
    private Long idTipoQuarto;

    public static ComodidadeTipoQuartoDTO create(ComodidadeTipoQuarto comodidadeTipoQuarto) {
        ModelMapper modelMapper = new ModelMapper();
        ComodidadeTipoQuartoDTO dto = modelMapper.map(comodidadeTipoQuarto, ComodidadeTipoQuartoDTO.class);

        return dto;
    }
}
