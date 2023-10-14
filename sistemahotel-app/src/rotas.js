import React from 'react';

import ListagemCliente from './views/listagem-cliente';
import ListagemFuncionario from './views/listagem-funcionario';
import ListagemHoteis from './views/listagem-hoteis';
import ListagemTipoQuartos from './views/listagem-tipoQuartos';
import ListagemProdutos from './views/listagem-produtos';
import ListagemServicos from './views/listagem-servicos';
import ListagemCategoriaProduto from './views/listagem-categoriaProduto';
import ListagemTipoServico from './views/listagem-tipoServico';
import ListagemComodidades from './views/listagem-comodidades';
import ListagemCargo from './views/listagem-cargo';
import ListagemTipoCama from './views/listagem-tipoCama';

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
        <Route path='/listagem-tipoQuartos' element={<ListagemTipoQuartos />} />
        <Route path='/listagem-produtos' element={<ListagemProdutos />} />
        <Route path='/listagem-servicos' element={<ListagemServicos />} />
        <Route path='/listagem-categoriaProduto' element={<ListagemCategoriaProduto />} />
        <Route path='/listagem-tipoServico' element={<ListagemTipoServico />} />
        <Route path='/listagem-comodidades' element={<ListagemComodidades />} />
        <Route path='/listagem-cargo' element={<ListagemCargo />} />
        <Route path='/listagem-tipoCama' element={<ListagemTipoCama />} />
      </Routes>
    </BrowserRouter>
  );
}

export default Rotas;