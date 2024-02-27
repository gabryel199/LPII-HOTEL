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
public class TipoQuarto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String descricao;
    private int limiteCriancas;
    private int limiteAdultos;
    private float precoBase;
    private float avaliacaoMedia;
    private int diasCancelarReserva;
    private float area;

    @OneToMany(mappedBy = "tipoQuarto")
    private List<TipoCamaQuarto> tipoCamaQuartos;
    @ManyToOne
    private Cargo cargo;
    @ManyToMany
    private List<Reserva> reservas;
    @OneToOne(cascade = CascadeType.ALL)
    private AvaliacaoQuarto avaliacaoQuarto;
    @OneToMany(mappedBy = "tipoQuarto")
    private List<ComodidadesTipoQuarto> comodidadesTipoQuartos;
    @OneToMany(mappedBy = "tipoQuarto")
    private List<Quarto> quartos;
}
