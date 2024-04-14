package com.example.SCHapi.service;

import com.example.SCHapi.exception.RegraNegocioException;
import com.example.SCHapi.model.entity.*;
import com.example.SCHapi.model.repository.HospedagemRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;



@Service
public class HospedagemService {

    private HospedagemRepository repository;

    public HospedagemService(HospedagemRepository repository) {
        this.repository = repository;
    }

    public List<Hospedagem> getHospedagens() {
        return repository.findAll();
    }

    public Optional<Hospedagem> getHospedagemById(Long id) {
        return repository.findById(id);
    }

    @Transactional
    public Hospedagem salvar(Hospedagem hospedagem) {
        validar(hospedagem);
        return repository.save(hospedagem);
    }


    public void validar(Hospedagem hospedagem) {

        Float valorEstadia = hospedagem.getValorEstadia();
        Float valotTotalPago = hospedagem.getValorTotalPago();


        if (hospedagem.getDataInicio() == null || hospedagem.getDataInicio().trim().equals("") || !hospedagem.getDataInicio().matches("^\\d{2}/\\d{2}/\\d{4}-\\d{2}:\\d{2}$")){
            throw new RegraNegocioException("Data de inicio Invalido!!! Insira uma data valida dd/mm/yyy-hh:mm.");
        }
        if (hospedagem.getDataFim1() == null || hospedagem.getDataFim1().trim().equals("") || !hospedagem.getDataFim1().matches("^\\d{2}/\\d{2}/\\d{4}-\\d{2}:\\d{2}$")){
            throw new RegraNegocioException("data fim Invalido!!! Insira uma data valida dd/mm/yyy-hh:mm.");
        }
        if (hospedagem.getDataFim2() != null || !hospedagem.getDataFim1().trim().equals("")) {
            if(!hospedagem.getDataFim1().matches("^\\d{2}/\\d{2}/\\d{4}-\\d{2}:\\d{2}$")) {
                throw new RegraNegocioException("Data fim extendida Invalido!!! uma data valida dd/mm/yyy-hh:mm.");
            }
        }
        if (hospedagem.getValorEstadia() <= 0 || valorEstadia == null) {
            throw new RegraNegocioException("O valor de estadia não pode ser menor ou igual a 0 ou nulo.");
        }
        if (hospedagem.getValorConsumo() < 0 ) {
            throw new RegraNegocioException("O valor de consumo não pode ser menor que 0..");
        }
        if (hospedagem.getValorServicos() < 0 ) {
            throw new RegraNegocioException("O valor de serviços não pode ser menor que 0.");
        }
        if (hospedagem.getValorEstadiaAdicional() < 0) {
            throw new RegraNegocioException("O valor de estadia adicional não pode ser menor que 0.");
        }
        if (valotTotalPago != null || valotTotalPago != 0) {
            if (hospedagem.getValorTotalPago() < 0) {
                throw new RegraNegocioException("O valor pago antecipado não pode ser menor que 0.");
            }
        }
        if (hospedagem.getCliente() == null || hospedagem.getCliente().getId() == null || hospedagem.getCliente().getId() == 0) {
            throw new RegraNegocioException("Cliente inválido!!!!");
        }
        if (hospedagem.getFuncionario() == null || hospedagem.getFuncionario().getId() == null || hospedagem.getFuncionario().getId() == 0) {
            throw new RegraNegocioException("Funcionario inválido!!!!");
        }
        if (hospedagem.getHotel() == null || hospedagem.getHotel().getId() == null || hospedagem.getHotel().getId() == 0) {
            throw new RegraNegocioException("Hotel inválido!!!!");
        }
        if (hospedagem.getStatusHospedagem() == null || hospedagem.getStatusHospedagem().getId() == null || hospedagem.getStatusHospedagem().getId() == 0) {
            throw new RegraNegocioException("Status de hospedagem inválido!!!!");
        }
        if (hospedagem.getReserva() != null) {
            if (hospedagem.getAvaliacaoHospedagem().getId() == null || hospedagem.getAvaliacaoHospedagem().getId() == 0) {
                throw new RegraNegocioException("Reserva atrelada a hospedagem não pode ter id 0!!!");
            }
        }
        if (hospedagem.getAvaliacaoHospedagem() == null || hospedagem.getAvaliacaoHospedagem().getId() == null || hospedagem.getAvaliacaoHospedagem().getId() == 0) {
            throw new RegraNegocioException("Avaliação de hospedagem inválida!!!!");
        }

    }
}