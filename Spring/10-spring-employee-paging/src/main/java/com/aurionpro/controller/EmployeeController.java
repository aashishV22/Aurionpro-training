package com.aurionpro.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aurionpro.dto.EmployeePageDto;
import com.aurionpro.entity.Employee;
import com.aurionpro.services.EmployeeService;

@RestController
@RequestMapping("/api")
public class EmployeeController 
{
	private EmployeeService service;
	public EmployeeController(EmployeeService service) {
		super();
		this.service = service;
	}
	
	@GetMapping("/employees")
	public EmployeePageDto getEmployees
					(
							@RequestParam(defaultValue = "10") int pageSize,
							@RequestParam(defaultValue = "0")  int pageNo,
							@RequestParam(defaultValue = "id") String title,
							@RequestParam(defaultValue = "asc") String direction
					) 
	{

		EmployeePageDto employeeDto = service.findAll(pageNo,pageSize,title,direction);
		return employeeDto;
	}
	
	@GetMapping("/employees/emai/{email}")
	public ResponseEntity<List<Employee>> getEmail(@PathVariable String email){
		List<Employee> employees=service.findByEmail(email);
		return  new ResponseEntity<>(employees,HttpStatus.OK);
 
	}
	
	@GetMapping("employees/firstName/{firstName}")
	public ResponseEntity<List<Employee>> getByFirstName(@PathVariable String firstName){
		List<Employee> employees=service.findByFirstName(firstName);
		return  new ResponseEntity<>(employees,HttpStatus.OK);
	}
	
	
	
}
