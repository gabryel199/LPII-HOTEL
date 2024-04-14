package com.example.SCHapi.service;

import com.example.SCHapi.exception.RegraNegocioException;
import com.example.SCHapi.model.entity.Hotel;
import com.example.SCHapi.model.entity.Reserva;
import com.example.SCHapi.model.repository.ReservaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class ReservaService {

    private ReservaRepository repository;

    public ReservaService(ReservaRepository repository) {
        this.repository = repository;
    }

    public List<Reserva> getReservas(){
        return repository.findAll();
    }

    public Optional<Reserva> getReservaById(Long id) {
        return repository.findById(id);
    }

    @Transactional
    public Reserva salvar(Reserva reserva) {
        validar(reserva);
        return repository.save(reserva);
    }


    public void validar(Reserva reserva) {

        Float valorReserva = reserva.getValorReserva();


        if (reserva.getDataInicio() == null || reserva.getDataInicio().trim().equals("") || !reserva.getDataInicio().matches("^\\d{2}/\\d{2}/\\d{4}-\\d{2}:\\d{2}$")){
            throw new RegraNegocioException("Data de inicio Invalido!!! Insira uma data valida dd/mm/yyy-hh:mm.");
        }
        if (reserva.getDataFim() == null || reserva.getDataFim().trim().equals("") || !reserva.getDataFim().matches("^\\d{2}/\\d{2}/\\d{4}-\\d{2}:\\d{2}$")){
            throw new RegraNegocioException("data fim Invalido!!! Insira uma data valida dd/mm/yyy-hh:mm.");
        }
        if (valorReserva == null || valorReserva <= 0 ) {
            throw new RegraNegocioException("Valor de reserva invalido, valor não pode ser menor ou igual a 0 ou nulo.");
        }

        if (reserva.getHotel() == null || reserva.getHotel().getId() == null || reserva.getHotel().getId() == 0) {
            throw new RegraNegocioException("Hotel inválid0!!!!");
        }
        if (reserva.getCliente() == null || reserva.getCliente().getId() == null || reserva.getCliente().getId() == 0) {
            throw new RegraNegocioException("Cliente inválid0!!!!");
        }
        if (reserva.getFuncionario() == null || reserva.getFuncionario().getId() == null || reserva.getFuncionario().getId() == 0) {
            throw new RegraNegocioException("Funcionario inválid0!!!!");
        }
        if (reserva.getStatusReserva() == null || reserva.getStatusReserva().getId() == null || reserva.getStatusReserva().getId() == 0) {
            throw new RegraNegocioException("Status de reserva inválid0!!!!");
        }

        // FALTA LISTA DE QUARTOS
    }
}
