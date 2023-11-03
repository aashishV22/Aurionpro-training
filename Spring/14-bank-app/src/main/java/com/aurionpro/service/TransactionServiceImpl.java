package com.aurionpro.service;

import java.util.List;
import com.aurionpro.repository.TransactionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aurionpro.entity.Transaction;

@Service
public class TransactionServiceImpl implements TransactionService {
	 
	@Autowired
	private TransactionRepository transactionRepository;
      
	
	@Override
	public List<Transaction> getAllTransactions() {
		return transactionRepository.findAll();
	}


	@Override
	public Transaction addTransaction(Transaction transaction) {
		return transactionRepository.save(transaction);
	}
	
	

}