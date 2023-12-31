import React from 'react';
import 'bootswatch/dist/lumen/bootstrap.css';

import NavbarItem from './navbarItem';

function Navbar(props) {
  return (
    <div className='navbar navbar-expand-lg fixed-top navbar-dark bg-primary'>
      <div className='container'>
        <a href='/' className='navbar-brand'>
          REDE DE HOTÉIS X
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
            <NavbarItem render='true' href='/listagem-cursos' label='Hotéis' />
          </ul>
          <ul className='navbar-nav'>
            <NavbarItem render='true' href='/listagem-cursos' label='Reserva' />
          </ul>
          <ul className='navbar-nav'>
            <NavbarItem render='true' href='/login' label='Registro' />
          </ul>
          <ul className='navbar-nav'>
            <NavbarItem render='true' href='/' label='Login' />
          </ul>
          <ul className='navbar-nav'>
            <NavbarItem render='true' href='/' label='Sair' />
          </ul>

        </div>
      </div>
    </div>
  );
}

export default Navbar;
