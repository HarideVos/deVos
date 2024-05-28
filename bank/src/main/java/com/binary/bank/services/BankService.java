package com.binary.bank.services;

import com.binary.bank.entities.BankAccount;

import java.util.List;

public interface BankService {

    public List<BankAccount> getAllAccounts();
    public void createAccount (BankAccount bankAccount);
    public void updateAccount();
    public void deleteAccount();

}
