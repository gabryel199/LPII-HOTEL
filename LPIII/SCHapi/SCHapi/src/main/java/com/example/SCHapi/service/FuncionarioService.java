package com.example.SCHapi.service;

import com.example.SCHapi.exception.RegraNegocioException;
import com.example.SCHapi.model.entity.*;
import com.example.SCHapi.model.repository.FuncionarioRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Objects;
import java.util.Optional;



@Service
public class FuncionarioService {

    private FuncionarioRepository repository;

    public FuncionarioService(FuncionarioRepository repository) {
        this.repository = repository;
    }

    public List<Funcionario> getFuncionarios() {
        return repository.findAll();
    }

    public Optional<Funcionario> getFuncionarioById(Long id) {
        return repository.findById(id);
    }

    @Transactional
    public Funcionario salvar(Funcionario funcionario) {
        validar(funcionario);
        return repository.save(funcionario);
    }

    public void validar(Funcionario funcionario) {

        String telefone1 = funcionario.getTelefone1();
        String telefone2 = funcionario.getTelefone2();
        String cpf = funcionario.getCpf();

        if (funcionario.getNome() == null || funcionario.getNome().trim().equals("")){
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
        if (funcionario.getSenha() == null || funcionario.getSenha().trim().equals("") || !funcionario.getSenha().matches("^(?=.*[A-Z])(?=.*\\d)(?=.*[@#$%^&+=!]).{8,}$")){
            throw new RegraNegocioException("Senha invalida, a senha deve conter no minimo uma letra maiuscula, no minimo um numero, no minimo um caracter especial e ter no minimo 8 digitos!!!!");
        }
        if (funcionario.getEmail() == null || funcionario.getEmail().trim().equals("") || !funcionario.getEmail().contains("@")) {
            throw new RegraNegocioException("O e-mail deve conter um '@'.");
        }
        if (funcionario.getDataNascimento() == null || !funcionario.getDataNascimento().matches("^\\d{2}/\\d{2}/\\d{4}$")) {
            throw new RegraNegocioException("Data de nascimento inválida! Insira uma data de nascimento no formato dd/MM/yyyy.");
        }
        if (funcionario.getSalario() < 1412.00 || funcionario.getSalario() == null) {
            throw new RegraNegocioException("Funcionario não pode ter um salario abaixo do salario minimo de 1412,00 reais.");
        }
        if (funcionario.getHoraInicio() == null || funcionario.getHoraInicio().trim().equals("") || !funcionario.getHoraInicio().contains(":") || !funcionario.getHoraInicio().matches("\\d{2}:\\d{2}$")) {
            throw new RegraNegocioException("O e-mail deve conter um '@'.");
        }
        if (funcionario.getHoraFim() == null || funcionario.getHoraFim().trim().equals("") || !funcionario.getHoraFim().contains(":") || !funcionario.getHoraFim().matches("\\d{2}:\\d{2}$")) {
            throw new RegraNegocioException("O e-mail deve conter um '@'.");
        }
        if (funcionario.getEmail() == null || funcionario.getEmail().trim().equals("") || !funcionario.getEmail().contains("@")) {
            throw new RegraNegocioException("O e-mail deve conter um '@'.");
        }
        // if (funcionario.getEndereco() == null || funcionario.getEndereco().getId() == null || funcionario.getEndereco().getId() == 0) {
        //     throw new RegraNegocioException("Endereço inválid0!!!!");
        // }
        if (funcionario.getCargo() == null || funcionario.getCargo().getId() == null || funcionario.getCargo().getId() == 0) {
            throw new RegraNegocioException("Cargo inválid0!!!!");
        }
        if (funcionario.getHotel() == null || funcionario.getHotel().getId() == null || funcionario.getHotel().getId() == 0) {
            throw new RegraNegocioException("Hotel inválid0!!!!");
        }

        // DESCRIÇÃO NÃO LANÇADA POIS O ATRIBUTO DESCRIÇÃO FOI CRIADO APENAS PARA GERAR A CLASSE
    }
}