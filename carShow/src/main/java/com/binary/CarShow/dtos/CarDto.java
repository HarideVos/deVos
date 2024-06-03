package com.binary.CarShow.dtos;

import com.binary.CarShow.entities.Owner;
import jakarta.persistence.*;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CarDto {
    @NotNull(message = "Brand should not be null")
    private String brand;
    @NotNull(message = "Model should not be null")
    private String model;
    @NotNull(message = "Color should not be null")
    private String color;
    @NotNull(message = "Register Number should not be null")
    private String registerNumber;
    @Min(value = 1990, message = "Year should not be null")
    private Integer year;
    @Min(0)
    private double price;
    @NotNull(message = "Make should not be null")
    private String make;
    @NotNull(message = "Owner should not be null")
    private Owner owner;

    public @NotNull(message = "Owner should not be null") Owner getOwner() {
        return owner;
    }

    public void setOwner(@NotNull(message = "Owner should not be null") Owner owner) {
        this.owner = owner;
    }

    public @NotNull(message = "Make should not be null") String getMake() {
        return make;
    }

    public void setMake(@NotNull(message = "Make should not be null") String make) {
        this.make = make;
    }

    @Min(0)
    public double getPrice() {
        return price;
    }

    public void setPrice(@Min(0) double price) {
        this.price = price;
    }

    public @Min(value = 1990, message = "Year should not be null") Integer getYear() {
        return year;
    }

    public void setYear(@Min(value = 1990, message = "Year should not be null") Integer year) {
        this.year = year;
    }

    public @NotNull(message = "Register Number should not be null") String getRegisterNumber() {
        return registerNumber;
    }

    public void setRegisterNumber(@NotNull(message = "Register Number should not be null") String registerNumber) {
        this.registerNumber = registerNumber;
    }

    public @NotNull(message = "Color should not be null") String getColor() {
        return color;
    }

    public void setColor(@NotNull(message = "Color should not be null") String color) {
        this.color = color;
    }

    public @NotNull(message = "Model should not be null") String getModel() {
        return model;
    }

    public void setModel(@NotNull(message = "Model should not be null") String model) {
        this.model = model;
    }

    public @NotNull(message = "Brand should not be null") String getBrand() {
        return brand;
    }

    public void setBrand(@NotNull(message = "Brand should not be null") String brand) {
        this.brand = brand;
    }
}
