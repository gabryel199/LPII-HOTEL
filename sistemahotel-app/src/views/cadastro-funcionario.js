import React, { useState, useEffect } from 'react';
import { useNavigate, useParams } from 'react-router-dom';

import Stack from '@mui/material/Stack';

import Card from '../components/card';

import FormGroup from '../components/form-group';

import { mensagemSucesso, mensagemErro } from '../components/toastr';

import '../custom.css';

import axios from 'axios';
import { BASE_URL } from '../config/axios';
import { URL_funcionario } from '../config/axios';
import { URL_endereco } from '../config/axios';

function CadastroFuncionario() {
  
  const { idParam } = useParams();

  const navigate = useNavigate();

  const baseURL = `${URL_funcionario}/funcionario`;
  const baseURL_endereco = `${URL_endereco}/endereco`;
  const baseURL_uf = `${URL_endereco}/uf`;
  const baseURL_pais = `${URL_endereco}/pais`;

  const [id, setId] = useState('');
  const [var0, setVar0] = useState('');//cpf
  const [var1, setVar1] = useState('');//nome
  const [var2, setVar2] = useState('');//dataN
  const [var11, setVar11] = useState('');//email
  const [var12, setVar12] = useState('');//senha1
  const [var13, setVar13] = useState('');//senha2
  const [var14, setVar14] = useState('');//tel
  const [var15, setVar15] = useState('');//tel2
  
  const [var16, setVar16] = useState('');//hInicio
  const [var17, setVar17] = useState('');//hFim
  const [var18, setVar18] = useState('');//salario

  const [var3, setVar3] = useState('');//pais
  const [var4, setVar4] = useState('');//uf
  const [var5, setVar5] = useState('');//cidade
  const [var6, setVar6] = useState('');//cep
  const [var7, setVar7] = useState('');//num
  const [var8, setVar8] = useState('');//com
  const [var9, setVar9] = useState('');//log
  const [var10, setVar10] = useState('');//bai 
  
  const [var19, setVar19] = useState('');//endereco_id
  const [var20, setVar20] = useState('');//hotel_id
  const [var21, setVar21] = useState('');//cargo_id

  const [dados, setDados] = React.useState([]);

  function inicializar() {
    if (idParam == null) {
      setId('');
      setVar0('');
      setVar1('');
      setVar2('');
      setVar3('');
      setVar4('');
      setVar5('');
      setVar6('');
      setVar7('');
      setVar8('');
      setVar9('');
      setVar10('');
      setVar11('');
      setVar12('');
      setVar13('');
      setVar14('');
      setVar15('');
      setVar16('');
      setVar17('');
      setVar18('');
      setVar19('');
      setVar20('');
      setVar21('');
    } else {
      setId(dados.id);
      setVar0(dados.cpf);
      setVar1(dados.nome);
      setVar2(dados.dataNacimento);
      setVar11(dados.email);
      setVar12(dados.senha);
      setVar13(dados.senha);
      setVar14('');
      setVar15('');
      
      setVar16(dados.horaInicio);
      setVar17(dados.horaFim);
      setVar18(dados.salario);

      setVar19(dados.endereco_id);
      setVar20(dados.hotel_id);
      setVar21(dados.cargo_id);
    }
  }

  async function salvar() {
    let data = {
      id,
      var1,
      var0,
      var2,
      var11,
      var12,
      var18,
      var16,
      var17,
      var19,
      var20,
      var21
    };
    data = JSON.stringify(data);
    if (idParam == null) {
      await axios
        .post(baseURL, data, {
          headers: { 'Content-Type': 'application/json' },
        })
        .then(function (response) {
          mensagemSucesso(`Funcionário ${var1} cadastrado com sucesso!`);
          navigate(`/listagem-funcionario`);
        })
        .catch(function (error) {
          mensagemErro(error.response.data);
        });
    } else {
      await axios
        .put(`${baseURL}/${idParam}`, data, {
          headers: { 'Content-Type': 'application/json' },
        })
        .then(function (response) {
          mensagemSucesso(`Funcionário ${var1} alterado com sucesso!`);
          navigate(`/listagem-funcionario`);
        })
        .catch(function (error) {
          mensagemErro(error.response.data);
        });
    }
  }


  async function buscar() {
    if (idParam != null) {
      await axios.get(`${baseURL}/${idParam}`).then((response) => {
        setDados(response.data);
      });
      setId(dados.id);
      setVar0(dados.cpf);
      setVar1(dados.nome);
      setVar2(dados.dataNacimento);
      setVar11(dados.email);
      setVar12(dados.senha);
      setVar13(dados.senha);
      setVar14('');
      setVar15('');
      
      setVar16(dados.horaInicio);
      setVar17(dados.horaFim);
      setVar18(dados.salario);

      setVar19(dados.endereco_id);
      setVar20(dados.hotel_id);
      setVar21(dados.cargo_id);
    }
  }
  
  const [dados5, setDados5] = React.useState(null); //tipo Produto

  useEffect(() => {
    //axios.get(`${URL_produto}/tipoProduto`).then((response) => {
    axios.get(`${URL_funcionario}/cargo`).then((response) => {
      setDados5(response.data);
    });
  }, []);

  useEffect(() => {
    buscar(); // eslint-disable-next-line
}, [id]);

  if (!dados) return null;
  if (!dados5) return null;
  // if (!dados2) return null;
  // if (!dados3) return null;
  return (
    <div className='container'>
      <Card title='Cadastro de Funcionários'>
        <div className='row'>
          <div className='col-lg-12'>
            <div className='bs-component'>
            <FormGroup label='CPF: *' htmlFor='inputCPF'>
              <input
                type='number'
                id='inputCPF'
                value={var0}
                className='form-control'
                name='cpf'
                onChange={(e) => setVar0(e.target.value)}
              />
            </FormGroup>
            <FormGroup label='Nome: *' htmlFor='inputNome'>
                <input
                  type='text'
                  id='inputNome'
                  value={var1}
                  className='form-control'
                  name='nome'
                  onChange={(e) => setVar1(e.target.value)}
                />
              </FormGroup>
            <FormGroup label='Data de Nascimento: *' htmlFor='inputDataNascimento'>
                <input
                  type='date'
                  id='inputDataNascimento'
                  value={var2}
                  className='form-control'
                  name='datanascimento'
                  onChange={(e) => setVar2(e.target.value)}
                />
              </FormGroup>
            <FormGroup label='Email: *' htmlFor='inputEmail'>
                <input
                  type='email'
                  id='inputEmail'
                  value={var11}
                  className='form-control'
                  name='email'
                  onChange={(e) => setVar11(e.target.value)}
                />
              </FormGroup>
            {/* <FormGroup label='Senha1: *' htmlFor='inputSenha1'>
                <input
                  type='password'
                  id='inputSenha1'
                  value={var12}
                  className='form-control'
                  name='senha1'
                  onChange={(e) => setVar12(e.target.value)}
                />
              </FormGroup> */}
            {/* <FormGroup label='Senha2: *' htmlFor='inputSenha2'>
                <input
                  type='password'
                  id='inputSenha2'
                  value={var13}
                  className='form-control'
                  name='senha2'
                  onChange={(e) => setVar13(e.target.value)}
                />
              </FormGroup> */}
              <FormGroup label='Telefone: *' htmlFor='inputTelefone'>
                <input
                  type='tel'
                  id='inputTelefone'
                  value={var14}
                  className='form-control'
                  name='telefone'
                  onChange={(e) => setVar14(e.target.value)}
                />
              </FormGroup>
              <FormGroup label='Cargo: *' htmlFor='selectCargo'>
                <select
                  className='form-select'
                  id='selectCargo'
                  name='cargo'
                  value={var21}
                  onChange={(e) => setVar21(e.target.value)}
                >
                  <option key='0' value='0'>
                    {' '}
                  </option>
                  {dados5.map((dado) => (
                    <option key={dado.id} value={dado.id}>
                      {dado.cargo}
                    </option>
                  ))}
                </select>
              </FormGroup>
            <FormGroup label='Horário de Início: *' htmlFor='inputHoraInicio'>
                <input
                  type='time'
                  id='inputHoraInicio'
                  value={var16}
                  className='form-control'
                  name='horainicio'
                  onChange={(e) => setVar16(e.target.value)}
                />
              </FormGroup>
            <FormGroup label='Horário de Término: *' htmlFor='inputHoraFim'>
                <input
                  type='time'
                  id='inputHoraFim'
                  value={var17}
                  className='form-control'
                  name='horafim'
                  onChange={(e) => setVar17(e.target.value)}
                />
              </FormGroup>
            {/* <FormGroup label='FolgaSemana: *' htmlFor='inputFolgaSemana'>
                <input
                  type='text'
                  id='inputFolgaSemana'
                  value={var18}
                  className='form-control'
                  name='folgasemana'
                  onChange={(e) => setVar18(e.target.value)}
                />
              </FormGroup> */}
              <FormGroup label='País: *' htmlFor='inputPais'>
                <input
                  type='text'
                  id='inputPais'
                  value={var3}
                  className='form-control'
                  name='pais'
                  onChange={(e) => setVar3(e.target.value)}
                />
              </FormGroup>
              <FormGroup label='UF: *' htmlFor='inputUF'>
                <input
                  type='text'
                  id='inputUF'
                  value={var4}
                  className='form-control'
                  name='UF'
                  onChange={(e) => setVar4(e.target.value)}
                />
              </FormGroup>
              <FormGroup label='Cidade: *' htmlFor='inputCidade'>
                <input
                  type='text'
                  id='inputCidade'
                  value={var5}
                  className='form-control'
                  name='cidade'
                  onChange={(e) => setVar5(e.target.value)}
                />
              </FormGroup>
              <FormGroup label='CEP: *' htmlFor='inputCEP'>
                <input
                  type='number'
                  id='inputCEP'
                  value={var6}
                  className='form-control'
                  name='CEP'
                  onChange={(e) => setVar6(e.target.value)}
                />
              </FormGroup>
              <FormGroup label='nº: *' htmlFor='inputNum'>
                <input
                  type='number'
                  id='inputNum'
                  value={var7}
                  className='form-control'
                  name='num'
                  onChange={(e) => setVar7(e.target.value)}
                />
              </FormGroup>
              <FormGroup label='Complemento: ' htmlFor='inputComplemento'>
                <input
                  type='number'
                  id='inputComplemento'
                  value={var8}
                  className='form-control'
                  name='complemento'
                  onChange={(e) => setVar8(e.target.value)}
                />
                </FormGroup>
              <FormGroup label='Logradouro: *' htmlFor='inputLogradouro'>
                <input
                  type='text'
                  id='inputLogradouro'
                  value={var9}
                  className='form-control'
                  name='logradouro'
                  onChange={(e) => setVar9(e.target.value)}
                />
                </FormGroup>
              <FormGroup label='Bairro: *' htmlFor='inputBairro'>
                <input
                  type='text'
                  id='inputBairro'
                  value={var10}
                  className='form-control'
                  name='bairro'
                  onChange={(e) => setVar10(e.target.value)}
                />
                </FormGroup>


              <br></br>
              <Stack spacing={1} padding={1} direction='row'>
                <button
                  onClick={salvar}
                  type='button'
                  className='btn btn-success'
                >
                  Salvar
                </button>
                <button
                  onClick={inicializar}
                  type='button'
                  className='btn btn-danger'
                >
                  Cancelar
                </button>
              </Stack>
            </div>
          </div>
        </div>
      </Card>
    </div>
  );
}

export default CadastroFuncionario;