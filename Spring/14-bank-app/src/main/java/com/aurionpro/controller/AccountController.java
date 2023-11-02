package com.aurionpro.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aurionpro.entity.Account;
import com.aurionpro.entity.AccountType;
import com.aurionpro.entity.Customer;
import com.aurionpro.repository.AccountRepository;
import com.aurionpro.repository.AccountTypeRepository;
import com.aurionpro.repository.CustomerRepository;
import com.aurionpro.service.AccountService;
import com.aurionpro.service.DocumentStorageService;

@RestController
@RequestMapping("/app")
public class AccountController {
	@Autowired
	private AccountRepository accountRepo;
	@Autowired
	private DocumentStorageService documentService;
	@Autowired
	private AccountTypeRepository accountTypeRepo; 
	@Autowired
	private CustomerRepository customerRepo;
	@Autowired
    private AccountService accountService;

	public void createAccount(int accountTypeId, double balance, int customerId) {
	    Account account = new Account();
	    account.setBalance(balance);
	    
	    // You need to retrieve the AccountType and Customer entities from their respective repositories
	    AccountType accountType = accountTypeRepo.findById(accountTypeId).orElse(null);
	    Customer customer = customerRepo.findById(customerId).orElse(null);

	    account.setTypeId(accountType);
	    account.setCustomerId(customer);
	    
	    accountRepo.save(account);
	}
}
