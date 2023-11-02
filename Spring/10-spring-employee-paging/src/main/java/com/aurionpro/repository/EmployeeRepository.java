package com.aurionpro.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.aurionpro.entity.Employee;


public interface EmployeeRepository extends JpaRepository<Employee, Integer> 
{

	List<Employee> findByEmail(String email);

	@Query("SELECT e FROM Employee e WHERE LOWER(e.firstName) LIKE LOWER(CONCAT('%', ?1,'%'))")
	List<Employee> findByFirstName(String firstName);

}
