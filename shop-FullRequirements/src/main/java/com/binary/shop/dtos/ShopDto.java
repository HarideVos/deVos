package com.binary.shop.dtos;

import com.binary.shop.entities.Employee;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShopDto {
    @NotNull(message = "Item should not be empty")
    private String item;
    @NotNull(message = "Brand should not be empty")
    private String brand;
    @NotNull(message = "Make should not be empty")
    private String make;
    @NotNull(message = "Model should not be empty")
    private String model;
    @Min(value = 0, message = "Discount should not be null")
    private Integer percentOff;
    @Min(0)
    private double price;
    @NotNull(message = "Type should not be empty")
    private String type;
    @NotNull(message = "Employee should not be empty")
    private Employee employee;




    public @NotNull(message = "Item should not be empty") String getItem() {
        return item;
    }

    public void setItem(@NotNull(message = "Item should not be empty") String item) {
        this.item = item;
    }

    public @NotNull(message = "Brand should not be empty") String getBrand() {
        return brand;
    }

    public void setBrand(@NotNull(message = "Brand should not be empty") String brand) {
        this.brand = brand;
    }

    public @NotNull(message = "Make should not be empty") String getMake() {
        return make;
    }

    public void setMake(@NotNull(message = "Make should not be empty") String make) {
        this.make = make;
    }

    public @NotNull(message = "Model should not be empty") String getModel() {
        return model;
    }

    public void setModel(@NotNull(message = "Model should not be empty") String model) {
        this.model = model;
    }

    public @Min(value = 0, message = "Discount should not be null") Integer getPercentOff() {
        return percentOff;
    }

    public void setPercentOff(@Min(value = 0, message = "Discount should not be null") Integer percentOff) {
        this.percentOff = percentOff;
    }

    @Min(0)
    public double getPrice() {
        return price;
    }

    public void setPrice(@Min(0) double price) {
        this.price = price;
    }

    public @NotNull(message = "Type should not be empty") String getType() {
        return type;
    }

    public void setType(@NotNull(message = "Type should not be empty") String type) {
        this.type = type;
    }

    public @NotNull(message = "Employee should not be empty") Employee getEmployee() {
        return employee;
    }

    public void setEmployee(@NotNull(message = "Employee should not be empty") Employee employee) {
        this.employee = employee;
    }
}
