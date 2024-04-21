package com.example.SCHapi.api.dto;

import com.example.SCHapi.model.entity.TipoCamaTipoQuarto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class TipoCamaTipoQuartoDTO {

    private Long id;
    private Long idTipoCama;
    private Long idTipoQuarto;

    public static TipoCamaTipoQuartoDTO create(TipoCamaTipoQuarto tipoCamaTipoQuarto) {
        ModelMapper modelMapper = new ModelMapper();
        TipoCamaTipoQuartoDTO dto = modelMapper.map(tipoCamaTipoQuarto, TipoCamaTipoQuartoDTO.class);

        return dto;
    }
}
