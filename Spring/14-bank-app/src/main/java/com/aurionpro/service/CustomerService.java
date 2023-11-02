package com.aurionpro.service;

import java.util.List;

import com.aurionpro.entity.Customer;

public interface CustomerService {

	List<Customer> getAll();

	Customer addCustomer(Customer customer);

}
