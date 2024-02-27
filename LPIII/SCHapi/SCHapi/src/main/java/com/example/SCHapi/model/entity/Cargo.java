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
public class Cargo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String cargo;
    private String descricao;
    private float salarioBase;

    @OneToMany(mappedBy = "cargo")
    private List<Funcionario> funcionarios;
    @ManyToOne
    private Hotel hotel;
}
