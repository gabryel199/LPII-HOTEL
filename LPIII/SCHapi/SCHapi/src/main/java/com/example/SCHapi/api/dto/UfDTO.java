package com.example.SCHapi.api.dto;


import com.example.SCHapi.api.controller.UfController;
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
    //private Long idPais;
    private String nome;

    public static UfDTO create(UfController uf) {
        ModelMapper modelMapper = new ModelMapper();
        UfDTO dto = modelMapper.map(uf, UfDTO.class);

        //dto.nome = uf.getPais().getTitulo();

        return dto;
    }
}