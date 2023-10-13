import React from 'react';
import 'bootswatch/dist/lumen/bootstrap.css';

import NavbarItem from './navbarItem';

function Navbar(props) {
  return (
    <div className='navbar navbar-expand-lg fixed-top navbar-dark bg-primary'>
      <div className='container'>
        <a href='/' className='navbar-brand'>
          REDE DE HOTEIS X
        </a>
        <button
          className='navbar-toggler'
          type='button'
          data-toggle='collapse'
          data-target='#navbarResponsive'
          aria-controls='navbarResponsive'
          aria-expanded='false'
          aria-label='Toggle navigation'
        >
          <span className='navbar-toggler-icon'></span>
        </button>
        <div className='collapse navbar-collapse' id='navbarResponsive'>
          <ul className='navbar-nav'>
            <NavbarItem render='true' href='/login' label='Entrar' />
          </ul>
          <ul className='navbar-nav'>
            <NavbarItem render='true' href='/listagem-hoteis' label='Hotéis' />
          </ul>
          <ul className='navbar-nav'>
            <NavbarItem render='true' href='/listagem-cliente' label='Clientes' />
          </ul>
          <ul className='navbar-nav'>
            <NavbarItem render='true' href='/listagem-funcionario' label='Funcionarios' />
          </ul>
          <ul className='navbar-nav'>
            <NavbarItem render='true' href='/listagem-quartos' label='Quartos' />
          </ul>
          <ul className='navbar-nav'>
            <NavbarItem render='true' href='/listagem-produtos' label='Produtos' />
          </ul>
          <ul className='navbar-nav'>
            <NavbarItem render='true' href='/listagem-servicos' label='Serviços' />
          </ul>
          <ul className='navbar-nav'>
            <NavbarItem render='true' href='/listagem-categoriaProduto' label='Categoria de Produtos' />
          </ul>
        </div>
      </div>
    </div>
  );
}

export default Navbar;