package com.binary.banking.service;

import com.binary.banking.exceptions.AccountNotFoundException;
import com.binary.banking.repository.AccountRepository;
import com.binary.banking.entities.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private AccountRepository accountRepository;

    public List<Account> getAllAccounts() {
        return accountRepository.findAll();
    }

    public Account getAccountById(Long id) {
        Optional<Account> byId = accountRepository.findById(id);
        if(byId.isEmpty()){
            throw new AccountNotFoundException("Requested Account with " + id + " does not exit in our system");
        }else {
            return byId.get();
        }

    }

    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    public Account updateAccount(Long id, Account accountDetails) {
        Optional<Account> account = accountRepository.findById(id);
        if(account.isEmpty()){
            throw new AccountNotFoundException("Requested Account with " + id + " does not exit in our system");
        }else {
            account.get().setName(accountDetails.getName());
            account.get().setAccountType(accountDetails.getAccountType());
            return accountRepository.save(account.get());
        }
    }

    public void deleteAccount(Long id) {
        Optional<Account> account = accountRepository.findById((id));
        if(account.isEmpty()){
            throw new AccountNotFoundException("Requested Account with " + id + " does not exit in our system");
        }else {
            accountRepository.delete(account.get());
        }
    }
}
