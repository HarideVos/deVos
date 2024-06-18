import React, { useEffect, useState } from 'react';
import { Link, Route, Routes } from 'react-router-dom';
import Home from './pages/Home';
import CarsList from './pages/CarsList';
import LoginComponent from './component/LoginComponent';
import RegisterComponent from './component/RegisterComponent';
import "./App.css"
import CreateCar from './pages/CreateCar';

function App() {
  const [loginstate, setLoginState ] = useState(false);
  
  useEffect(()=>{
    let token = localStorage.getItem("token");
    if(token.length > 0){
      setLoginState(true)
    }else{
      setLoginState(false)
    }
  },[])
  return (
    <div className="App">
      
        <div className='navBarDiv'>
        <nav>
          <ul className='navList'>
            <li className='navListItem'><Link to='/'>Home</Link></li>
            <li className='navListItem'><Link to='/cars/all'>Cars List</Link></li>
            <li className='navListItem'><Link to='/cars/create'>Create New Car</Link></li>
            { loginstate  ? <li className="navListItem"><Link to="/cars/login" onClick={()=>{
            localStorage.setItem("token", "");
            setLoginState(false);
          }} >Log Out</Link> </li> :<li className="navListItem"><Link to="/cars/login" >Log In</Link> </li> }
            <li className='navListItem'><Link to='/cars/register'>Register</Link></li>

          </ul>
        </nav>
        </div>

      <Routes>
        <Route path="/" element={<Home/>}/>
        <Route path="/cars">
        <Route path="all" element={<CarsList/>}/>
        <Route path="create" element={<CreateCar />} />
        <Route path="login" element={<LoginComponent/>}/>
        <Route path="register" element={<RegisterComponent/>}/>
        </Route>
      </Routes>
    </div>
    
  );
  
}

export default App;
