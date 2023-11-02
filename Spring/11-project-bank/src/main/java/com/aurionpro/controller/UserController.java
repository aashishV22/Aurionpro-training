package com.aurionpro.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aurionpro.entity.Account;
import com.aurionpro.entity.User;
import com.aurionpro.service.AccountService;
import com.aurionpro.service.UserService;

@RestController
@RequestMapping("/app")
public class UserController 
{
	private UserService service;
	private AccountService accountService;
	public UserController(UserService service,AccountService accountService) 
	{
		super();
		this.service = service;
		this.accountService=accountService;
	}
	
	@GetMapping("/users")
	public ResponseEntity<List<User>> getAllUsers(){
		List<User> users=service.findAll();
		return  new ResponseEntity<>(users,HttpStatus.OK);
	}
	
	@GetMapping("/users/{user_id}")
	public ResponseEntity<Optional<User>> getUserById(@PathVariable int user_id){
		Optional<User> user = service.findById(user_id);
		return new ResponseEntity<>(user,HttpStatus.OK);
	}
	
	@GetMapping("/accounts")
	public ResponseEntity<List<Account>> getAccounts(){
		List<Account> accounts=accountService.findAll();
		return  new ResponseEntity<>(accounts,HttpStatus.OK);
	}
	
	
}
