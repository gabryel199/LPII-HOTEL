import React from 'react';

import ListagemCliente from './views/listagem-cliente';
import ListagemFuncionario from './views/listagem-funcionario';
import ListagemHoteis from './views/listagem-hoteis';
import ListagemQuartos from './views/listagem-quartos';

import Login from './views/login';
//import CadastroUsuario from './views/cadastro-usuario';
//import CadastroCurso from './views/cadastro-curso';
//import CadastroProfessor from './views/cadastro-professor';
//import CadastroAluno from './views/cadastro-aluno';

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
      </Routes>
    </BrowserRouter>
  );
}

export default Rotas;