import React, { useState, useEffect } from 'react';
import { useNavigate, useParams } from 'react-router-dom';

import Stack from '@mui/material/Stack';
import { IconButton } from '@mui/material';
import DeleteIcon from '@mui/icons-material/Delete';
import AddBoxIcon from '@mui/icons-material/AddBox';

//import InteractiveTable from '../../components/interactiveTable';

import Card from '../../components/card';

import FormGroup from '../../components/form-group';

import { mensagemSucesso, mensagemErro } from '../../components/toastr';

import '../../custom.css';


import axios from 'axios';
import { BASE_URL } from '../../config/axios';
import { URL_hospedagem } from '../../config/axios';
import { URL_status } from '../../config/axios';
import { URL_quarto } from '../../config/axios';
import { URL_hotel } from '../../config/axios';


let i = 1;
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
  const [var15, setVar15] = useState(0);
  const [var98, setVar98] = useState('');//teste
  const [var99, setVar99] = useState('');//teste
  const [var100, setVar100] = useState([]);//teste

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
      setVar15(0);
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
      setVar15(dados.reserva_id);
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
      var14,
      var15
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
      setVar15(dados.reserva_id);
    }
  }

  const [dados2, setDados2] = React.useState(null); //tipo Produto
  
  useEffect(() => {
    axios.get(`${URL_status}/statusHospedagem`).then((response) => {
      setDados2(response.data);
    });
  }, []);
  
  const [dados3, setDados3] = React.useState(null); //tipo Produto
  
  useEffect(() => {
    axios.get(`${URL_quarto}/quarto`).then((response) => {
      setDados3(response.data);
    });
  }, []);

  const [dados4, setDados4] = React.useState(null); //tipo Produto
  
  useEffect(() => {
    axios.get(`${URL_quarto}/tipoQuarto`).then((response) => {
      setDados4(response.data);
    });
  }, []);

  const [dados5, setDados5] = React.useState(null); //tipo Produto
  
  useEffect(() => {
    axios.get(`${URL_hotel}/hotel`).then((response) => {
      setDados5(response.data);
    });
  }, []);

  useEffect(() => {
    buscar(); // eslint-disable-next-line
  }, [id]);

  //tabela interativa
  const [tableData, setTableData] = useState([]);
  const InteractiveTable = () => {

  
    const addRow = () => {
  
      const newRow = {
        id: tableData.length + 1,
        tipoQuarto: "null",
        num: 0,
        quantidade: 0
      };
  
      setTableData([...tableData, newRow]);
    };
  
    const removeRow = (id) => {
  
      const updatedTableData = tableData.filter(row => row.id !== id);
  
      setTableData(updatedTableData);
    };
  
    const handleChange = (id, column, value) => {
      const updatedRows = tableData.map((row) =>
        row.id === id ? { ...row, [column]: value } : row
      );
      setTableData(updatedRows);
    };
  
    return (
      <div>
        <table className="table table-hover">
          <thead>
            <tr>
              <th scope="col">Tipo</th>
              <th scope="col">Nº</th>
              <th scope="col">Quantidade</th>
              <th scope="col">Ações</th>
            </tr>
          </thead>
          <tbody>
            {tableData.map(row => (
              <tr key={row.id} className="table-light">
                <td>
                  <select
                    className='form-select'
                    value={row.tipoQuarto}
                    onChange={(e) => handleChange(row.id, 'tipoQuarto', e.target.value)}
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
                </td>
                <td>
                  <select
                    className='form-select'
                    value={row.num}
                    onChange={(e) => handleChange(row.id, 'num', e.target.value)}
                  >
                    <option key='0' value='0'>
                      {' '}
                    </option>
                    {dados3.map((dado) => (
                      <option key={dado.id} value={dado.id}>
                        {dado.numero}
                      </option>
                    ))}
                  </select>
                </td>
                <td>
                  <input 
                    type='number' 
                    className='form-control'
                    value = {row.quantidade}
                    onChange={(e) => handleChange(row.id, 'quantidade', e.target.value)}>
                  </input>
                </td>
                <td>
                  <IconButton
                    aria-label='delete'
                    onClick={() => removeRow(row.id)}
                  >
                    <DeleteIcon />
                  </IconButton>
                </td>
              </tr>
            ))}
          </tbody>
        </table>
          <IconButton
            aria-label='add'
            onClick={() => addRow()}
          >
            <AddBoxIcon />
          </IconButton>
      </div>
    );
  };

  if (!dados) return null;
  if (!dados2) return null;
  if (!dados3) return null;
  if (!dados4) return null;
  if (!dados5) return null;
  return (
    <div className='container'>
      <Card title='Cadastro de Hospedagens'>
        <div className='row'>
          <div className='col-lg-12'>
            <div className='bs-component'>
              <FormGroup label='Status: *' htmlFor='selectStatus'>
                <select
                  className='form-select'
                  id='selectStatus'
                  name='status'
                  value={var0}
                  onChange={(e) => setVar0(e.target.value)}
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
                  value={var12}
                  onChange={(e) => setVar12(e.target.value)}
                >
                  <option key='0' value='0'>
                    {' '}
                  </option>
                  {dados5.map((dado) => (
                    <option key={dado.id} value={dado.id}>
                      {dado.titulo}
                    </option>
                  ))}
                </select>
              </FormGroup>
              <FormGroup label='Quartos: *' htmlFor='selectQuartos'>
                  <InteractiveTable dadosQuarto = {dados3} dadosTiposQuarto = {dados4}/>
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
              <FormGroup label='Data Extendida:' htmlFor='inputDataFim2'>
                <input
                  type='date'
                  id='inputDataFim2'
                  value={var3}
                  className='form-control'
                  name='DataFim2'
                  onChange={(e) => setVar3(e.target.value)}
                />
              </FormGroup>{/* 
              <FormGroup label='Quarto: *' htmlFor='selectQuarto'>
                <select
                  className='form-select'
                  id='selectQuarto'
                  name='quarto'
                  value={var14}
                  onChange={(e) => setVar14(e.target.value)}
                >
                  <option key='0' value='0'>
                    {' '}
                  </option>
                  {dados3.map((dado) => (
                    <option key={dado.id} value={dado.id}>
                      {dado.numero}
                    </option>
                  ))}
                </select> 
              </FormGroup> */}
              {/* <FormGroup label='Quartos: *' htmlFor='selectQuartos'>
                <table id = "tableQuartos" className="table table-hover">
                  <thead>
                    <tr>
                      <th scope="col">Tipo</th>
                      <th scope="col">Nº</th>
                      <th scope="col">Quantidade</th>
                      <th scope="col">Ações</th>
                    </tr>
                  </thead>
                  <tbody>
                    <tr className="table-light">
                      <td>
                        <select
                          className='form-select'
                          id='selectTipoQuarto'
                          name='tipoquarto'
                          value={var98}
                          onChange={(e) => setVar98(e.target.value)}
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
                      </td>
                      <td>
                        <select
                          className='form-select'
                          id='selectQuarto'
                          name='quarto'
                          value={var99}
                          onChange={(e) => setVar99(e.target.value)}
                        >
                          <option key='0' value='0'>
                            {' '}
                          </option>
                          {dados3.map((dado) => (
                            <option key={dado.id} value={dado.id}>
                              {dado.numero}
                            </option>
                          ))}
                        </select>
                      </td>
                      <td><input type='number' className='form-control'></input></td>
                      <td>
                          <IconButton
                            aria-label='delete'
                            // onClick={() => excluir(dado.id)}
                          >
                            <DeleteIcon />
                          </IconButton></td>
                    </tr>
                  </tbody>
                </table>
                <IconButton
                  aria-label='add'
                  onClick={() => newQuarto(dados3)}
                >
                  <AddBoxIcon />
                </IconButton>
              </FormGroup> */}
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
              <FormGroup label='ID cliente: *' htmlFor='inputIDCliente'>
                <input
                  type='text'
                  id='inputIDCliente'
                  value={var10}
                  className='form-control'
                  name='IDCliente'
                  onChange={(e) => setVar10(e.target.value)}
                />
              </FormGroup>
              <FormGroup label='ID funcionário: *' htmlFor='inputIDFuncionario'>
                <input
                  type='text'
                  id='inputIDFuncionario'
                  value={var11}
                  className='form-control'
                  name='IDFuncionario'
                  onChange={(e) => setVar11(e.target.value)}
                />
              </FormGroup>
              <FormGroup label='ID reserva:' htmlFor='inputIDReserva'>
                <input
                  type='text'
                  id='inputIDReserva'
                  value={var15}
                  className='form-control'
                  name='IDReserva'
                  onChange={(e) => setVar15(e.target.value)}
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

function newQuarto (dados3) {
  let table=document.getElementById("tableQuartos");     
  
  let newRow = table.insertRow(-1);
  if(i%2==0) {
    newRow.className = "table-light";
  }
  else {
    newRow.className = "table-dark";
  }

  let cell0 = newRow.insertCell(0);
  let cell1 = newRow.insertCell(1);
  let cell2 = newRow.insertCell(2);
  let cell3 = newRow.insertCell(3);

  let qtInput = document.createElement("input");
  qtInput.className = "form-control";
  qtInput.type = "number";
  cell2.appendChild(qtInput);

  /* const DeleteIcon = React.createElement("DeleteIcon");
  const IconButton = React.createElement("IconButton",{ariaLabel:'delete'},DeleteIcon);
 */
  let IconButton = document.createElement("IconButton");
  IconButton.ariaLabel = 'delete';
  let DeleteIcon = document.createElement("DeleteIcon");
  IconButton.appendChild(DeleteIcon);
  cell3.appendChild(IconButton);

  let dropdown1 = document.createElement("select");
  dropdown1.className = "form-select";
  let dropdown2 = document.createElement("select");
  dropdown2.className = "form-select";

  // Add options to the dropdowns
  let names = ["New Name 1", "New Name 2"];
  let ages = ["New Age 1", "New Age 2"];

  for (let i = 0; i < names.length; i++) {
      let option1 = document.createElement("option");
      option1.value = names[i];
      option1.text = names[i];
      dropdown1.appendChild(option1);

      let option2 = document.createElement("option");
      option2.value = ages[i];
      option2.text = ages[i];
      dropdown2.appendChild(option2);
  }

  cell0.appendChild(dropdown1);
  cell1.appendChild(dropdown2);

  /* let row = document.createElement("TR");
  //row.setAttribute("id", "democlass");
  if(i%2==0) {
    row.setAttribute("className", "table-dark");
  }
  else {
    row.setAttribute("className", "table-light");
  }
  let th = document.createElement("TH");
  th.setAttribute("scope", "row");
  th.innerText = "teste";
  let td0 = document.createElement("TD");
  td0.innerHTML = "teste";
  let td1 = document.createElement("TD");
  td0.innerHTML = "<input></input>";
  let td2 = document.createElement("TD");
  td2.innerHTML =`<IconButton aria-label="delete"> <DeleteIcon /> </IconButton>`;
  row.appendChild(th);
  row.appendChild(td0);
  row.appendChild(td1);
  row.appendChild(td2);
  table.appendChild(row); */

  i++;
}


function selectQuarto (dados3) {
  return ("<select className='form-select' name='quarto'> <option key='0' value='0'> {' '} </option> {dados3.map((dado) => (<option key={dado.id} value={dado.id}> {dado.numero} </option> ))} </select>")
}