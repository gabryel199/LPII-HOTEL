package com.example.SCHapi.api.dto;


import java.util.Date;

import com.example.SCHapi.model.entity.Cargo;
import com.example.SCHapi.model.entity.Uf;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UfDTO {
    private Long id;
    private String titulo;
    private Long idPais;

    public static UfDTO create(Uf uf) {
        ModelMapper modelMapper = new ModelMapper();
        UfDTO dto = modelMapper.map(uf, UfDTO.class);

        return dto;
    }
}
