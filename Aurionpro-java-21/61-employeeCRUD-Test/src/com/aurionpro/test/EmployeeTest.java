package com.aurionpro.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.aurionpro.model.*;

public class EmployeeTest 
{
	
	static final String filePath="D:\\\\Aurionpro-java-21\\\\61-employeeCRUD-Test\\\\src\\\\employees.txt";
	List<Employee> employeesList;
	public EmployeeTest() {
		employeesList = new ArrayList();
		loadEmployees();
	}
	
	public void getEmployeesByDepartmentID(int departmentID) 
	{
		int count=0;
		List<Employee> employeesByDepartmentID = employeesList.stream()
			.filter((employee)->employee.getEmployeeDepartmentId()==departmentID)
			.collect(Collectors.toList());
		System.out.println(employeesByDepartmentID);
	}
	public void getCountOfEmployeesByDepartmentID(int departmentID) 
	{
		int count=0;
		for(Employee employee:employeesList) {
			if(employee.getEmployeeDepartmentId()==departmentID) {
				count++;
			}
		}
		System.out.println(count);
	}
	
	public void findManagerByEmpID(int employeeID) {
		int employeeManagerID = 0;
		for(Employee x:employeesList) 
		{
			if(x.getEmployeeID()==employeeID) 
			{
				employeeManagerID=x.getEmployeeManager();
			}
		};
		for(Employee x:employeesList) 
		{
			if(x.getEmployeeID()==employeeManagerID) 
			{
				employeeManagerID=x.getEmployeeManager();
				System.out.println(x);
				break;
			}
		}
		
	}
	
	public void highestPaidInDepartment(int departID) {
		Optional<Employee> maxSalaryByID = employeesList.stream()
			.filter((employee)->employee.getEmployeeDepartmentId()==departID)
			.max(Comparator.comparing(Employee::getEmployeeSalary));
			
		System.out.println(maxSalaryByID.get());
			
	}
	
	public void highestPaidByRole(String role) {
		Optional<Employee> maxSalaryByRole = employeesList.stream()
				.filter((employee)->employee.getEmployeeDesignation().equals(role))
				.max(Comparator.comparing(Employee::getEmployeeSalary));
				
			System.out.println(maxSalaryByRole.get());
	}

	public void highestCommisionSalesman() {
		System.out.println("insude salesman");
		Optional<Employee> maxSalarySalesman = employeesList.stream()
			.filter((employee)->employee.getEmployeeDesignation().equals("SALESMAN"))
			.max(Comparator.comparing(Employee::getEmployeeCompensation));
		System.out.println(maxSalarySalesman.get());
	}
	
	public void sum() {
		 Set<Employee> employeeSet = new HashSet<>(employeesList);
		 System.out.println(employeeSet);
		 Integer sum=employeeSet.stream()
				 .map(employee->employee.getEmployeeSalary())
				 .reduce(0,(a,b)->a+b);
		 System.out.println(sum);
		 
	}
	
