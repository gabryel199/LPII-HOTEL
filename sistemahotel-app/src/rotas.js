import React from 'react';

import Login from './views/login';
import { Route, Routes, BrowserRouter } from 'react-router-dom';

import ListagemCliente from './views/listagem-cliente';
import ListagemFuncionario from './views/listagem-funcionario';
import ListagemHoteis from './views/listagem-hoteis';
import ListagemProdutos from './views/listagem-produtos';
import ListagemServicos from './views/listagem-servicos';
import ListagemComodidades from './views/listagem-comodidades';
import ListagemQuarto from './views/listagem-quarto';
import ListagemHospedagem from './views/listagem-hospedagem';
import ListagemReserva from './views/listagem-reserva';

import CadastroProduto from './views/cadastro-produto';
import CadastroHotel from './views/cadastro-hotel';
import CadastroCliente from './views/cadastro-cliente';
import CadastroFuncionario from './views/cadastro-funcionario';
import CadastroServicos from './views/cadastro-servicos';
import CadastroQuarto from './views/cadastro-quarto';
import CadastroComodidades from './views/cadastro-comodidades';
import CadastroReserva from './views/cadastro-reserva';
import CadastroHospedagem from './views/cadastro-hospedagem';
import CadastroHorarioServico from './views/cadastro-horarioServico';
import CadastroAvaliacaoQuarto from './views/cadastro-avaliacaoQuarto';
import CadastroAvaliacaoHospedagem from './views/cadastro-avaliacaoHospedagem';
{/**/}


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
        <Route path='/listagem-hospedagem' element={<ListagemHospedagem />} />    

        <Route path='/cadastro-produto/:idParam?' element={<CadastroProduto />} /> 
        <Route path='/cadastro-hotel/:idParam?' element={<CadastroHotel />} />   
        <Route path='/cadastro-cliente/:idParam?' element={<CadastroCliente />} />    
        <Route path='/cadastro-funcionario/:idParam?' element={<CadastroFuncionario />} />   
        <Route path='/cadastro-servicos/:idParam?' element={<CadastroServicos />} />      
        <Route path='/cadastro-quarto/:idParam?' element={<CadastroQuarto />} />      
        <Route path='/cadastro-comodidades/:idParam?' element={<CadastroComodidades />} />   
        <Route path='/cadastro-reserva/:idParam?' element={<CadastroReserva />} />         
        <Route path='/cadastro-hospedagem/:idParam?' element={<CadastroHospedagem />} />   
        <Route path='/cadastro-horarioServico/:idParam?' element={<CadastroHorarioServico />} />   
        <Route path='/cadastro-avaliacaoQuarto/:idParam?' element={<CadastroAvaliacaoQuarto />} />   
        <Route path='/cadastro-avaliacaoHospedagem/:idParam?' element={<CadastroAvaliacaoHospedagem />} />   
        {/**/}
        {/*          
        <Route path='/cadastro-tipo-produto' element={<CadastroTipoProduto />} />     
        <Route path='/cadastro-tipo-servicos' element={<CadastroTipoServico/>} />  
        <Route path='/cadastro-tipo-quarto' element={<CadastroTipoQuarto />} />     
        <Route path='/cadastro-tipo-cama' element={<CadastroTipoCama />} />   
        <Route path='/cadastro-tipo-comodidade' element={<CadastroTipoComodidade />} />   
        <Route path='/cadastro-cargo' element={<CadastroCargo />} />                   
        */}    
      </Routes>
    </BrowserRouter>
  );
}

export default Rotas;