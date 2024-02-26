package com.example.SCHapi.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


import java.util.Date;
import java.util.Timer;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class HorarioServicos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String status;
    private int vagasTotal;
    private int vagasOcupadas;
    private Date data;
    private Timer horaInicio;
    private Timer horaFim;

}
