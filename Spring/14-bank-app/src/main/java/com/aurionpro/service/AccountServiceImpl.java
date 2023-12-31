package com.aurionpro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aurionpro.entity.Account;
import com.aurionpro.entity.AccountType;
import com.aurionpro.entity.Customer;
import com.aurionpro.entity.Document;
import com.aurionpro.repository.AccountRepository;
import com.aurionpro.repository.AccountTypeRepository;
import com.aurionpro.repository.CustomerRepository;

@Service
public class AccountServiceImpl implements AccountService{
	@Autowired
	private AccountRepository accountRepo;
	
	@Override
	public List<Account> getAllAccount() {
		return accountRepo.findAll();
	}
	
	

	
}
