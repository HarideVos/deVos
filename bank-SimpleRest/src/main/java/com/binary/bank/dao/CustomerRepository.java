package com.binary.bank.dao;

import com.binary.bank.model.Customer;
import org.springframework.data.repository.CrudRepository;


public interface CustomerRepository extends CrudRepository<Customer, Integer> {

}
