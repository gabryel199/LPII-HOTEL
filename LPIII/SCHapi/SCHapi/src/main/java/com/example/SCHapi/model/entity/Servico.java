package com.example.SCHapi.model.entity;

import jakarta.persistence.*;
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
    private Float valorPorHorario;
    private String tipoReserva;

    @ManyToOne
    private TipoServico tipoServico;
    @ManyToOne
    private Hotel hotel;
    @ManyToOne
    private  StatusServico statusServico;
}
