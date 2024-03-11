package com.example.SCHapi.api.dto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.Date;

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
  private Float salario;
  private String horaInicio;
  private String horaFim;
  private Integer ddi1;
  private Integer ddd1;
  private Integer num1;
  private Integer ddi2;
  private Integer ddd2;
  private Integer num2;
  private Integer numero;
  private String complemento;
  private String logradouro;
  private String bairro;
  private String cep;
  private String cidade;
  private Long idUf;
  private Long idPais;
  private Long idHotel;
  private Long idCargo;
}
