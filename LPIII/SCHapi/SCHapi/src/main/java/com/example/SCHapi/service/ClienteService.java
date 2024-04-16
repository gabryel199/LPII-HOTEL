package com.example.SCHapi.service;

import com.example.SCHapi.exception.RegraNegocioException;
import com.example.SCHapi.model.entity.*;
import com.example.SCHapi.model.repository.ClienteRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;



@Service
public class ClienteService {

    private ClienteRepository repository;

    public ClienteService(ClienteRepository repository) {
        this.repository = repository;
    }

    public List<Cliente> getClientes() {
        return repository.findAll();
    }

    public Optional<Cliente> getClienteById(Long id) {
        return repository.findById(id);
    }

    @Transactional
    public Cliente salvar(Cliente cliente) {
        validar(cliente);
        return repository.save(cliente);
    }

    public void validar(Cliente cliente) {

        String telefone1 = cliente.getTelefone1();
        String telefone2 = cliente.getTelefone2();
        String cpf = cliente.getCpf();

        if (cliente.getNome() == null || cliente.getNome().trim().equals("")){
            throw new RegraNegocioException("Nome Invalido!!! Insira um nome valido.");
        }
        if (cpf != null) {
            cpf = cpf.replaceAll("[.\\-]", "");
            if (cpf.length() != 11) {
                throw new RegraNegocioException("CPF Invalido!!! Insira um CPF valido, com 11 digitos.");
            }
        }
        if (telefone1 != null) {
            telefone1 = telefone1.replaceAll("[()\\-]", ""); // Remove parênteses e traços
            if (telefone1.length() != 12 && telefone1.length() != 13) {
                throw new RegraNegocioException("O telefone 1 não pode estar nulo e deve ter 10 ou 11 dígitos.");
            }
        }
        if (telefone2 != null) {
            telefone2 = telefone2.replaceAll("[()\\-]", ""); // Remove parênteses e traços
            if (telefone2.length() != 12 && telefone2.length() != 13) {
                throw new RegraNegocioException("O telefone 2 não pode estar nulo e deve ter 10 ou 11 dígitos.");
            }
        }
        if (cliente.getSenha() == null || cliente.getSenha().trim().equals("") || !cliente.getSenha().matches("^(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!]).{8,}$")){
            throw new RegraNegocioException("Senha invalida, a senha deve conter no minimo uma letra maiuscula, no minimo um numero, no minimo um caracter especial e ter no minimo 8 digitos!!!!");
        }
        if (cliente.getEmail() == null || cliente.getEmail().trim().equals("") || !cliente.getEmail().contains("@")) {
            throw new RegraNegocioException("O e-mail deve conter um '@'.");
        }
        if (cliente.getDataNascimento() == null ||
                !cliente.getDataNascimento().matches("^\\d{2}/\\d{2}/\\d{4}$")) {
            throw new RegraNegocioException("Data de nascimento inválida! Insira uma data de nascimento no formato dd/MM/yyyy.");
        }
        // if (cliente.getEndereco() == null || cliente.getEndereco().getId() == null || cliente.getEndereco().getId() == 0) {
        //     throw new RegraNegocioException("Endereço inválid0!!!!");
        // }

        // DESCRIÇÃO NÃO LANÇADA POIS O ATRIBUTO DESCRIÇÃO FOI CRIADO APENAS PARA GERAR A CLASSE
    }

}