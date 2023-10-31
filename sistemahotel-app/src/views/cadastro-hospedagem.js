import React, { useState, useEffect } from 'react';
import { useNavigate, useParams } from 'react-router-dom';

import Stack from '@mui/material/Stack';

import Card from '../components/card';

import FormGroup from '../components/form-group';

import { mensagemSucesso, mensagemErro } from '../components/toastr';

import '../custom.css';

import axios from 'axios';
import { BASE_URL } from '../config/axios';
import { URL_hospedagem } from '../config/axios';

function CadastroHospedagem() {
  
  const { idParam } = useParams();

  const navigate = useNavigate();

  const baseURL = `${URL_hospedagem}/hospedagem`;

  const [id, setId] = useState(0);
  const [var0, setVar0] = useState('');
  const [var1, setVar1] = useState('');
  const [var2, setVar2] = useState('');
  const [var3, setVar3] = useState('');
  const [var4, setVar4] = useState('');
  const [var5, setVar5] = useState('');
  const [var6, setVar6] = useState(0);
  const [var7, setVar7] = useState(0);
  const [var8, setVar8] = useState(0);
  const [var9, setVar9] = useState(0);
  const [var10, setVar10] = useState(0);
  const [var11, setVar11] = useState(0);
  const [var12, setVar12] = useState(0);
  const [var13, setVar13] = useState(0);
  const [var14, setVar14] = useState(0);

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
      setVar6(0);
      setVar7(0);
      setVar8(0);
      setVar9(0);
      setVar10(0);
      setVar11(0);
      setVar12(0);
      setVar13(0);
      setVar14(0);
    } else {
      setId(dados.id);
      setVar0(dados.status);
      setVar1(dados.dataInicio);
      setVar2(dados.dataFim1);
      setVar3(dados.dataFim2);
      setVar4(dados.valorEstadia);
      setVar5(dados.statusValorEstadia);
      setVar6(dados.valorConsumo);
      setVar7(dados.valorServicos);
      setVar8(dados.valorEstadiaAdicional);
      setVar9(dados.valorTotal);
      setVar10(dados.cliente_id);
      setVar11(dados.funcionario_id);
      setVar12(dados.hotel_id);
      setVar13(dados.avaliacoesHospedagem_id);
      setVar14(dados.quartoHospedagem_id);
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
      var6, 
      var7, 
      var8, 
      var9, 
      var10, 
      var11, 
      var12, 
      var14
    };
    data = JSON.stringify(data);
    if (idParam == null) {
      await axios
        .post(baseURL, data, {
          headers: { 'Content-Type': 'application/json' },
        })
        .then(function (response) {
          mensagemSucesso(`Hospedagem ${id} cadastrado com sucesso!`);
          navigate(`/listagem-hospedagem`);
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
          mensagemSucesso(`Hospedagem ${id} alterado com sucesso!`);
          navigate(`/listagem-hospedagem`);
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
      setVar0(dados.status);
      setVar1(dados.dataInicio);
      setVar2(dados.dataFim1);
      setVar3(dados.dataFim2);
      setVar4(dados.valorEstadia);
      setVar5(dados.statusValorEstadia);
      setVar6(dados.valorConsumo);
      setVar7(dados.valorServicos);
      setVar8(dados.valorEstadiaAdicional);
      setVar9(dados.valorTotal);
      setVar10(dados.cliente_id);
      setVar11(dados.funcionario_id);
      setVar12(dados.hotel_id);
      setVar13(dados.avaliacoesHospedagem_id);
      setVar14(dados.quartoHospedagem_id);
    }
  }

  useEffect(() => {
    buscar(); // eslint-disable-next-line
  }, [id]);

  if (!dados) return null;
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
              <FormGroup label='Data de Inicio: *' htmlFor='inputDataInicio'>
                <input
                  type='date'
                  id='inputDataInicio'
                  value={var1}
                  className='form-control'
                  name='DataInicio'
                  onChange={(e) => setVar1(e.target.value)}
                />
              </FormGroup>
              <FormGroup label='Data Fim: *' htmlFor='inputDataFim1'>
                <input
                  type='date'
                  id='inputDataFim1'
                  value={var2}
                  className='form-control'
                  name='DataFim1'
                  onChange={(e) => setVar2(e.target.value)}
                />
              </FormGroup>
              <FormGroup label='Data Extendida: *' htmlFor='inputDataFim2'>
                <input
                  type='date'
                  id='inputDataFim2'
                  value={var3}
                  className='form-control'
                  name='DataFim2'
                  onChange={(e) => setVar3(e.target.value)}
                />
              </FormGroup>
              <FormGroup label='Valor da Estadia: *' htmlFor='inputValorEstadia'>
                <input
                  type='num'
                  id='inputValorEstadia'
                  value={var4}
                  className='form-control'
                  name='ValorEstadia'
                  onChange={(e) => setVar4(e.target.value)}
                />
              </FormGroup>
              <FormGroup label='Status do Valor da Estadia: *' htmlFor='inputStatusValorEstadia'>
                <input
                  type='text'
                  id='inputStatusValorEstadia'
                  value={var5}
                  className='form-control'
                  name='StatusValorEstadia'
                  onChange={(e) => setVar5(e.target.value)}
                />
              </FormGroup>
              {/* <FormGroup label='Valor do Consumo: *' htmlFor='inputValorConsumo'>
                <input
                  type='number'
                  id='inputValorConsumo'
                  value={var6}
                  className='form-control'
                  name='ValorConsumo'
                  onChange={(e) => setVar6(e.target.value)}
                />
              </FormGroup> */}
             {/*  <FormGroup label='Valor dos Serviços: *' htmlFor='inputValorServicos'>
                <input
                  type='number'
                  id='inputValorServicos'
                  value={var7}
                  className='form-control'
                  name='ValorServicos'
                  onChange={(e) => setVar7(e.target.value)}
                />
              </FormGroup> */}
             {/*  <FormGroup label='Valor da Estadia Adicional: *' htmlFor='inputValorEstadiaAdicional'>
                <input
                  type='number'
                  id='inputValorEstadiaAdicional'
                  value={var8}
                  className='form-control'
                  name='ValorEstadiaAdicional'
                  onChange={(e) => setVar8(e.target.value)}
                />
              </FormGroup> */}
              {/* <FormGroup label='Valor Total: *' htmlFor='inputValorTotal'>
                <input
                  type='number'
                  id='inputValorTotal'
                  value={var9}
                  className='form-control'
                  name='ValorTotal'
                  onChange={(e) => setVar9(e.target.value)}
                />
              </FormGroup> */}

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

export default CadastroHospedagem;