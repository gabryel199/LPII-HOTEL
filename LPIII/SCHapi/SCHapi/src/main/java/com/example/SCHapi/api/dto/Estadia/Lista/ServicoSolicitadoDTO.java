package com.example.SCHapi.api.dto.Estadia.Lista;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

import com.example.SCHapi.model.entity.Estadia.Lista.ServicoSolicitado;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class ServicoSolicitadoDTO {

    private Long id;
    private Long idServico;
    private Long idHospedagem;

    public static ServicoSolicitadoDTO create(ServicoSolicitado servicoSolicitado) {
        ModelMapper modelMapper = new ModelMapper();
        ServicoSolicitadoDTO dto = modelMapper.map(servicoSolicitado, ServicoSolicitadoDTO.class);

        return dto;
    }
}
