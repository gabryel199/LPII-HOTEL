package com.example.SCHapi.service;


import com.example.SCHapi.exception.RegraNegocioException;
import com.example.SCHapi.model.entity.Produto;
import com.example.SCHapi.model.entity.TipoQuarto;

import com.example.SCHapi.model.repository.TipoQuartoRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class TipoQuartoService {

    private TipoQuartoRepository repository;
    public TipoQuartoService(TipoQuartoRepository repository) {
        this.repository = repository;
    }

    public List<TipoQuarto> getTipoQuartos(){
        return repository.findAll();
    }

    public Optional<TipoQuarto> getTipoQuartoById(Long id) {
        return repository.findById(id);
    }

    @Transactional
    public TipoQuarto salvar(TipoQuarto tipoQuarto) {
        validar(tipoQuarto);
        return repository.save(tipoQuarto);
    }


    public void validar(TipoQuarto tipoQuarto) {

        Integer limiteAdultos = tipoQuarto.getLimiteAdultos();
        Integer diasCancelarReserva = tipoQuarto.getDiasCancelarReserva();

        Float precoBase = tipoQuarto.getPrecoBase();
        Float avaliacaoMedia = tipoQuarto.getAvaliacaoMedia();
        Float area = tipoQuarto.getArea();


        if (tipoQuarto.getTitulo() == null || tipoQuarto.getTitulo().trim().equals("")){
            throw new RegraNegocioException("Titulo Invalido!!! Insira um titulo valido.");
        }
        if (tipoQuarto.getDescricao() == null || tipoQuarto.getDescricao().trim().equals("")) {
            throw new RegraNegocioException("Descrição Invalida!!! Insira uma descrição valida.");
        }
        if (tipoQuarto.getLimiteAdultos() <= 0 || limiteAdultos == null) {
            throw new RegraNegocioException("A quantidade de limite de adulto tem que ser maior que 0.");
        }
        if (tipoQuarto.getLimiteCriancas() < 0 ) {
            throw new RegraNegocioException("A quantidade de limite de crianças não pode ser menor que 0.");
        }

        if (tipoQuarto.getPrecoBase() < 0 || tipoQuarto.getAvaliacaoMedia() > 5 || precoBase == null) {
            throw new RegraNegocioException("O preço de um tipo de quarto tem que ser maior que 0.");
        }
        if (tipoQuarto.getAvaliacaoMedia() <= 0 || avaliacaoMedia == null) {
            throw new RegraNegocioException("O preço de um tipo de quarto tem que ser maior que 0.");
        }
        if (tipoQuarto.getArea() <= 0 || area == null) {
            throw new RegraNegocioException("A area do quarto não pode ser menor ou igual a 0.");
        }
        if (tipoQuarto.getDiasCancelarReserva() <= 0 || diasCancelarReserva == null) {
            throw new RegraNegocioException("A quantidade de dias para se cancelar a reserva tem que ser maior que 0.");
        }

        // NÃO FEITO A DE LISTA

    }
}
