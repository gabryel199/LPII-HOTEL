import React from 'react';

import ListagemCliente from './views/listagem-cliente';
import ListagemFuncionario from './views/listagem-funcionario';
import ListagemHoteis from './views/listagem-hoteis';
import ListagemQuartos from './views/listagem-quartos';
import ListagemProdutos from './views/listagem-produtos';
import ListagemServicos from './views/listagem-servicos';

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
        <Route path='/listagem-quartos' element={<ListagemQuartos />} />
        <Route path='/listagem-produtos' element={<ListagemProdutos />} />
        <Route path='/listagem-servicos' element={<ListagemServicos />} />
      </Routes>
    </BrowserRouter>
  );
}

export default Rotas;