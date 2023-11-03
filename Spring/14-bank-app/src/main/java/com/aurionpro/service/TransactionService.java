package com.aurionpro.service;

import java.util.List;

import com.aurionpro.entity.Transaction;


public interface TransactionService {

	List<Transaction> getAllTransactions();

	Transaction addTransaction(Transaction transaction);

}
