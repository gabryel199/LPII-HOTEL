import React from 'react';

import ListagemCliente from './views/listagem-cliente';
import ListagemFuncionario from './views/listagem-funcionario';
import ListagemHoteis from './views/listagem-hoteis';
import ListagemProdutos from './views/listagem-produtos';
import ListagemServicos from './views/listagem-servicos';
import ListagemComodidades from './views/listagem-comodidades';
import ListagemQuarto from './views/listagem-quarto';
import ListagemHospedagem from './views/listagem-hospedagen';
import ListagemReserva from './views/listagem-reserva';
import CadastroProduto from './views/cadastro-produto';

import Login from './views/login';


import { Route, Routes, BrowserRouter } from 'react-router-dom';

function Rotas(props) {
  return (
    <BrowserRouter>
      <Routes>
        <Route path='/login' element={<Login />} />
        <Route path='/listagem-cliente' element={<ListagemCliente />} />
        <Route path='/listagem-funcionario' element={<ListagemFuncionario />} />
        <Route path='/listagem-hoteis' element={<ListagemHoteis />} />   
        <Route path='/listagem-produtos' element={<ListagemProdutos />} />
        <Route path='/listagem-servicos' element={<ListagemServicos />} />
        <Route path='/listagem-comodidades' element={<ListagemComodidades />} />
        <Route path='/listagem-quarto' element={<ListagemQuarto />} />      
        <Route path='/listagem-reserva' element={<ListagemReserva />} />
        <Route path='/listagem-hospedagen' element={<ListagemHospedagem />} />    
        <Route path='/cadastro-produto' element={<CadastroProduto />} />     
      </Routes>
    </BrowserRouter>
  );
}

export default Rotas;