import React, { useState, useEffect } from 'react';
import { useNavigate, useParams } from 'react-router-dom';

import Stack from '@mui/material/Stack';

import Card from '../components/card';

import FormGroup from '../components/form-group';

import { mensagemSucesso, mensagemErro } from '../components/toastr';

import '../custom.css';

import axios from 'axios';
import { BASE_URL } from '../config/axios';

function CadastroCliente() {
  
  const { idParam } = useParams();

  const navigate = useNavigate();

  const baseURL = `${BASE_URL}/cliente`;

  const [id, setId] = useState('');
  const [var0, setVar0] = useState('');//cpf
  const [var1, setVar1] = useState('');//nome
  const [var2, setVar2] = useState('');//dataN
  const [var11, setVar11] = useState('');//email
  const [var12, setVar12] = useState('');//senha1
  const [var13, setVar13] = useState('');//senha2
  const [var14, setVar14] = useState('');//tel

  const [var3, setVar3] = useState('');//pais
  const [var4, setVar4] = useState('');//uf
  const [var5, setVar5] = useState('');//cidade
  const [var6, setVar6] = useState('');//cep
  const [var7, setVar7] = useState('');//num
  const [var8, setVar8] = useState('');//com
  const [var9, setVar9] = useState('');//log
  const [var10, setVar10] = useState('');//bai 

  //ESSA é A PARTE DO BOTAO EDITAR
  const [dados, setDados] = React.useState([]);
  
  async function buscar() {
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
  }

  const [dados2, setDados2] = React.useState(null); //end

  useEffect(() => {
    //axios.get(`${BASE_URL}/endereco/${dados.endereco_id}`).then((response) => {
    axios.get(`${BASE_URL}/endereco/`).then((response) => {
      setDados2(response.data);
    });
    /*setVar5(dados2.cidade);
    setVar6(dados2.cep);
    setVar7(dados2.num);
    setVar8(dados2.complemento);
    setVar9(dados2.logradouro);
    setVar10('');*/
  }, []);

  const [dados3, setDados3] = React.useState(null); //uf

  useEffect(() => {
    //axios.get(`${BASE_URL}/uf/${dados2.UF_id}`).then((response) => {
    axios.get(`${BASE_URL}/uf/`).then((response) => {
      setDados3(response.data);
    });
    //setVar4(dados3.titulo)
  }, []);

  const [dados4, setDados4] = React.useState(null); //pais

  useEffect(() => {
    //axios.get(`${BASE_URL}/pais/${dados2.pais_id}`).then((response) => {
    axios.get(`${BASE_URL}/pais/`).then((response) => {
      setDados4(response.data);
    });
    //setVar3(dados4.titulo)
  }, []);

  useEffect(() => {
      buscar(); // eslint-disable-next-line
  }, [id]);

  if (!dados) return null;
  if (!dados2) return null;
  if (!dados3) return null;
  if (!dados4) return null;

  return (
    <div className='container'>
      <Card title='Cadastro de Cliente'>
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
            <FormGroup label='DataNascimento: *' htmlFor='inputDataNascimento'>
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
            <FormGroup label='Senha1: *' htmlFor='inputSenha1'>
                <input
                  type='password'
                  id='inputSenha1'
                  value={var12}
                  className='form-control'
                  name='senha1'
                  onChange={(e) => setVar12(e.target.value)}
                />
              </FormGroup>
            <FormGroup label='Senha2: *' htmlFor='inputSenha2'>
                <input
                  type='password'
                  id='inputSenha2'
                  value={var13}
                  className='form-control'
                  name='senha2'
                  onChange={(e) => setVar13(e.target.value)}
                />
              </FormGroup>
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
              <FormGroup label='Pais: *' htmlFor='selectPais'>
                <select
                  className='form-select'
                  id='selectPais'
                  name='pais'
                  value={var3}
                  onChange={(e) => setVar3(e.target.value)}
                >
                  <option key='0' value='0'>
                    {' '}
                  </option>
                  {dados4.map((dado) => (
                    <option key={dado.id} value={dado.id}>
                      {dado.titulo}
                    </option>
                  ))}
                </select>
              </FormGroup>
              <FormGroup label='UF: *' htmlFor='selectUF'>
                <select
                  className='form-select'
                  id='selectUF'
                  name='uf'
                  value={var4}
                  onChange={(e) => setVar4(e.target.value)}
                >
                  <option key='0' value='0'>
                    {' '}
                  </option>
                  {dados3.map((dado) => (
                    <option key={dado.id} value={dado.id}>
                      {dado.titulo}
                    </option>
                  ))}
                </select>
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
              <FormGroup label='Complemento: *' htmlFor='inputComplemento'>
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
                  type='button'
                  className='btn btn-success'
                >
                  Salvar
                </button>
                <button
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

export default CadastroCliente;