import React from 'react';

import Card from '../components/card';
import { mensagemSucesso, mensagemErro } from '../components/toastr';

import '../custom.css';

import { useNavigate } from 'react-router-dom';

import Stack from '@mui/material/Stack';
import { IconButton } from '@mui/material';
import DeleteIcon from '@mui/icons-material/Delete';
import EditIcon from '@mui/icons-material/Edit';

import axios from 'axios';

import { BASE_URL } from '../config/axios';

const baseURL = `${BASE_URL}/hotel`;


function ListagemHoteis() {
    const navigate = useNavigate();

    const cadastrar = () => {
        navigate(`/cadastro-hotel`);
      };
    
      const editar = (id) => {
        navigate(`/cadastro-hotel/${id}`);
      };
    
      const [dados, setDados] = React.useState(null);


}
export default ListagemHoteis;