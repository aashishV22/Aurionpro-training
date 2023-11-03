package com.aurionpro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aurionpro.entity.Account;
import com.aurionpro.entity.AccountType;
import com.aurionpro.entity.Bank;
import com.aurionpro.entity.Customer;
import com.aurionpro.repository.AccountRepository;
import com.aurionpro.repository.AccountTypeRepository;
import com.aurionpro.repository.BankRepository;
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
	private BankRepository bankRepo;
	
	@Autowired
    private AccountService accountService;

	public void createAccount(int accountTypeId, double balance, int customerId,int bankId) {
	    Account account = new Account();
	    account.setBalance(balance);
	    
	    // You need to retrieve the AccountType and Customer entities from their respective repositories
	    AccountType accountType = accountTypeRepo.findById(accountTypeId).orElse(null);
	    Customer customer = customerRepo.findById(customerId).orElse(null);
	    Bank bank = bankRepo.findById(bankId).orElse(null);

	    account.setTypeId(accountType);
	    account.setCustomerId(customer);
	    account.setBankId(bank);
	    accountRepo.save(account);
	}
	
	@GetMapping("/accounts")
	public List<Account> getAllAccounts()
	{
		List<Account> accounts = accountService.getAllAccount();
		return accounts;
	}
	
	
	
}
