package com.binary.CarShow.controllers;

import com.binary.CarShow.dtos.CarDto;
import com.binary.CarShow.entities.Car;
import com.binary.CarShow.services.CarServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;
@ExtendWith(MockitoExtension.class)
public class CarControllerTest {
    @InjectMocks
    private CarController carController;
    @Mock
    private CarServiceImpl carService;

    @BeforeEach
    public void setUp() {
    }

    @Test
    @DisplayName("Car controller get all cars success")
    public void testCarController_getAllCars_success() {
        List<Car> carList = new ArrayList<>();
        Car car1 = new Car();
        car1.setId(1);
        car1.setPrice(4000);
        car1.setModel("Rav4");
        carList.add(car1);
        when(carService.getAllCar()).thenReturn(carList);
        ResponseEntity<List<Car>> result = carController.carMessage();
        assertEquals(1, result.getBody().size());
        assertEquals(HttpStatus.OK, result.getStatusCode());
    }

    @Test
    @DisplayName("Car Controller for creating car")
    public void testCarController_getCarById_success() {
        Car car1 = new Car();
        car1.setId(2);
        Integer expectedId = 2;
        Mockito.when(carService.getCarById(Long.valueOf(expectedId))).thenReturn(car1);

        ResponseEntity<Car> result = carController.getCarById(expectedId);

        Assertions.assertEquals(expectedId, result.getBody().getId());
        assertEquals(HttpStatus.CREATED, result.getStatusCode());
    }

    @Test
    @DisplayName("Create Update card")
    public void testSetCarController_createCar_success() {
        CarDto carBeforeCreated = new CarDto();
        carBeforeCreated.setModel("xyz");

        Car createdCar = new Car();
        createdCar.setId(1);
        createdCar.setModel(carBeforeCreated.getModel());

        Mockito.when(carService.createCar(Mockito.any())).thenReturn(createdCar);
        ResponseEntity<Car> result = carController.createCar(carBeforeCreated);
        Assertions.assertEquals(carBeforeCreated.getModel(), result.getBody().getModel());
        Assertions.assertNotNull(result.getBody().getId());
        Assertions.assertEquals(HttpStatus.CREATED, result.getStatusCode());
    }

    @Test
    @DisplayName("Create Update card")
    public void testSetCarController_updateCar_success() {
        Car carBeforeUpdate = new Car();
        carBeforeUpdate.setId(45);
        carBeforeUpdate.setYear(2020);
        carBeforeUpdate.setColor("green");


        Integer carIdThatNeedToBeUpdate = 45;
        Car updatedCar = new Car();
        updatedCar.setId(carIdThatNeedToBeUpdate);
        updatedCar.setYear(carBeforeUpdate.getYear());
        updatedCar.setColor("Red");

        Mockito.when(carService.updateCar(carIdThatNeedToBeUpdate, updatedCar)).thenReturn(updatedCar);
        ResponseEntity<Car> result = carController.updateCar(carIdThatNeedToBeUpdate, updatedCar);
        Assertions.assertEquals(updatedCar.getColor(), result.getBody().getColor());
        Assertions.assertNotNull(result.getBody().getId());
        Assertions.assertEquals(HttpStatus.CREATED, result.getStatusCode());
    }


    @Test
    @DisplayName("Delete method")
    public void testDeleteTest_success(){
        long carIdThatNeedToBeDeleted = 45;

        Mockito.when(carService.deleteCar(carIdThatNeedToBeDeleted)).thenReturn(carIdThatNeedToBeDeleted);

        ResponseEntity<Long> result = carController.deleteCar(carIdThatNeedToBeDeleted);
        Assertions.assertEquals(carIdThatNeedToBeDeleted, result.getBody());
        Assertions.assertEquals(HttpStatus.CREATED, result.getStatusCode());
    }

}
