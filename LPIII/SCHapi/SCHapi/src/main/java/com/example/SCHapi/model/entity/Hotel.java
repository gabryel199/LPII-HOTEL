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
public class Hotel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String descricao;
    private float avaliacaoMedia;
    private String telefone1;
    private String telefone2;

    @OneToOne(cascade = CascadeType.ALL)
    private Endereco endereco;
    @OneToMany
    private List<Servico> servicos;
    @OneToMany
    private List<Quarto> quartos;
    @OneToMany
    private List<AvaliacaoHospedagem> avaliacaoHospedagens;
    @OneToMany
    private List<Reserva> reservas;
    @OneToMany
    private List<Hospedagem> hospedagens;
    @OneToMany
    private List<Funcionario> funcionarios;
    @OneToMany
    private List<Produto> produtos;
}
