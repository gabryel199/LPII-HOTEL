package com.example.SCHapi.model.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Servico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String titulo;
    private String descricao;
    private String status;
    private float valorPorHorario;
    private String tipoReserva;

    @OneToMany(mappedBy = "servico")
    private List<ServicoSolicitado> servicoSolicitados;
    @OneToMany(mappedBy = "servico")
    private List<HorarioServico> horarioServicos;
    @ManyToOne
    private TipoServico tipoServico;
    @ManyToOne
    private Hotel hotel;
}
