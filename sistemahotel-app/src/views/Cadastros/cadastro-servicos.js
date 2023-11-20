import React, { useState, useEffect } from 'react';
import { useNavigate, useParams } from 'react-router-dom';

import Stack from '@mui/material/Stack';

import Card from '../../components/card';

import FormGroup from '../../components/form-group';

import { mensagemSucesso, mensagemErro } from '../../components/toastr';

import '../../custom.css';

import axios from 'axios';
import { URL_servico } from '../../config/axios';
import { URL_hotel } from '../../config/axios';

function CadastroServicos() {
  
  const { idParam } = useParams();

  const navigate = useNavigate();

  const baseURL = `${URL_servico}/servico`;

  const [id, setId] = useState(0);
  const [var0, setVar0] = useState('');//nome
  const [var1, setVar1] = useState('');//desc
  const [var2, setVar2] = useState('');//valor h orario
  const [var3, setVar3] = useState('');//status
  const [var4, setVar4] = useState(false);//tipo reserva
  const [var5, setVar5] = useState('');//id hotel
  const [var6, setVar6] = useState('');//id tipo serv

   //ESSA é A PARTE DO BOTAO EDITAR
   const [dados, setDados] = React.useState([]);
  
   function inicializar() {
     if (idParam == null) {
       setId('');
       setVar0('');
       setVar1('');
       setVar2('');
       setVar3('');
       setVar4(false);
       setVar5('');
     } else {
       setId(dados.id);
       setVar0(dados.titulo);
       setVar1(dados.descricao);
       setVar2(dados.valorhorario);
       setVar3(dados.status);
       setVar4(dados.tipoReserva);
       setVar5(dados.hotel_id);
       setVar6(dados.tipoServico_id);
     }
   }
 
   async function salvar() {
     let data = {
       id,
       var0,
       var1,
       var2,
       var3,
       var4,
       var5,
       var6
     };
     data = JSON.stringify(data);
     if (idParam == null) {
       await axios
         .post(baseURL, data, {
           headers: { 'Content-Type': 'application/json' },
         })
         .then(function (response) {
           mensagemSucesso(`Serviço ${var0} cadastrado com sucesso!`);
           navigate(`/listagem-servicos`);
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
           mensagemSucesso(`Serviço ${var0} alterado com sucesso!`);
           navigate(`/listagem-servicos`);
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
       setVar0(dados.titulo);
       setVar1(dados.descricao);
       setVar2(dados.valorhorario);
       setVar3(dados.status);
       setVar4(dados.tipoReserva);
       setVar5(dados.hotel_id);
       setVar6(dados.tipoServico_id);
     }
   }

  const [dados2, setDados2] = React.useState(null); //tipo servcio

  useEffect(() => {
    axios.get(`${URL_servico}/tipoServico`).then((response) => {
      setDados2(response.data);
    });
  }, []);

  const [dados3, setDados3] = React.useState(null); //hotel

  useEffect(() => {
    //axios.get(`${URL_produto}/tipoProduto`).then((response) => {
    axios.get(`${URL_hotel}/hotel`).then((response) => {
      setDados3(response.data);
    });
  }, []);

  useEffect(() => {
    buscar(); // eslint-disable-next-line
  }, [id]);
  
  if (!dados) return null;
  if (!dados2) return null;
  if (!dados3) return null;

  return (
    <div className='container'>
      <Card title='Cadastro de Serviços'>
        <div className='row'>
          <div className='col-lg-12'>
            <div className='bs-component'>
              <FormGroup label='Nome: *' htmlFor='inputNome'>
                <input
                  type='text'
                  id='inputNome'
                  value={var0}
                  className='form-control'
                  name='nome'
                  onChange={(e) => setVar0(e.target.value)}
                />
              </FormGroup>
              <FormGroup label='Descrição:' htmlFor='inputDescricao'>
                <input
                  type='text'
                  id='inputDescricao'
                  value={var1}
                  className='form-control'
                  name='descricao'
                  onChange={(e) => setVar1(e.target.value)}
                />
              </FormGroup>
              <FormGroup label='Preço por horário: *' htmlFor='inputPreco'>
                <input
                  type='text'
                  id='inputPreco'
                  value={var2}
                  className='form-control'
                  name='preco'
                  onChange={(e) => setVar2(e.target.value)}
                />
              </FormGroup>
              <FormGroup label='Status: *' htmlFor='inputStatus'>
                <input
                  type='text'
                  id='inputStatus'
                  value={var3}
                  className='form-control'
                  name='status'
                  onChange={(e) => setVar3(e.target.value)}
                />
              </FormGroup>
              <FormGroup label='Tipo reserva: *' htmlFor='inputTipoReserva'>
                <input
                  type='texte' //checkbox
                  id='inputTipoReserva'
                  value={var4}
                  className='form-control'
                  name='tiporeserva'
                  onChange={(e) => setVar4(e.target.checked)}
                />
              </FormGroup>
              <FormGroup label='Tipo: *' htmlFor='selectTipo'>
                <select
                  className='form-select'
                  id='selectTipo'
                  name='tipo'
                  value={var5}
                  onChange={(e) => setVar5(e.target.value)}
                >
                  <option key='0' value='0'>
                    {' '}
                  </option>
                  {dados2.map((dado) => (
                    <option key={dado.id} value={dado.id}>
                      {dado.titulo}
                    </option>
                  ))}
                </select>
              </FormGroup>
              <FormGroup label='Hotel: *' htmlFor='selectHotel'>
                <select
                  className='form-select'
                  id='selectHotel'
                  name='hotel'
                  value={var6}
                  onChange={(e) => setVar6(e.target.value)}
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

export default CadastroServicos;