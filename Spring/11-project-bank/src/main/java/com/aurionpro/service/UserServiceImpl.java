package com.aurionpro.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.aurionpro.entity.User;
import com.aurionpro.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService
{
	private UserRepository userRepo;
	public UserServiceImpl(UserRepository userRepo) {
		super();
		this.userRepo = userRepo;
	}



	@Override
	public List<User> findAll() {
		return userRepo.findAll();
	}



	@Override
	public Optional<User> findById(int user_id) {
		return userRepo.findById(user_id);
	}

}
