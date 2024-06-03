package com.binary.banking.service;

import com.binary.banking.entities.Account;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface AccountService {
    public List<Account> getAllAccounts();
    public Account getAccountById(Long id);
    public Account createAccount(Account account);
    public Account updateAccount(Long id, Account accountDetails);
    public void deleteAccount(Long id);

}
