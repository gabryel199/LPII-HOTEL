package com.example.SCHapi.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Cliente extends Usuario{

    @OneToMany(mappedBy = "cliente")
    private List<Reserva> reservas;
    @OneToMany(mappedBy = "cliente")
    private List<Hospedagem> Hospedagens;
}
