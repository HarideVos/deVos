package com.binary.CarShow.services;

import com.binary.CarShow.dtos.CarDto;
import com.binary.CarShow.entities.Car;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Nested
@SpringBootTest
class CarServiceTest {

    @Autowired
    private CarService carService;

    @Test
    void testCreateCar() {
        CarDto carDto = new CarDto();
        carDto.setBrand("Toyota");
        carDto.setModel("Camry");
        carDto.setColor("Red");
        carDto.setPrice(25000.0);
        carDto.setYear(2020);
        Car createdCar = carService.createCar(carDto);
        assertNotNull(createdCar);
        assertEquals("Toyota", createdCar.getBrand());
        assertEquals("Camry", createdCar.getModel());
        assertEquals("Red", createdCar.getColor());
        assertEquals(25000.0, createdCar.getPrice());
        assertEquals(2020, createdCar.getYear());
    }

    @Test
    void testGetAllCar() {
        List<Car> cars = carService.getAllCar();
        assertNotNull(cars);
        assertFalse(cars.isEmpty());
    }

    @Test
    void testGetCarById() {
        Car car = carService.getCarById(1L);
        assertNotNull(car);
        assertEquals("Toyota", car.getBrand());
        assertEquals("Camry", car.getModel());
        assertEquals("Red", car.getColor());
        assertEquals(25000.0, car.getPrice());
        assertEquals(2020, car.getYear());
    }

    @Test
    void testUpdateCar() {
        Car updatedCar = new Car();
        updatedCar.setBrand("Honda");
        updatedCar.setModel("Accord");
        updatedCar.setColor("Blue");
        updatedCar.setPrice(28000.0);
        updatedCar.setYear(2022);

        Car updatedCar1 = carService.updateCar(1L, updatedCar);
        assertNotNull(updatedCar1);
        assertEquals("Honda", updatedCar1.getBrand());
        assertEquals("Accord", updatedCar1.getModel());
        assertEquals("Blue", updatedCar1.getColor());
        assertEquals(28000.0, updatedCar1.getPrice());
        assertEquals(2022, updatedCar1.getYear());
    }

    @Test
    void testDeleteCar() {
        Long deletedCarId = carService.deleteCar(1L);
        assertEquals(1L, deletedCarId);
    }
}
