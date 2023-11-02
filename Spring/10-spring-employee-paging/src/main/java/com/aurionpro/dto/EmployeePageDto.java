package com.aurionpro.dto;

import java.util.List;

import com.aurionpro.entity.Employee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmployeePageDto {
	private List<Employee> content;
	private int pageNumber;
	private int numberOfElements;
	private long totalElements;
	private int totalPages;
	private boolean hasNext;
	private boolean hasPrevious;
	private boolean isFirst;
	private boolean isLast;
}
