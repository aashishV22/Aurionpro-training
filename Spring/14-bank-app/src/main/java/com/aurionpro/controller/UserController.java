package com.aurionpro.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aurionpro.entity.User;
import com.aurionpro.service.UserService;

@RestController
@RequestMapping("/app")
@CrossOrigin(origins="http://localhost:4200")
public class UserController 
{
	private UserService service;
	public UserController(UserService service) 
	{
		super();
		this.service = service;
	}
	
	@GetMapping("/users")
	public ResponseEntity<List<User>> getAllUsers(){
		List<User> users=service.findAll();
		return  new ResponseEntity<>(users,HttpStatus.OK);
	}
	
	@GetMapping("/users/{user_id}")
	public ResponseEntity<User> getUserById(@PathVariable int user_id){
		User user = service.findById(user_id);
		return new ResponseEntity<>(user,HttpStatus.OK);
	}
	
	@PutMapping("/users")
	public ResponseEntity<User> UpdateUser(@RequestBody  User user) {
		User userUpdated=service.update(user);
		return new ResponseEntity<>(userUpdated,HttpStatus.OK);
	}
	
	@DeleteMapping	("/users/{userId}")
	public ResponseEntity<HttpStatus> deleteStudent(@PathVariable int userId){
		service.deleteUserById(userId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
