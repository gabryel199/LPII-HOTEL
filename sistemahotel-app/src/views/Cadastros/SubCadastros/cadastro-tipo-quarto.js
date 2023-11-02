import React, { useState, useEffect } from 'react';
import { useNavigate, useParams } from 'react-router-dom';

import Stack from '@mui/material/Stack';

import Card from '../../../components/card';

import FormGroup from '../../../components/form-group';

import { mensagemSucesso, mensagemErro } from '../../../components/toastr';

import '../../../custom.css';

import axios from 'axios';
import { BASE_URL } from '../../../config/axios';

function CadastroTipoQuarto() {
  
  const { idParam } = useParams();

  const navigate = useNavigate();

  const baseURL = `${BASE_URL}/tipoQuarto`;

  const [id, setId] = useState('');
  const [var1, setVar1] = useState('');
  const [var2, setVar2] = useState('');
  const [var3, setVar3] = useState('');
  const [var4, setVar4] = useState('');
  const [var5, setVar5] = useState('');
  const [var6, setVar6] = useState('');
  const [var7, setVar7] = useState('');

  const [dados, setDados] = React.useState([]);

  return (
    <div className='container'>
      <Card title='Cadastro de Tipos de Quartos'>
        <div className='row'>
          <div className='col-lg-12'>
            <div className='bs-component'>
              <FormGroup label='Titulo: *' htmlFor='inputTitulo'>
                <input
                  type='text'
                  id='inputTitulo'
                  value={var1}
                  className='form-control'
                  name='titulo'
                  onChange={(e) => setVar1(e.target.value)}
                />
              </FormGroup>
              <FormGroup label='Descricao: *' htmlFor='inputDescricao'>
                <input
                  type='text'
                  id='inputDescricao'
                  value={var2}
                  className='form-control'
                  name='descricao'
                  onChange={(e) => setVar2(e.target.value)}
                />
              </FormGroup>
              <FormGroup label='LimiteAdulto: *' htmlFor='inputLimiteAdulto'>
                <input
                  type='text'
                  id='inputLimiteAdulto'
                  value={var3}
                  className='form-control'
                  name='limiteadulto'
                  onChange={(e) => setVar3(e.target.value)}
                />
              </FormGroup>
              <FormGroup label='LimiteCrianca: *' htmlFor='inputLimiteCrianca'>
                <input
                  type='text'
                  id='inputLimiteCrianca'
                  value={var4}
                  className='form-control'
                  name='limitecrianca'
                  onChange={(e) => setVar4(e.target.value)}
                />
              </FormGroup>
              <FormGroup label='PrecoBase: *' htmlFor='inputPrecoBase'>
                <input
                  type='text'
                  id='inputPrecoBase'
                  value={var5}
                  className='form-control'
                  name='precobase'
                  onChange={(e) => setVar5(e.target.value)}
                />
              </FormGroup>
              <FormGroup label='DiasCancelarReserva: *' htmlFor='inputDiasCancelarReserva'>
                <input
                  type='text'
                  id='inputDiasCancelarReserva'
                  value={var6}
                  className='form-control'
                  name='diascancelarreserva'
                  onChange={(e) => setVar6(e.target.value)}
                />
              </FormGroup>
              <FormGroup label='Area: *' htmlFor='inputArea'>
                <input
                  type='text'
                  id='inputArea'
                  value={var7}
                  className='form-control'
                  name='area'
                  onChange={(e) => setVar7(e.target.value)}
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

export default CadastroTipoQuarto;