import React, { useState, useEffect } from 'react';
import { useNavigate, useParams } from 'react-router-dom';

import Stack from '@mui/material/Stack';

import Card from '../../components/card';

import FormGroup from '../../components/form-group';

import { mensagemSucesso, mensagemErro } from '../../components/toastr';

import '../../custom.css';

import axios from 'axios';
import { URL_servico } from '../../config/axios';
import { URL_tipoServico } from '../../config/axios';

function CadastroServicos() {
  
  const { idParam } = useParams();

  const navigate = useNavigate();

  const baseURL = `${URL_servico}/servico`;

  const [id, setId] = useState('');
  const [var0, setVar0] = useState('');
  const [var1, setVar1] = useState('');
  const [var2, setVar2] = useState('');
  const [var3, setVar3] = useState('');

  
  const [dados2, setDados2] = React.useState(null); //tipo Produto

  useEffect(() => {
    axios.get(`${URL_tipoServico }/tipoServico`).then((response) => {
      setDados2(response.data);
    });
  }, []);

  if (!dados2) return null;

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
              <FormGroup label='Descrição: *' htmlFor='inputDescricao'>
                <input
                  type='text'
                  id='inputDescricao'
                  value={var1}
                  className='form-control'
                  name='descricao'
                  onChange={(e) => setVar1(e.target.value)}
                />
              </FormGroup>
              <FormGroup label='Preço: *' htmlFor='inputPreco'>
                <input
                  type='text'
                  id='inputPreco'
                  value={var2}
                  className='form-control'
                  name='preco'
                  onChange={(e) => setVar2(e.target.value)}
                />
              </FormGroup>
              <FormGroup label='Tipo: *' htmlFor='selectTipo'>
                <select
                  className='form-select'
                  id='selectTipo'
                  name='tipo'
                  value={var3}
                  onChange={(e) => setVar3(e.target.value)}
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

export default CadastroServicos;