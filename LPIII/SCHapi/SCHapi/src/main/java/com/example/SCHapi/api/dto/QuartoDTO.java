package com.example.SCHapi.api.dto;
import com.example.SCHapi.api.controller.QuartoController;
import com.example.SCHapi.model.entity.Cargo;
import com.example.SCHapi.model.entity.Quarto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class QuartoDTO {
    private Long id;
    private Integer numero;
    private Integer andar;
    private Integer bloco;
    private String status;
    private Long idHotel;
    private Long idTipoQuarto;

    public static QuartoDTO create(QuartoController quarto) {
        ModelMapper modelMapper = new ModelMapper();
        QuartoDTO dto = modelMapper.map(quarto, QuartoDTO.class);

        dto.idHotel = quarto.getId();
        return dto;
    }
}
