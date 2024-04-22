package com.example.SCHapi.api.dto.Servico.Lista;


import com.example.SCHapi.model.entity.Servico.Lista.RelacaoHorarioServico;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class RelacaoHorarioServicoDTOList {
    private Long id;
    private String descricao;
    private Long idHorarioServico;
    private Long idServicoSolicitado;

    public static RelacaoHorarioServicoDTOList create(RelacaoHorarioServico relacaoHorarioServico) {
        RelacaoHorarioServicoDTOList dto = new RelacaoHorarioServicoDTOList();
        dto.setId(relacaoHorarioServico.getId());
        //dto.setIdHorarioServico(relacaoHorarioServico.getHorarioServico.getId());
        //dto.setIdServicoSolicitado(relacaoHorarioServico.getServicoSolicitado.getId());
        dto.setDescricao(relacaoHorarioServico.getDescricao());
        return dto;
    }

    public static List<RelacaoHorarioServicoDTOList> createList (List<RelacaoHorarioServico> list) {
        List<RelacaoHorarioServicoDTOList> listDto = new ArrayList<RelacaoHorarioServicoDTOList>();
        for (RelacaoHorarioServico relacaoHorarioServico : list) {
            listDto.add(RelacaoHorarioServicoDTOList.create(relacaoHorarioServico));
        }
        return listDto;
    }
}
