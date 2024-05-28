package com.binary.bank.repositories;

import com.binary.bank.entities.BankAccount;
import org.springframework.data.repository.CrudRepository;

public interface BankRepository extends CrudRepository<BankAccount,Long> {
}
