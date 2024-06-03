package com.binary.CarShow.controllers;

import com.binary.CarShow.dtos.CarDto;
import com.binary.CarShow.entities.Car;
import com.binary.CarShow.services.CarService;
import com.binary.CarShow.services.OwnerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/owner")
public class OwnerController {
    @Autowired
    private CarService carService;
    @Autowired
    private OwnerService ownerService;

    @GetMapping("/list")
    public ResponseEntity<List<Car>> carMessage() {
        return new ResponseEntity<>(carService.getAllCar(), HttpStatus.OK);
    }

    @PostMapping("/createCar")
    public ResponseEntity<Car> createCar(@Valid @RequestBody CarDto car) {
        Car createdCar = carService.createCar(car);
        return new ResponseEntity<>(createdCar, HttpStatus.CREATED);
    }

    @PutMapping("/updateCar/{id}")
    public ResponseEntity<Car> updateCar(@PathVariable long id, @RequestBody Car updatedCar) {

        return new ResponseEntity<>(carService.updateCar(id, updatedCar), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Long> deleteCar(@PathVariable long id) {
        return new ResponseEntity<>(carService.deleteCar(id), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Car> getCarById(@PathVariable long id) {
        return new ResponseEntity<>(carService.getCarById(id), HttpStatus.CREATED);

    }
}
