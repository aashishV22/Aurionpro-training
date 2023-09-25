package com.aurionpro.test;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.aurionpro.model.Employee;

public class EmployeeCRUD 
{
	public static void main(String[] args) 
	{
		EmployeeTest employeeCRUD=new EmployeeTest();

		Scanner sc=new Scanner(System.in);
		boolean isTaskEnded=false;
		int input = 0;
		while(!isTaskEnded) 
		{
	
			try 
			{
			System.out.println(" Enter 0 to Exit \n Enter 1 to Find all Employees in a department \n Enter 2 to Find Count of Employees in each department \n Enter 3 to add an employee in the list "
					+ "\n Enter 4 to Delete Employee by ID \n Enter 5 to get higest Paid employeein a department \n Enter 6 to find highest paid employee on each role"
					+ "\n Enter 7 to  Find the immediate manager of the employee \n Enter 8 to Find salesman with highest commission \n Enter 9 to get Sum of All Employees ");
			

				input =sc.nextInt();
				switch(input) 
				{
					case 0:
						isTaskEnded=true;
						System.out.println("Task Stopped");
						break;
					case 1:
						System.out.println("Enter Department id to get all Employees in that department: ");			int depIDAll=sc.nextInt();
						employeeCRUD.getEmployeesByDepartmentID(depIDAll);						
						break;
					case 2:
						System.out.println("Enter Department id to get count of Employees in that department: ");  		int depID=sc.nextInt();
						employeeCRUD.getCountOfEmployeesByDepartmentID(depID);						
						break;

					case 3:
						System.out.println("Enter employee-ID: ");											int employeeID=sc.nextInt();
						System.out.println("Enter employee-Name: ");	   				sc.nextLine();		String employeeName=sc.nextLine();
						System.out.println("Enter employee-Designation: ");				/*sc.nextLine();*/	String employeeDesignation=sc.nextLine();
						System.out.println("Enter Date of joining(yyyy-MM-dd): ");	/*sc.nextLine();*/		String employeeDOJ=sc.nextLine();

						DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
						LocalDate dateTime=LocalDate.parse(employeeDOJ,formatter);  
						System.out.println("Enter Employee's-Manager-ID: ");								int employeeManagerID=sc.nextInt();
						System.out.println("Enter Employee's-salary: ");									int employeeSalary=sc.nextInt();
						System.out.println("Enter Employee's-Compemsation: ");								int employeeCompensation=sc.nextInt();
						System.out.println("Enter Employee's-DepartmentID: ");								int employeeDepartmentID=sc.nextInt();

						employeeCRUD.addEmployee(new Employee(employeeID,employeeName,employeeDesignation,dateTime,employeeManagerID,employeeSalary,employeeCompensation,employeeDepartmentID));
						break;
						
					case 4:
						System.out.println("Enter Employee-Id which is to be deleted: ");					int empID=sc.nextInt();
						employeeCRUD.deleteEmployee(empID);
						break;
						
					case 5:
						System.out.println("Enter Department id to get Employees with highest salary in that deoartment: ");	int departmentIDSalary=sc.nextInt();
						if(departmentIDSalary!=10 && departmentIDSalary!=20 && departmentIDSalary!=30) {	
							System.out.println("Enter a valid Department-ID ");
							break;
						}
						employeeCRUD.highestPaidInDepartment(departmentIDSalary);
						break;
					case 6:
						System.out.println("Enter role: ");				sc.nextLine();			String empRole=sc.nextLine();
						String role=empRole.toUpperCase();
						System.out.println(role);
						if(!role.equalsIgnoreCase("MANAGER") && !role.equalsIgnoreCase("CLERK") && !role.equalsIgnoreCase("ANALYST") && !role.equalsIgnoreCase("SALESMAN") && !role.equalsIgnoreCase("PRESIDENT")) {
							System.out.println("Enter a Valid role");
							break;
						}
						employeeCRUD.highestPaidByRole(role);
						break;
					case 7:
						System.out.println("Enter EMployeeID: ");			int ID=sc.nextInt();
						employeeCRUD.findManagerByEmpID(ID);
						break;
					case 8:
						System.out.println("Highest Commision salesman is: ");
						employeeCRUD.highestCommisionSalesman();
						break;
						
					case 9:
						System.out.println("Sum of employee is ");
						employeeCRUD.sum();
						break;
						
					default:
						isTaskEnded=true;
						System.out.println("Enter a number from menu ");
						break;
				}
			}
			catch (InputMismatchException  e) 	{		System.out.println("Enter a valid input format")			   ;	} 
			catch (NumberFormatException e) 	{		System.out.println("You entered a number instead of a string.");	}
			catch (Exception e) 				{	    System.out.println("enter valid number from menu");   				}
		}
	}
}
