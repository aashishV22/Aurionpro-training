package com.aurionpro.service;

import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;

import com.aurionpro.entity.Customer;
import com.aurionpro.entity.User;

public interface CustomerService {

	List<Customer> getAll();

	Customer addCustomer(Customer customer);

	Customer findById(int customerId);

	Customer findByUserId(User user);

}
