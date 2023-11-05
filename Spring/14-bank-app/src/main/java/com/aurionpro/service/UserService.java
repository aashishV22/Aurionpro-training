package com.aurionpro.service;

import java.util.List;
import java.util.Optional;

import com.aurionpro.entity.User;

public interface UserService 
{

	List<User> findAll();

	User findById(int user_id);

	User update(User user);

	void deleteUserById(int userId);

}
