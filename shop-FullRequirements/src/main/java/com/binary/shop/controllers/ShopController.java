package com.binary.shop.controllers;

import com.binary.shop.dtos.ShopDto;
import com.binary.shop.entities.Shop;
import com.binary.shop.exceptions.ItemNotFoundException;
import com.binary.shop.services.ShopService;
import com.binary.shop.services.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@Profile({"dev"})
@RequestMapping("/api/v1/shop")
public class ShopController {
    @Autowired
    private ShopService shopService;
    @Autowired
    private EmployeeService ownerService;

    @GetMapping("/list")
    public ResponseEntity<List<Shop>> shopMessage() {
        return new ResponseEntity<>(shopService.getAllItem(), HttpStatus.OK);
    }

    @PostMapping("/createItem")
    public ResponseEntity<Shop> createItem( @Valid @RequestBody ShopDto shop) {
        Shop createdItem = shopService.createItem(shop);
        return new ResponseEntity<>(createdItem, HttpStatus.CREATED);
    }

    @PutMapping("/updateShop/{id}")
    public ResponseEntity<Shop> updateShop(@PathVariable long id, @RequestBody Shop updatedShop) {

        return new ResponseEntity<>(shopService.updateShop(id, updatedShop), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Long> deleteItem(@PathVariable long id) {
        return new ResponseEntity<>(shopService.deleteItem(id), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Shop> getItemById(@PathVariable long id) throws ItemNotFoundException {
        return new ResponseEntity<>(shopService.getItemById(id), HttpStatus.CREATED);
    }



}
