import React, { useState } from 'react';
import axios from 'axios';
import './Login.css';
import { useNavigate } from 'react-router-dom';

const LoginComponent = () => {
  const navigate = useNavigate();
  const [error, setError] = useState('');
  const [login, setLogin] = useState({
    email: '',
    password: '',
  });

  const handleOnChange = (fieldName, value) => {
    setLogin({ ...login, [fieldName]: value });
  };

  const loginEvent = async (e) => {
    e.preventDefault();
    const { email, password } = login;
    try {
      const response = await axios.post('http://localhost:8080/api/v1/member/login', {
        email,
        password,
      });

      const token = response.data.token;
      console.log('Received token:', token);

      localStorage.setItem("token", token);

      navigate("/cars/all");
    } catch (error) {
      setError("Invalid email or password.");
    }
  };

  return (
    <div className="loginContainer">
      <h2>User Login</h2>
      <form onSubmit={loginEvent}>
        <div>
          <label>Email:</label>
          <input
            type="email"
            value={login.email}
            onChange={(e) => handleOnChange('email', e.target.value)}
          />
        </div>
        <div>
          <label>Password:</label>
          <input
            type="password"
            value={login.password}
            onChange={(e) => handleOnChange('password', e.target.value)}
          />
        </div>
        <button type="submit">Login</button>
      </form>
      {error && <p>{error}</p>}
    </div>
  );
};

export default LoginComponent;
