package com.aurionpro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aurionpro.entity.Transaction;
import com.aurionpro.service.TransactionService;

@RestController
@RequestMapping("/app")
public class TransactionController {

	@Autowired
	private TransactionService transactionService;
	
	@GetMapping("/transactions")
	public ResponseEntity<List<Transaction>> getAllTransaction(){
		List<Transaction>transactions = transactionService.getAllTransactions();
		return new ResponseEntity<>(transactions,HttpStatus.OK);
	}
	
	@PostMapping("/transactions")
	public ResponseEntity<Transaction>addTrnsaction(@RequestBody Transaction transaction){
		Transaction newTransaction = transactionService.addTransaction(transaction);
		return new ResponseEntity<>(newTransaction,HttpStatus.CREATED);
	}
}