package com.example.SCHapi.api.dto.Servico;

import com.example.SCHapi.model.entity.Servico.HorarioServico;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HorarioServicoDTO {

    private Long id;
    private String status;
    private int vagasTotal;
    private int vagasOcupadas;
    private Date data;
    private String horaInicio;
    private String horaFim;
    private Long idServico;

    public static HorarioServicoDTO create(HorarioServico horarioServico) {
        ModelMapper modelMapper = new ModelMapper();
        HorarioServicoDTO dto = modelMapper.map(horarioServico, HorarioServicoDTO.class);

        return dto;
    }
}
