package com.example.SCHapi.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Quarto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int numero;
    private int andar;
    private String bloco;

    @ManyToOne
    private TipoQuarto tipoQuarto;
    @ManyToOne
    private Hotel hotel;
    @ManyToOne
    private StatusQuarto statusQuarto;
}
