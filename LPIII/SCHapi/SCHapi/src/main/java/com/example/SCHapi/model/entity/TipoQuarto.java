package com.example.SCHapi.model.entity;

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
    private Long id;;

    private String titulo;
    private String descricao;
    private Integer limiteCriancas;
    private Integer limiteAdultos;
    private Float precoBase;
    private Float avaliacaoMedia;
    private Integer diasCancelarReserva;
    private Float area;

    // @OneToOne(cascade = CascadeType.ALL)
    // private AvaliacaoQuarto avaliacaoQuarto;

}
