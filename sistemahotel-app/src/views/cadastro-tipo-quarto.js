import React, { useState, useEffect } from 'react';
import { useNavigate, useParams } from 'react-router-dom';

import Stack from '@mui/material/Stack';

import Card from '../components/card';

import FormGroup from '../components/form-group';

import { mensagemSucesso, mensagemErro } from '../components/toastr';

import '../custom.css';

import axios from 'axios';
import { BASE_URL } from '../config/axios';

function CadastroTipoQuarto() {
  
  const { idParam } = useParams();

  const navigate = useNavigate();

  const baseURL = `${BASE_URL}/tipoQuarto`;

  const [id, setId] = useState('');
  const [nome, setNome] = useState('');
  const [nome1, setNome1] = useState('');
  const [nome2, setNome2] = useState('');
  const [nome3, setNome3] = useState('');
  const [idCoordenador, setIdCoordenador] = useState(0);

  const [dados, setDados] = React.useState([]);

  return (
    <div className='container'>
      <Card title='Cadastro de Produto'>
        <div className='row'>
          <div className='col-lg-12'>
            <div className='bs-component'>
              <FormGroup label='Nome: *' htmlFor='inputNome'>
                <input
                  type='text'
                  id='inputNome'
                  value={nome}
                  className='form-control'
                  name='nome'
                  onChange={(e) => setNome(e.target.value)}
                />
              </FormGroup>
              <FormGroup label='Descrição: *' htmlFor='inputDescricao'>
                <input
                  type='text'
                  id='inputDescricao'
                  value={nome1}
                  className='form-control'
                  name='descricao'
                  onChange={(e) => setNome1(e.target.value)}
                />
              </FormGroup>
              <FormGroup label='Preço: *' htmlFor='inputPreco'>
                <input
                  type='text'
                  id='inputPreco'
                  value={nome2}
                  className='form-control'
                  name='preco'
                  onChange={(e) => setNome2(e.target.value)}
                />
              </FormGroup>
              <FormGroup label='Categoria: *' htmlFor='inputCategoria'>
                <input
                  type='text'
                  id='inputCategoria'
                  value={nome3}
                  className='form-control'
                  name='categoria'
                  onChange={(e) => setNome3(e.target.value)}
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