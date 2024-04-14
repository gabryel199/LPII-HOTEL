package com.example.SCHapi.service;

import com.example.SCHapi.exception.RegraNegocioException;
import com.example.SCHapi.model.entity.*;
import com.example.SCHapi.model.repository.TipoProdutoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;



@Service
public class TipoProdutoService {

    private TipoProdutoRepository repository;

    public TipoProdutoService(TipoProdutoRepository repository) {
        this.repository = repository;
    }

    public List<TipoProduto> getTipoProdutos() {
        return repository.findAll();
    }

    public Optional<TipoProduto> getTipoProdutoById(Long id) {
        return repository.findById(id);
    }

    @Transactional
    public TipoProduto salvar(TipoProduto tipoProduto) {
        validar(tipoProduto);
        return repository.save(tipoProduto);
    }




    public void validar(TipoProduto tipoProduto) {
        if (tipoProduto.getDescricao() == null || tipoProduto.getDescricao().trim().equals("")) {
            throw new RegraNegocioException("Descrição Invalida!!! Insira uma descrição valida.");
        }
        if (tipoProduto.getTitulo() == null || tipoProduto.getTitulo().trim().equals("")) {
            throw new RegraNegocioException("Titulo Invalido!!! Insira um titulo valido.");
        }
    }
}