package com.example.SCHapi.model.entity;

import java.util.List;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Produto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;

    private String titulo;
    private String descricao;
    private float precoBase;
    private int quantEstoque;

    @ManyToOne
    private CategoriaProduto categoriaProduto;
    @ManyToOne
    private Hotel hotel;
    @OneToMany(mappedBy = "produto")
    private List<ProdutoSolicitado> produtoSolicitados;
}
