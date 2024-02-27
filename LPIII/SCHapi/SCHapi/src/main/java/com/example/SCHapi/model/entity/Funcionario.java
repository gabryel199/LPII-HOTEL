package com.example.SCHapi.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.Timer;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Funcionario extends Usuario{
    
    private float salario;
    private Timer horaInicio;
    private Timer horaFim;

    @OneToMany(mappedBy = "funcionario")
    private List<Reserva> reservas;
    @OneToMany(mappedBy = "funcionario")
    private List<Hospedagem> Hospedagens;
    @ManyToOne
    private Cargo cargo;
}
