package com.aurionpro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aurionpro.entity.Account;
import com.aurionpro.entity.Admin;
import com.aurionpro.service.AccountService;
import com.aurionpro.service.AdminService;

@RestController
@RequestMapping("/app")
public class AccountController 
{
	@Autowired
	private AccountService accountService;
	
	@GetMapping("/accounts")
	public ResponseEntity<List<Account>> getAllUsers(){
		List<Account> admins=accountService.findAll();
		return  new ResponseEntity<>(admins,HttpStatus.OK);
	}

	@PutMapping("/accounts/{accountNumber}/{transactionType}/{amount}")
	public Account doTransaction(@PathVariable int accountNumber,@PathVariable String transactionType,@PathVariable double amount) 
	{
		Account account=accountService.findByAccountNo(accountNumber);
		if(transactionType.equals("deposit")) {
			double total=account.getBalance()+amount;
			account.setBalance(total);
		}else {
			double total=account.getBalance()-amount;
			account.setBalance(total);
		}
		System.out.println(account);
		Account updatedAccount=accountService.save(account);
		return updatedAccount;
	}
	
	
	
	
	
}
