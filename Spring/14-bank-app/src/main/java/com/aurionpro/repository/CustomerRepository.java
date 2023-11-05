package com.aurionpro.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.http.ResponseEntity;

import com.aurionpro.entity.Customer;
import com.aurionpro.entity.User;

public interface CustomerRepository extends JpaRepository<Customer, Integer>{

	@Query("SELECT c FROM Customer c WHERE c.user_id = :user")
	Customer findByUser(@Param("user") User user);

}
