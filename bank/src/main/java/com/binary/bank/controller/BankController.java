package com.binary.bank.controller;

import com.binary.bank.services.BankService;
import com.binary.bank.entities.BankAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/bank")
public class BankController {
    @Autowired
    BankService bankService;

    @GetMapping("/")
    public String helloMessage() {
        return "Bank Account";
    }

    @GetMapping("/list")
    public ResponseEntity<List<BankAccount>> getCars() {
        return new ResponseEntity<>(bankService.getAllAccounts(), HttpStatus.OK);
    }
}