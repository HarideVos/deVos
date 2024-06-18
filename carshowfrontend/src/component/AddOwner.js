import React, { useState } from 'react';
import axios from 'axios';
import './AddOwner.css';
import { useNavigate } from 'react-router-dom';

const AddOwner = ({ carId, toggleAddOwner }) => {
  const navigate = useNavigate();
  const [owner, setOwner] = useState({
    firstName: '',
    lastName: '',
  });

  const handleOnChange = (fieldName, value) => {
    setOwner({ ...owner, [fieldName]: value });
  };

  const addOwner = async (e) => {
    e.preventDefault();
    try {
      const token = localStorage.getItem('token');
      const response = await axios.post(
        'http://localhost:8080/api/v1/owner/create',
        { ...owner, carId }, 
        {
          headers: {
            Authorization: `Bearer ${token}`,
          },
        }
      );
      console.log('Owner added:', response.data);
      navigate('/cars/all');
      toggleAddOwner(); 
    } catch (error) {
      console.error('Error adding owner:', error);
    }
  };

  return (
    <div className="addOwner">
      <h2>Add Owner</h2>
      <form onSubmit={addOwner}>
        <div>
          <label>First Name:</label>
          <input
            type="text"
            value={owner.firstName}
            onChange={(e) => handleOnChange('firstName', e.target.value)}
          />
        </div>
        <div>
          <label>Last Name:</label>
          <input
            type="text"
            value={owner.lastName}
            onChange={(e) => handleOnChange('lastName', e.target.value)}
          />
        </div>
        <button type="submit">Add Owner</button>
      </form>
    </div>
  );
};

export default AddOwner;
