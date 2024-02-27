package com.example.SCHapi.model.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ServicoSolicitado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private int quantidadeVagas;
    private float valorTotal;

    @ManyToMany
    private List<HorarioServico> HorarioServicos;
    @ManyToOne
    private Servico servico;
    @ManyToOne
    private Hospedagem hospedagem;
}
