import React, { useState } from 'react';
import AddOwner from './AddOwner';

const CarListItem = ({ car }) => {
  const [showAddOwner, setShowAddOwner] = useState(false);

  const toggleAddOwner = () => {
    setShowAddOwner(!showAddOwner);
  };

  return (
    <div style={{ width: '100vw', border: '1px solid black', backgroundColor: 'white', padding: '10px', color: 'black' }}>
      <ul style={{ display: 'flex', flexDirection: 'row', justifyContent: 'space-around', listStyle: 'none' }}>
        <li>{car.id}</li>
        <li>{car.brand?.toUpperCase()}</li>
        <li>{car.model?.toUpperCase()}</li>
        <li>{car.color?.toUpperCase()}</li>
        <li>{car.year}</li>
        <li>{car.registerNumber}</li>
        <li>{car.owner}</li>
        <li>{car.price + '$'}</li>
      </ul>
      <button onClick={toggleAddOwner}>Add Owner</button>
      {showAddOwner && <AddOwner carId={car.id} toggleAddOwner={toggleAddOwner} />}
    </div>
  );
};

export default CarListItem;
