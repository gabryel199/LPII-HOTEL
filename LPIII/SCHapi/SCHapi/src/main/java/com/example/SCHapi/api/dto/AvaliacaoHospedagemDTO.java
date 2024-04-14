package com.example.SCHapi.api.dto;

import com.example.SCHapi.model.entity.AvaliacaoHospedagem;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class AvaliacaoHospedagemDTO {

    private Long id;
    private Float nota;
    private String comentario;
    //private Long idHospedagem;
    //private Long hotel_id;

    public static AvaliacaoHospedagemDTO create(AvaliacaoHospedagem avaliacaoHospedagem) {
        ModelMapper modelMapper = new ModelMapper();
        AvaliacaoHospedagemDTO dto = modelMapper.map(avaliacaoHospedagem, AvaliacaoHospedagemDTO.class);

        //dto.idHospedagem = avaliacaoHospedagem.
        return dto;
    }
}

