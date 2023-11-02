package com.aurionpro.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.aurionpro.entity.Admin;

public interface AdminService {

	List<Admin> findAll();

	Optional<Admin> findById(int admin_id);

	void updateStatus(String status, int requestId);

}
