package com.aurionpro.model;

public class TaxUtil {

	public static double calculateTax(Employee employee) {
		TotalMonthSalary salary=new TotalMonthSalary();
		double annualSalary=salary.calculateTotalSalary(employee)*12;
		double totalMonthSalary=salary.calculateTotalSalary(employee);
//		System.out.println(totalMonthSalary);
		employee.setToatlMonthSalary(totalMonthSalary);
		if(annualSalary>500000 && annualSalary<800000) {
			employee.setAnnualTaxSalary(((annualSalary*10)/100));
		}else if(annualSalary>800000 && annualSalary<1000000)
		{
			employee.setAnnualTaxSalary(((annualSalary*20)/100));
		}else if(annualSalary>1000000){
			employee.setAnnualTaxSalary(((annualSalary*30)/100));
		}
		return employee.getAnnualTaxSalary();
	}
}
