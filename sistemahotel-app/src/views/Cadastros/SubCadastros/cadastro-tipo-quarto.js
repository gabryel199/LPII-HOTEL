import React, { useState, useEffect } from 'react';
import { useNavigate, useParams } from 'react-router-dom';

import Stack from '@mui/material/Stack';

import Card from '../../../components/card';

import FormGroup from '../../../components/form-group';

import { mensagemSucesso, mensagemErro } from '../../../components/toastr';

import '../../../custom.css';

import axios from 'axios';
import { URL_quarto } from '../../../config/axios';

function CadastroTipoQuarto() {
  
  const { idParam } = useParams();

  const navigate = useNavigate();

  const baseURL = `${URL_quarto}/tipoQuarto`;

  const [id, setId] = useState(0);
  const [var1, setVar1] = useState('');//titulo
  const [var2, setVar2] = useState('');//descricao
  const [var3, setVar3] = useState('');//limiteAdulto
  const [var4, setVar4] = useState('');//limiteCrianca
  const [var5, setVar5] = useState('');//precoBase
  const [var6, setVar6] = useState('');//avaliacaoMedia
  const [var7, setVar7] = useState('');//diasCancelarReserva
  const [var8, setVar8] = useState('');//area

  const [dados, setDados] = React.useState([]);
  
  function inicializar() {
    if (idParam == null) {
      setId(0);
      setVar1('');
      setVar2('');
      setVar3('');
      setVar4('');
      setVar5('');
      setVar6('');
      setVar7('');
      setVar8('');
    } else {
      setId(dados.id);
      setVar1(dados.titulo);
      setVar2(dados.descricao);
      setVar3(dados.limiteAdulto);
      setVar4(dados.limiteCrianca);
      setVar5(dados.precoBase);
      setVar6(dados.avaliacaoMedia);
      setVar7(dados.diasCancelarReserva);
      setVar8(dados.area);
    }
  }

  async function salvar() {
    let data = {
      id,
      var1,
      var2
    };
    data = JSON.stringify(data);
    if (idParam == null) {
      await axios
        .post(baseURL, data, {
          headers: { 'Content-Type': 'application/json' },
        })
        .then(function (response) {
          mensagemSucesso(`Tipo de quarto ${var1} cadastrado com sucesso!`);
          navigate(`/listagem-tipo-quarto`);
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
          mensagemSucesso(`Tipo de quarto ${var1} alterado com sucesso!`);
          navigate(`/listagem-tipo-quarto`);
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
      setVar1(dados.titulo);
      setVar2(dados.descricao);
      setVar3(dados.limiteAdulto);
      setVar4(dados.limiteCrianca);
      setVar5(dados.precoBase);
      setVar6(dados.avaliacaoMedia);
      setVar7(dados.diasCancelarReserva);
      setVar8(dados.area);
    }
  }
  
  useEffect(() => {
      buscar(); // eslint-disable-next-line
  }, [id]);
 
  if (!dados) return null;

  return (
    <div className='container'>
      <Card title='Cadastro de Tipos de Quartos'>
        <div className='row'>
          <div className='col-lg-12'>
            <div className='bs-component'>
              <FormGroup label='Título: *' htmlFor='inputTitulo'>
                <input
                  type='text'
                  id='inputTitulo'
                  value={var1}
                  className='form-control'
                  name='titulo'
                  onChange={(e) => setVar1(e.target.value)}
                />
              </FormGroup>
              <FormGroup label='Descrição:' htmlFor='inputDescricao'>
                <input
                  type='text'
                  id='inputDescricao'
                  value={var2}
                  className='form-control'
                  name='descricao'
                  onChange={(e) => setVar2(e.target.value)}
                />
              </FormGroup>
              <FormGroup label='Limite de Adultos: *' htmlFor='inputLimiteAdulto'>
                <input
                  type='text'
                  id='inputLimiteAdulto'
                  value={var3}
                  className='form-control'
                  name='limiteadulto'
                  onChange={(e) => setVar3(e.target.value)}
                />
              </FormGroup>
              <FormGroup label='Limite de Crianças: *' htmlFor='inputLimiteCrianca'>
                <input
                  type='text'
                  id='inputLimiteCrianca'
                  value={var4}
                  className='form-control'
                  name='limitecrianca'
                  onChange={(e) => setVar4(e.target.value)}
                />
              </FormGroup>
              <FormGroup label='Preço base: *' htmlFor='inputPrecoBase'>
                <input
                  type='text'
                  id='inputPrecoBase'
                  value={var5}
                  className='form-control'
                  name='precobase'
                  onChange={(e) => setVar5(e.target.value)}
                />
              </FormGroup>
              <FormGroup label='Limite de dias para cancelamento de reserva: *' htmlFor='inputDiasCancelarReserva'>
                <input
                  type='text'
                  id='inputDiasCancelarReserva'
                  value={var7}
                  className='form-control'
                  name='diascancelarreserva'
                  onChange={(e) => setVar7(e.target.value)}
                />
              </FormGroup>
              <FormGroup label='Área: *' htmlFor='inputArea'>
                <input
                  type='text'
                  id='inputArea'
                  value={var8}
                  className='form-control'
                  name='area'
                  onChange={(e) => setVar8(e.target.value)}
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

export default CadastroTipoQuarto;