	public List<Employee> getEmployees() 
		{	
			return employeesList;
		}
	public void fileReading() 
	{
		BufferedReader br=null;
		Scanner sc=new Scanner(System.in);
		try
		{
 			br=new BufferedReader(new FileReader("D:\\Aurionpro-java-21\\61-employeeCRUD-Test\\src\\emp.txt"));
			String line=br.readLine();
			while (line != null) 
			{
				String[] employeeArray = line.split(",");
				int employeeID=Integer.parseInt(employeeArray[0].trim());
//				System.out.println(employeeID);
				String employeeName=employeeArray[1].trim().replaceAll("\'", "");
				String employeeDesignation=employeeArray[2].replaceAll("\'", "");
				String employeeManagerNULL=employeeArray[3];
				int employeeManager;
				if(employeeManagerNULL.equals("NULL")) {
					employeeManager=0;
				}else {
					employeeManager=Integer.parseInt(employeeManagerNULL);
				}
				
				String 	employeeJoinDate=employeeArray[4].replaceAll("\'", "");
				LocalDate DOJ=getCorrectedDate(employeeJoinDate);
				int 	employeeSalary=Integer.parseInt(employeeArray[5].trim());
				int 	employeeCompensation;
				String 	employeeCompensationNull=employeeArray[6];
				
				if	 	(employeeCompensationNull.equals("NULL")) 		{	employeeCompensation=0;	}
				else 													{	employeeCompensation=Integer.parseInt(employeeCompensationNull);	}
				
				int 	employeeDepartmentID=Integer.parseInt(employeeArray[7].trim());
				employeesList.add(new Employee(employeeID,employeeName,employeeDesignation,DOJ,employeeManager,employeeSalary,employeeCompensation,employeeDepartmentID));
				line = br.readLine();
				saveEmployees();
			}
		}catch(IOException e) 
			{
				e.printStackTrace();
			}

		
	}
	
	

	
	
	
	
	
	
	
	//Deserialization
	public void loadEmployees() 
	{
			try 
			{
				FileInputStream file = new FileInputStream(filePath);
			      int b = file.available();
			      File file1 = new File(filePath);

			      boolean isEmpty = !file1.exists() || file1.length() == 0;
			      if(isEmpty) {
			    	  fileReading();
			    	  ObjectInputStream in = new ObjectInputStream(file);
						employeesList=(List<Employee>)in.readObject();
						in.close();
			      }
			      if (b != 0) {
			        ObjectInputStream in = new ObjectInputStream(file);
					employeesList=(List<Employee>)in.readObject();
					in.close();
			      }
//			      else {
//			    	  fileReading();
//			    	  ObjectInputStream in = new ObjectInputStream(file);
//			    	  employeesList=(List<Employee>)in.readObject();
//			    	  in.close();
//			      }
			      file.close();				
			}
			
				catch (FileNotFoundException  e) 	{				e.printStackTrace();			} 
				catch (IOException 			  e) 	{				e.printStackTrace();			} 
				catch (ClassNotFoundException e) 	{				e.printStackTrace();			}
	}
	
	
	//Serialization
	public void saveEmployees() {
		try 
		{
			OutputStream file = new FileOutputStream(filePath);
			ObjectOutputStream out=new ObjectOutputStream(file);
			out.writeObject(employeesList);
			out.close();
			file.close();
		} 	
			catch (FileNotFoundException  e) 	{				e.printStackTrace();			} 
			catch (IOException e) 		 	  	{				e.printStackTrace();			} 
	}

	public void addEmployee(Employee newEmployee) {
		boolean isEmployeePresent=false;
		for(Employee x:employeesList) 
		{
			if(newEmployee.getEmployeeID()==x.getEmployeeID()) 
			{
				System.out.println("employee-ID already registered");
				isEmployeePresent=true;
				break;
			}
		}
		if(!isEmployeePresent) 
		{
			employeesList.add(newEmployee);
			System.out.println("Employee added is- "+newEmployee);
			saveEmployees();
		}
	}
		public void deleteEmployee(int empID) {
			boolean isEmployeePresent=false;
			for(Employee x:employeesList) 
			{
				if(x.getEmployeeID()==empID) 
				{
					System.out.println("Employee removed: "+ x);
					employeesList.remove(x);
					isEmployeePresent=true;
					saveEmployees();
					break;
				}
			}
			if(!isEmployeePresent) 
			{
				System.out.println("Employee with id "+empID+" is not present in the list");
			}	
	}	

		private LocalDate	getCorrectedDate(String dateString) {
			String[] split=dateString.split("-");
			String day  = convertDateToTwoDigit (split[0]);
			String month= convertMonthToDigit   (split[1]);
			String year = convertYearToFourDigit(split[2]);
			String date = year+"-"+month+"-"+day;
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate dateTime=LocalDate.parse(date,formatter);
			return dateTime;
		}

		private String convertYearToFourDigit(String string) {
			return "19"+string;
		}

		private String convertMonthToDigit(String fileMonth) {
			Map<String,String> monthMap=new HashMap<>();
			monthMap.put("jan", "01");
			monthMap.put("feb", "02");
			monthMap.put("mar", "03");
			monthMap.put("apr", "04");
			monthMap.put("may", "05");
			monthMap.put("jun", "06");
			monthMap.put("jul", "07");
			monthMap.put("aug", "08");
			monthMap.put("sep", "09");
			monthMap.put("oct", "10");
			monthMap.put("nov", "11");
			monthMap.put("dec", "12");

			if(monthMap.containsKey(fileMonth.toLowerCase())) {
				return monthMap.get(fileMonth.toLowerCase());
			}
			return null;
		}

		private String convertDateToTwoDigit(String string) {
			int len=string.length();
			while(len!=2) {
				return "0"+string;
			}
			return string;
		}
		
}
