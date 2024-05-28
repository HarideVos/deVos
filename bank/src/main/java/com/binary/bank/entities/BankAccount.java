package com.binary.bank.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "bank_table")
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class BankAccount {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String holderName;
    private String accountType;
    private int withdrawalAmount ;
    private String accountNumber;
    private int pinCode;
    @Column(name = "bank_account_balance")
    private double bankAccountBalance;

    public BankAccount(String holderName, String accountType, int withdrawalAmount, String accountNumber, int pinCode, double bankAccountBalance) {
        this.holderName = holderName;
        this.accountType = accountType;
        this.withdrawalAmount = withdrawalAmount;
        this.accountNumber = accountNumber;
        this.pinCode = pinCode;
        this.bankAccountBalance = bankAccountBalance;
    }




}
