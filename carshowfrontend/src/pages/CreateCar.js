import React from 'react';
import { useLocation } from 'react-router-dom'; 
import "./NewCar.css"
import CarForm from '../component/CarForm'; 

const CreateCar = () => {
    const location = useLocation();
    const searchParams = new URLSearchParams(location.search);
    const token = searchParams.get('token') || localStorage.getItem("token"); 

    return (
        <div className="newCarContainer">
            <h2>Create a New Car</h2>
            <CarForm token={token} />
        </div>
    );
};

export default CreateCar;
