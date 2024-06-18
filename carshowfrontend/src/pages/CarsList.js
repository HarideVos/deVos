import { useEffect, useState } from "react";
import CarListItem from "../component/CarListItem";
import "./CarsList.css";
import axios from "axios";

const CarList = () => {
  const [cars, setCars] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  const getCarsData = async () => {
    try {
      const res = await axios.get("http://localhost:8080/api/v1/car/list");
      setCars(res.data);
      setLoading(false);
    } catch (error) {
      setError(error);
      setLoading(false);
    }
  };

  useEffect(() => {
    getCarsData();
  }, []);

  if (loading) {
    return <div className="carListContainer">Loading...</div>;
  }

  if (error) {
    return <div>Error: {error.message}</div>;
  }

  return (
    <div className="carListContainer">
      {cars.length > 0
        ? cars.map((car) => <CarListItem key={car.id} car={car} />)
        : "No cars to show"}
    </div>
  );
};

export default CarList;