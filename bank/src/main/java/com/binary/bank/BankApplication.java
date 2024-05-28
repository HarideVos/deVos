package com.binary.bank;

import com.binary.bank.entities.BankAccount;
import com.binary.bank.repositories.BankRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class BankApplication implements CommandLineRunner {
	@Autowired
	private BankRepository bankRepo;

	public static void main(String[] args) {
		SpringApplication.run(BankApplication.class, args);
	}


    @Override
    public void run(String... args) throws Exception {
		BankAccount account1 = new BankAccount("Adam Jones", "savings", 0, "1q2w3", 1908, 520.25);
		BankAccount account2 = new BankAccount("John Adams", "checking", 0, "a1b2c3", 2356, 335.00);
		BankAccount account3 = new BankAccount("Darren Andrews", "checking", 0, "d12e3f", 3265, 785.20);
		BankAccount account4 = new BankAccount("Andrew Downing", "savings", 0, "z1x2c3", 2004, 625.25);
		bankRepo.saveAll(Arrays.asList(account1, account2, account3, account4)) ;
		System.out.println("All accounts updated");
    }


}
