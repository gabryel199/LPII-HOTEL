import React from 'react';
import 'bootswatch/dist/lumen/bootstrap.css';

import Navbar from './components/navbar.js';


class App extends React.Component {
  render() {
    return (
      <div className='container'>
        
        <Navbar />
      </div>
    );
  }
}

export default App;
