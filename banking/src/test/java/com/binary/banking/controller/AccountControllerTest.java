package com.binary.banking.controller;

import com.binary.banking.entities.Account;
import com.binary.banking.service.AccountService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class AccountControllerTest {
    @Mock
    private AccountService accountService;
    @InjectMocks
    private AccountController accountController;


    @Test
    void test_getAllAccounts_success() {
        List<Account> accountList = new ArrayList<>();
        Account myAccount = new Account();
        myAccount.setName("Account1");
        myAccount.setAccountType("This is the first project");
        accountList.add(myAccount);

        Mockito.when(accountService.getAllAccounts()).thenReturn(accountList);
        ResponseEntity<List<Account>> allAccounts = accountController.getAllAccounts();
        Assertions.assertEquals(accountList.get(0).getAccountType(), allAccounts.getBody().get(0).getAccountType());
        Assertions.assertNotNull(allAccounts);
    }

    @Test
    void test_getAccountById_success() {

    }

    @Test
    void test_createAccount_success() {
    }

    @Test
    void test_updateAccount_success() {
    }

    @Test
    void test_deleteAccount_success() {
    }
}