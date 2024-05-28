package com.binary.bank.services;

import com.binary.bank.entities.BankAccount;
import com.binary.bank.repositories.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BankServiceImplementation implements BankService {
    @Autowired
    private BankRepository bankRepo;
    @Override
    public List<BankAccount> getAllAccounts() {
        return (List<BankAccount>) bankRepo.findAll();
    }

    @Override
    public void createAccount(BankAccount bankAccount) {

    }

    @Override
    public void updateAccount() {

    }

    @Override
    public void deleteAccount() {

    }
}
