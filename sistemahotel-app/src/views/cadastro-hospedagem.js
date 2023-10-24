import React, { useState, useEffect } from 'react';
import { useNavigate, useParams } from 'react-router-dom';

import Stack from '@mui/material/Stack';

import Card from '../components/card';

import FormGroup from '../components/form-group';

import { mensagemSucesso, mensagemErro } from '../components/toastr';

import '../custom.css';

import axios from 'axios';
import { BASE_URL } from '../config/axios';

function CadastroHospedagem() {
  
  const { idParam } = useParams();

  const navigate = useNavigate();

  const baseURL = `${BASE_URL}/hospedagem`;

  const [id, setId] = useState('');
  const [var0, setVar0] = useState('');
  const [var1, setVar1] = useState('');
  const [var2, setVar2] = useState('');
  const [var3, setVar3] = useState('');
  const [var4, setVar4] = useState('');
  const [var5, setVar5] = useState('');
  const [var6, setVar6] = useState('');
  const [var7, setVar7] = useState('');
  const [var8, setVar8] = useState('');
  const [var9, setVar9] = useState('');

  const [dados, setDados] = React.useState([]);

  return (
    <div className='container'>
      <Card title='Cadastro de Hospedagens'>
        <div className='row'>
          <div className='col-lg-12'>
            <div className='bs-component'>
              <FormGroup label='Status: *' htmlFor='inputStatus'>
                <input
                  type='text'
                  id='inputStatus'
                  value={var0}
                  className='form-control'
                  name='Status'
                  onChange={(e) => setVar0(e.target.value)}
                />
              </FormGroup>
              <FormGroup label='Status: *' htmlFor='inputStatus'>
                <input
                  type='text'
                  id='inputStatus'
                  value={var0}
                  className='form-control'
                  name='Status'
                  onChange={(e) => setVar0(e.target.value)}
                />
              </FormGroup>
              <FormGroup label='DataInicio: *' htmlFor='inputDataInicio'>
                <input
                  type='text'
                  id='inputDataInicio'
                  value={var1}
                  className='form-control'
                  name='DataInicio'
                  onChange={(e) => setVar1(e.target.value)}
                />
              </FormGroup>
              <FormGroup label='DataFim1: *' htmlFor='inputDataFim1'>
                <input
                  type='text'
                  id='inputDataFim1'
                  value={var2}
                  className='form-control'
                  name='DataFim1'
                  onChange={(e) => setVar2(e.target.value)}
                />
              </FormGroup>
              <FormGroup label='DataFim2: *' htmlFor='inputDataFim2'>
                <input
                  type='text'
                  id='inputDataFim2'
                  value={var3}
                  className='form-control'
                  name='DataFim2'
                  onChange={(e) => setVar3(e.target.value)}
                />
              </FormGroup>
              <FormGroup label='ValorEstadia: *' htmlFor='inputValorEstadia'>
                <input
                  type='text'
                  id='inputValorEstadia'
                  value={var4}
                  className='form-control'
                  name='ValorEstadia'
                  onChange={(e) => setVar4(e.target.value)}
                />
              </FormGroup>
              <FormGroup label='StatusValorEstadia: *' htmlFor='inputStatusValorEstadia'>
                <input
                  type='text'
                  id='inputStatusValorEstadia'
                  value={var5}
                  className='form-control'
                  name='StatusValorEstadia'
                  onChange={(e) => setVar5(e.target.value)}
                />
              </FormGroup>
              <FormGroup label='ValorConsumo: *' htmlFor='inputValorConsumo'>
                <input
                  type='text'
                  id='inputValorConsumo'
                  value={var6}
                  className='form-control'
                  name='ValorConsumo'
                  onChange={(e) => setVar6(e.target.value)}
                />
              </FormGroup>
              <FormGroup label='ValorServicos: *' htmlFor='inputValorServicos'>
                <input
                  type='text'
                  id='inputValorServicos'
                  value={var7}
                  className='form-control'
                  name='ValorServicos'
                  onChange={(e) => setVar7(e.target.value)}
                />
              </FormGroup>
              <FormGroup label='ValorEstadiaAdicional: *' htmlFor='inputValorEstadiaAdicional'>
                <input
                  type='text'
                  id='inputValorEstadiaAdicional'
                  value={var8}
                  className='form-control'
                  name='ValorEstadiaAdicional'
                  onChange={(e) => setVar8(e.target.value)}
                />
              </FormGroup>
              <FormGroup label='ValorTotal: *' htmlFor='inputValorTotal'>
                <input
                  type='text'
                  id='inputValorTotal'
                  value={var9}
                  className='form-control'
                  name='ValorTotal'
                  onChange={(e) => setVar9(e.target.value)}
                />
              </FormGroup>
              <FormGroup label='ValorTotal: *' htmlFor='inputValorTotal'>
                <input
                  type='text'
                  id='inputValorTotal'
                  value={var9}
                  className='form-control'
                  name='ValorTotal'
                  onChange={(e) => setVar9(e.target.value)}
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

export default CadastroHospedagem;