package com.example.SCHapi.api.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FuncionarioDTO {
  private Long id;
  private String nome;
  private String cpf;
  private Date dataNacimento;
  private String email;
  private String senha;
  private String salario;
  private String horaInicio;
  private String horaFim;
  private String ddi1;
  private String ddd1;
  private String num1;
  private String ddi2;
  private String ddd2;
  private String num2;
  private String numero;,
  private String complemento;
  private String logradouro;
  private String bairro;
  private String cep;
  private String idCidade;
  private String idUf;
  private String idPais;
  private String idHotel;
  private String idCargo;
}
