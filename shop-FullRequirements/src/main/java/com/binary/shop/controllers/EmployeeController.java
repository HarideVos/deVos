package com.binary.shop.controllers;

import com.binary.shop.dtos.ShopDto;
import com.binary.shop.entities.Shop;
import com.binary.shop.services.ShopService;
import com.binary.shop.services.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/employee")
public class EmployeeController {
    @Autowired
    private ShopService shopService;
    @Autowired
    private EmployeeService ownerService;

    @GetMapping("/list")
    public ResponseEntity<List<Shop>> carMessage() {
        return new ResponseEntity<>(shopService.getAllItem(), HttpStatus.OK);
    }

    @PostMapping("/createItem")
    public ResponseEntity<Shop> createItem(@Valid @RequestBody ShopDto car) {
        Shop createdShop = shopService.createItem(car);
        return new ResponseEntity<>(createdShop, HttpStatus.CREATED);
    }

    @PutMapping("/updateItem/{id}")
    public ResponseEntity<Shop> updateShop(@PathVariable long id, @RequestBody Shop updatedShop) {

        return new ResponseEntity<>(shopService.updateShop(id, updatedShop), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Long> deleteItem(@PathVariable long id) {
        return new ResponseEntity<>(shopService.deleteItem(id), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Shop> getItemById(@PathVariable long id) {
        return new ResponseEntity<>(shopService.getItemById(id), HttpStatus.CREATED);

    }
}
