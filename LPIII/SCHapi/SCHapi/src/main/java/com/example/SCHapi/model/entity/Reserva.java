package com.example.SCHapi.model.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

//import org.hibernate.mapping.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Reserva {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String statusReserva;
    private float valorReserva;
    private Date dataInicio;
    private Date dataFim;

    @ManyToOne
    private Cliente cliente;
    @ManyToOne
    private Funcionario funcionario;
    @ManyToOne
    private Hotel hotel;
    @OneToOne
    private Hospedagem hospedagem;
    @ManyToMany
    private List<TipoQuarto> tipoQuartos;
}
