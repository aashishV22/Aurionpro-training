package com.aurionpro.services;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.aurionpro.dto.EmployeePageDto;
import com.aurionpro.entity.Employee;
import com.aurionpro.repository.EmployeeRepository;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	private EmployeeRepository repository;
	public EmployeeServiceImpl(EmployeeRepository repository) {
		super();
		this.repository = repository;
	}

	@Override
	public EmployeePageDto findAll(int pageNo, int pageSize) {
		Pageable pageable= PageRequest.of(pageNo,pageSize);
		Page<Employee> page = repository.findAll(pageable);
		List<Employee> employees = page.getContent();
		
		EmployeePageDto employeeDto=new EmployeePageDto();
		employeeDto.setContent(employees);
		employeeDto.setFirst(page.isFirst());
		employeeDto.setLast(page.isLast());
		employeeDto.setHasNext(page.hasNext());
		employeeDto.setHasPrevious(page.hasPrevious());
		employeeDto.setNumberOfElements(page.getNumberOfElements());
		employeeDto.setPageNumber(page.getNumber());
		employeeDto.setTotalElements(page.getTotalElements());
		employeeDto.setTotalPages(page.getTotalPages());
		
		return employeeDto;
	
	}

	@Override
	public EmployeePageDto findAll(int pageNo, int pageSize, String title, String direction) {
		Sort sort=null;
		if(direction.equalsIgnoreCase("desc")) 
			{
				sort=Sort.by(Sort.Direction.DESC,title);
			}else
			{
				sort=Sort.by(Sort.Direction.ASC,title);
			}
		Pageable pageable= PageRequest.of(pageNo,pageSize,sort);

		Page<Employee> page = repository.findAll(pageable);
		List<Employee> employees = page.getContent();
		
		EmployeePageDto employeeDto=new EmployeePageDto();
		employeeDto.setContent(employees);
		employeeDto.setFirst(page.isFirst());
		employeeDto.setLast(page.isLast());
		employeeDto.setHasNext(page.hasNext());
		employeeDto.setHasPrevious(page.hasPrevious());
		employeeDto.setNumberOfElements(page.getNumberOfElements());
		employeeDto.setPageNumber(page.getNumber());
		employeeDto.setTotalElements(page.getTotalElements());
		employeeDto.setTotalPages(page.getTotalPages());
		
		return employeeDto;

	}

	@Override
	public List<Employee> findByEmail(String email) {
		return repository.findByEmail(email);
	}

	@Override
	public List<Employee> findByFirstName(String firstName) {
		return repository.findByFirstName(firstName);
	}

}
