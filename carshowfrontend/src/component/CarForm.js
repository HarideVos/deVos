import React, { useState } from 'react';
import axios from 'axios';
import { useNavigate } from 'react-router-dom';

const CarForm = ({ token }) => {
    const [newCar, setNewCar] = useState({
        brand: "",
        model: "",
        color: "",
        registrationNumber: "",
        year: "",
        price: "",
        owner: null,
        make: null
    });
    const navigate = useNavigate();

    const createNewCar = async () => {
        try {
            const res = await axios.post("http://localhost:8080/api/v1/car/create", newCar, {
                headers: {
                    'Content-Type': 'application/json',
                    'Authorization': token ? `Bearer ${token}` : '',
                }
            });
            console.log(res);
            navigate("/cars/all");
        } catch (error) {
            console.error("Error creating new car:", error);
        }
    };

    const handleChange = (field, { target: { value } }) => {
        setNewCar({ ...newCar, [field]: value });
    };

    return (
        <div className="newCarContainer">
            <label>Brand</label><input value={newCar.brand} onChange={(e) => handleChange("brand", e)} />
            <label>Model</label><input value={newCar.model} onChange={(e) => handleChange("model", e)} />
            <label>Make</label><input value={newCar.make} onChange={(e) => handleChange("make", e)} />
            <label>Color</label><input value={newCar.color} onChange={(e) => handleChange("color", e)} />
            <label>Registration Number</label><input value={newCar.registrationNumber} onChange={(e) => handleChange("registrationNumber", e)} />
            <label>Year</label><input value={newCar.year} onChange={(e) => handleChange("year", e)} />
            <label>Price</label><input value={newCar.price} onChange={(e) => handleChange("price", e)} />
            <button type="submit" onClick={createNewCar}>Create new Car</button>
        </div>
    );
};

export default CarForm;
