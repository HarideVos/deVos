package com.binary.CarShow.services;

import com.binary.CarShow.dtos.CarDto;
import com.binary.CarShow.entities.Car;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface CarService {

    public Car createCar(@Valid CarDto car);
    public List<Car>  getAllCar();
    public Car updateCar(long id, Car car);
    public Long deleteCar(Long id);
    public Car getCarById(Long id);
}