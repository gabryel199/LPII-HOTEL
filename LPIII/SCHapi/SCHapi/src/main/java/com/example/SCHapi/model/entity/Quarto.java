package com.example.SCHapi.model.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
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
    private String status;
    
    @ManyToOne
    private TipoQuarto tipoQuarto;
    @ManyToOne
    private Hotel hotel;
    @ManyToMany
    private List<Hospedagem> hospedagens;
}
