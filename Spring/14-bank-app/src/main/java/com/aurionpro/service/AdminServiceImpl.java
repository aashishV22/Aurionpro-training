package com.aurionpro.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aurionpro.entity.Admin;
import com.aurionpro.repository.AdminRepository;

@Service
public class AdminServiceImpl implements AdminService{

	@Autowired
	private AdminRepository adminRepo;
	
	@Override
	public List<Admin> findAll() {
		return adminRepo.findAll();
	}

	@Override
	public Optional<Admin> findById(int admin_id) {
		return adminRepo.findById(admin_id);
	}

}
