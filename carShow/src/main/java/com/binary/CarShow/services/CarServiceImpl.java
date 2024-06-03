package com.binary.CarShow.services;

import com.binary.CarShow.dtos.CarDto;
import com.binary.CarShow.entities.Car;
import com.binary.CarShow.exceptions.CarNotFoundException;

import com.binary.CarShow.repositories.CarRepository;
import com.binary.CarShow.repositories.OwnerRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarServiceImpl implements CarService {
    @Autowired
    private CarRepository carRepository;
    @Autowired
    private OwnerRepository ownerRepository;

    @Override
    public Car createCar(@Valid CarDto carDto) {

        if (carDto == null) {
            return null;
        }
        if (carDto.getOwner() != null && carDto.getOwner().getOwnerId() == null) {
            ownerRepository.save(carDto.getOwner());
        }
        Car car = new Car();
        car.setBrand(carDto.getBrand());
        car.setModel(carDto.getModel());
        car.setColor(carDto.getColor());
        car.setYear(carDto.getYear());
        car.setPrice(carDto.getPrice());
        car.setOwner(carDto.getOwner());

        return carRepository.save(car);
    }


    @Override
    public List<Car> getAllCar() {
        List<Car> ListOfCar = (List<Car>) carRepository.findAll();
        if(ListOfCar.isEmpty()){
            throw new CarNotFoundException("Requested car does not exit in our system");
        }else{
            return ListOfCar;
        }
    }

    @Override
    public Car updateCar(long id, Car updatedCar) {
        Optional<Car> optionalCar = carRepository.findById((int) id);
        if (optionalCar.isPresent()) {
            if (updatedCar.getBrand() != null) {
                optionalCar.get().setBrand(updatedCar.getBrand());
            }
            if (updatedCar.getModel() != null) {
                optionalCar.get().setModel(updatedCar.getModel());
            }
            if (updatedCar.getColor() != null) {
                optionalCar.get().setColor(updatedCar.getColor());
            }
            if (updatedCar.getPrice() > 0) {
                optionalCar.get().setPrice(updatedCar.getPrice());
            }
            if (updatedCar.getYear() != null) {
                optionalCar.get().setYear(updatedCar.getYear());
            }
            if (updatedCar.getOwner() != null) {
                optionalCar.get().setOwner(updatedCar.getOwner());
            }
            carRepository.save(optionalCar.get());
            return optionalCar.get();
        }
        return null;
    }
    @Override
    public Long deleteCar(Long id) {
        Optional<Car> car = carRepository.findById(Math.toIntExact(id));
        if(car.isPresent()){
            carRepository.deleteById(Math.toIntExact(id));
            return id;
        }else{
            throw new CarNotFoundException("Requested car with " + id + " does not exit in our system");

        }
    }
    @Override
    public Car getCarById(Long id) throws CarNotFoundException {
        Optional<Car> car = carRepository.findById(Math.toIntExact(id));
        if(car.isEmpty()){
            throw new CarNotFoundException("Requested car with " + id + " does not exit in our system");
        }else {
            return car.get();
        }
    }
}