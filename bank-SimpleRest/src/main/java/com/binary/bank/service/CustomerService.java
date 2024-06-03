package com.binary.bank.service;

import com.binary.bank.dao.CustomerRepository;
import com.binary.bank.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



@Service
public class CustomerService {
	@Autowired
	private CustomerRepository customerRepository;

	public void createCustomer(Customer customer) {
		customerRepository.save(customer);
	}

	public Customer getCustomerInfo(int acctID) {
		return customerRepository.findById(acctID).orElse(null);
	}

	public void deleteCustomer(int acctID) {
		customerRepository.deleteById(acctID);
	}

}
