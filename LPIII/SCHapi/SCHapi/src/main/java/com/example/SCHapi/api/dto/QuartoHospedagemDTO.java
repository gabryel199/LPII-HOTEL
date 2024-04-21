package com.example.SCHapi.api.dto;

import com.example.SCHapi.model.entity.QuartoHospedagem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class QuartoHospedagemDTO {

    private Long id;
    private Long idQuarto;
    private Long idHospedagem;

    public static QuartoHospedagemDTO create(QuartoHospedagem quartoHospedagem) {
        ModelMapper modelMapper = new ModelMapper();
        QuartoHospedagemDTO dto = modelMapper.map(quartoHospedagem, QuartoHospedagemDTO.class);

        return dto;
    }
}
