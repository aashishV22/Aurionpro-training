package com.aurionpro.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aurionpro.entity.Customer;
import com.aurionpro.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService{
	@Autowired
	private CustomerRepository customerRepo;
	
	
	@Override
	public List<Customer> getAll() {
		return customerRepo.findAll();
	}


	@Override
	public Customer addCustomer(Customer customer) {
		return customerRepo.save(customer);
	}


	@Override
	public Customer findById(int customerId) {
		return customerRepo.findById(customerId).get();
	}

}
