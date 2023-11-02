package com.aurionpro.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aurionpro.entity.Admin;
import com.aurionpro.entity.User;
import com.aurionpro.service.AdminService;

@RestController
@RequestMapping("/app")
public class AdminController 
{
	@Autowired
	private AdminService adminService;
	
	@GetMapping("/admins")
	public ResponseEntity<List<Admin>> getAllUsers(){
		List<Admin> admins=adminService.findAll();
		return  new ResponseEntity<>(admins,HttpStatus.OK);
	}
	
	@GetMapping("/admins/{admin_id}")
	public ResponseEntity<Optional<Admin>> getUserById(@PathVariable int admin_id){
		Optional<Admin> admin = adminService.findById(admin_id);
		return new ResponseEntity<>(admin,HttpStatus.OK);
	}
	
}
