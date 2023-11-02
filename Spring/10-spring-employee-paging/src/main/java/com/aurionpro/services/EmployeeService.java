package com.aurionpro.services;

import java.util.List;

import com.aurionpro.dto.EmployeePageDto;
import com.aurionpro.entity.Employee;

public interface EmployeeService {

	EmployeePageDto findAll(int pageNo, int pageSize);

	EmployeePageDto findAll(int pageNo, int pageSize, String title, String direction);

	List<Employee> findByEmail(String email);

	List<Employee> findByFirstName(String firstName);

}
