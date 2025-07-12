import React, { useState } from 'react';
import LoginPage from './Pages/LoginPage';
import ItemsPage from './Pages/ItemPage';
import './App.css';


function App() {
  const [loggedIn, setLoggedIn] = useState(!!localStorage.getItem('token'));
  return (
    <div>
      {loggedIn ? <ItemsPage /> : <LoginPage onLogin={() => setLoggedIn(true)} />}
    </div>
  );
}

export default App;
