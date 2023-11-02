import React, { useState } from 'react';
import 'bootswatch/dist/lumen/bootstrap.css';

import NavbarItem from './navbarItem';

function Navbar(props) {
  const [dropdown1Open, setDropdown1Open] = useState(false);
  const [dropdown2Open, setDropdown2Open] = useState(false);

  const toggleDropdown1 = () => {
    setDropdown1Open(!dropdown1Open);
  };

  const toggleDropdown2 = () => {
    setDropdown2Open(!dropdown2Open);
  };

  const handleMouseEnter1 = () => {
    setDropdown1Open(true);
  };

  const handleMouseLeave1 = () => {
    setDropdown1Open(false);
  };

  const handleMouseEnter2 = () => {
    setDropdown2Open(true);
  };

  const handleMouseLeave2 = () => {
    setDropdown2Open(false);
  };

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
          <ul className="nav-item-dropdown" onMouseEnter={handleMouseEnter1} onMouseLeave={handleMouseLeave1}>
            <a className={`nav-link dropdown-toggle ${dropdown1Open ? 'show' : ''}`} onClick={toggleDropdown1}> Produtos
            </a>
            <div className={`dropdown-menu ${dropdown1Open ? 'show' : ''}`}>
                <a className="dropdown-item" href='/listagem-produtos'>Listagem de Produtos</a>
                <a className="dropdown-item" href='#'>Tipo de Produtos</a>                
              </div>
          </ul>
          <ul className="nav-item-dropdown" onMouseEnter={handleMouseEnter2} onMouseLeave={handleMouseLeave2}>
            <a className={`nav-link dropdown-toggle ${dropdown2Open ? 'show' : ''}`} onClick={toggleDropdown2}> Serviços
            </a>
            <div className={`dropdown-menu ${dropdown2Open ? 'show' : ''}`}>
                <a className="dropdown-item" href='/listagem-produtos'>Listagem de Serviços</a>
                <a className="dropdown-item" href='#'>Tipo de Serviços</a>                
              </div>
          </ul>
          <ul className='navbar-nav'>
            <NavbarItem render='true' href='/listagem-comodidades' label='Comodidades' />
          </ul>
          <ul className='navbar-nav'>
            <NavbarItem render='true' href='/listagem-quarto' label='Quartos' />
          </ul>
          <ul className='navbar-nav'>
            <NavbarItem render='true' href='/listagem-reserva' label='Reservas' />
          </ul>
          <ul className='navbar-nav'>
            <NavbarItem render='true' href='/listagem-hospedagem' label='Hospedagens' />
          </ul>
        </div>
      </div>
    </div>
  );
}

export default Navbar;