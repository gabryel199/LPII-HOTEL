package com.example.SCHapi.model.entity;

import java.util.List;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Hospedagem {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String statusHospedagem;
    private Data dataInicio;
    private Data dataFim1;
    private Data dataFim2;
    private float valorEstadia;
    private float valorConsumo;
    private float valorServicos;
    private float valorEstadiaAdicional;
    private float valorTotalPago;

    @ManyToOne
    private Cliente cliente;
    @ManyToOne
    private Funcionario funcionario;
    @ManyToOne
    private Hotel hotel;
    @OneToMany
    private List<AvaliacaoQuarto> avaliacaoQuartos;
    @ManyToMany
    private List<Quarto> quartos;
    @OneToMany
    private List<ServicoSolicitado> servicoSolicitados;
    @OneToMany
    private List<ProdutoSolicitado> produtoSolicitados;
    @OneToOne(cascade = CascadeType.ALL)
    private AvaliacaoHospedagem avaliacaoHospedagem;
    @OneToOne
    private Reserva reserva;

}
