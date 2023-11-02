package com.aurionpro.service;

import java.util.List;

import com.aurionpro.entity.Account;

public interface AccountService {

	List<Account> findAll();

	Account findByAccountNo(int accountNumber);

	Account save(Account account);

}
