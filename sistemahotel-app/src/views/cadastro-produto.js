import React, { useState, useEffect } from 'react';
import { useNavigate, useParams } from 'react-router-dom';

import Stack from '@mui/material/Stack';

import Card from '../components/card';

import FormGroup from '../components/form-group';

import { mensagemSucesso, mensagemErro } from '../components/toastr';

import '../custom.css';

import axios from 'axios';
import { BASE_URL } from '../config/axios';

function CadastroProduto() {
  
  const { idParam } = useParams();

  const navigate = useNavigate();

  const baseURL = `${BASE_URL}/produto`;

  const [id, setId] = useState('');
  const [var0, setVar0] = useState('');//nome
  const [var1, setVar1] = useState('');//descricao
  const [var2, setVar2] = useState('');//preco 
  const [var3, setVar3] = useState('');//qat

  //ESSA é A PARTE DO BOTAO EDITAR
  const [dados, setDados] = React.useState([]);
  
  async function buscar() {
    await axios.get(`${baseURL}/${idParam}`).then((response) => {
      setDados(response.data);
    });
    setId(dados.id);
    setVar0(dados.titulo);
    setVar1(dados.descricao);
    setVar2(dados.preco);
    setVar3(dados.quantidadeestoque);
  }

  const [dados2, setDados2] = React.useState(null);

  useEffect(() => {
    axios.get(`${BASE_URL}/tipoProduto`).then((response) => {
      setDados2(response.data);
    });
  }, []);

  useEffect(() => {
      buscar(); // eslint-disable-next-line
  }, [id]);

  if (!dados) return null;
  
  // ESSA é A PARTE DO HTML
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
              <FormGroup label='Quantidade: *' htmlFor='inputQuantidade'>
                <input
                  type='text'
                  id='inputQuantidade'
                  value={var3}
                  className='form-control'
                  name='quantidade'
                  onChange={(e) => setVar3(e.target.value)}
                />
              </FormGroup>
              {/*<FormGroup label='Categoria: *' htmlFor='inputCategoria'>
                <input
                  type='text'
                  id='inputCategoria'
                  value={var4}
                  className='form-control'
                  name='categoria'
                  onChange={(e) => setVar4(e.target.value)}
                />
              </FormGroup>*/}
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

export default CadastroProduto;