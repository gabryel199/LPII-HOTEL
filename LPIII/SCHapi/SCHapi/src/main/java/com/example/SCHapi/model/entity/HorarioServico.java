package com.example.SCHapi.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.Date;
import java.util.List;
import java.util.Timer;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HorarioServico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String status;
    private int vagasTotal;
    private int vagasOcupadas;
    private Date data;
    private Timer horaInicio;
    private Timer horaFim;

    @ManyToMany
    private List<ServicoSolicitado> servicoSolicitado;
    @ManyToOne
    private Servico servico;

}
