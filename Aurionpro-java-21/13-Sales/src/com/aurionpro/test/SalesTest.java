package com.aurionpro.test;
//import java.util.Scanner;
import com.aurionpro.model.Sales;
public class SalesTest 
{
	public static void main(String[] args) 
	{
		//Scanner input=new Scanner(System.in);
		Sales[] salesPerson= 
			{
				new Sales(1,"Aashish","MAHARASHTRA",2,	100),
				new Sales(2,"Vedang", "MAHARASHTRA",1,	2),
				new Sales(3,"Tanish","RAJASTHAN",  7,	100000),
				new Sales(4,"Nitesh","MAHARASHTRA", 6,	1),
				new Sales(5,"Siddhant","GUJRAT",   3,	120000),		
			};
	
		for(int i=0;i<salesPerson.length;i++) 
			{
				System.out.println(salesPerson[i]);
			}
			System.out.println("\n Highest Sales Amount person: "+ highestSalesPerson(salesPerson));
	
		System.out.println("\n Sum of all persons sales amount: "+sumOfAllSalesAmount(salesPerson));
			
		System.out.println("\n total Sum of all persons sales amount by city: "+sumOfAmountByCity(salesPerson,"MAHARASHTRA"));
			
	}
	//Person with highest sales
	private static Sales highestSalesPerson(Sales[] salesPerson) 
		{	
			Sales maxSalesAmountPerson=salesPerson[0];
			for(int i=0;i<salesPerson.length;i++) 
				{
					if(maxSalesAmountPerson.getSalesAmount()<salesPerson[i].getSalesAmount()) 
						{
							maxSalesAmountPerson=salesPerson[i];
						}
				}
			return maxSalesAmountPerson;
		}
	
	//Total sum of all sales Person amount
	private static int sumOfAllSalesAmount(Sales[] salesPerson)
		{
			int sum=0;
			for(int i=0;i<salesPerson.length;i++) 
				{
					sum+=salesPerson[i].getSalesAmount();
				}
			return sum;
		}
	//Total summ of amount by city
	private static int sumOfAmountByCity(Sales[] salesPerson,String state ) 
		{
			int sum=0;
			for(int i=0;i<salesPerson.length;i++) 
			{
				if(salesPerson[i].getState().equalsIgnoreCase(state)	) 
					{
						sum+=salesPerson[i].getSalesAmount();
					}
			}
			return sum;
		
		}
	
	
	
	
	
	
}
		
//		
//		Account highestSavingBalanceAccount=findHighestBalanceInAccountType(accountDetails,AccountType.SAVING);
//		System.out.println("The highest balance for saving account is "+highestSavingBalanceAccount);
//		
//		Account highestCurrentBalanceAccount=findHighestBalanceInAccountType(accountDetails,AccountType.CURRENT);
//		System.out.println("The highest balance for Current account is "+highestCurrentBalanceAccount);
//		
//		
//		System.out.println("Sum of all the account holders is "+ sumOfBalances(accountDetails));
//		
//		double sumOfSavingAccountBalances=sumOfBalancesType(accountDetails,AccountType.SAVING);
//		System.out.println("Sum of saving account balances is "+ sumOfSavingAccountBalances);
//
//		double sumOfCurrentAccountBalances=sumOfBalancesType(accountDetails,AccountType.CURRENT);
//		System.out.println("Sum of current account balances is "+ sumOfCurrentAccountBalances);
//		
//		sortBasedOnBalance(accountDetails);
//		for(int i=0;i<accountDetails.length;i++) {
//			System.out.println(accountDetails[i]);
//		}
//	}
//
//	
////Sum of all balances
//	private static double sumOfBalances(Account[] accountDetails) 
//	{
//		double sum=0;
//		for(int i=0;i<accountDetails.length;i++) 
//		{
//			sum+=accountDetails[i].getBalance();
//		}
//		return sum;
//	}
//	
////Sum of balances of a type(SAVING/CURRENT)
//	private static double sumOfBalancesType(Account[] accountDetails,AccountType acountType) 
//	{
//		double sum=0;
//		for(int i=0;i<accountDetails.length;i++) 
//		{
//			if(accountDetails[i].getAccountType().equals(acountType))
//			{
//				sum+=accountDetails[i].getBalance();
//			}
//		}
//		return sum;
//	}
//	
//	
//// Finding highest balanced account details	
//	private static Account findHighestBalance(Account[] accountDetails) 
//	{	
//		Account maxAmount=accountDetails[0];
//		for(int i=0;i<accountDetails.length;i++) 
//		{
//			
//			if(accountDetails[i].getBalance()>maxAmount.getBalance()) 
//			{
//				maxAmount=accountDetails[i];
//			}
//		}
//		return maxAmount;
//	}
//	
////Finding highest balance account in a single type(Saving/Current)
//	private static Account findHighestBalanceInAccountType(Account[] accountDetails,AccountType accountType) 
//	{
//		Account maxAccount=null;
//		for(int i=0;i<accountDetails.length;i++) 
//		{
//			if(maxAccount==null && accountDetails[i].getAccountType().equals(accountType)) 
//			{
//				maxAccount=accountDetails[i];
//			}
//			if(maxAccount!=null && accountDetails[i].getAccountType().equals(accountType) &&accountDetails[i].getBalance()> maxAccount.getBalance()) 
//			{
//				maxAccount=accountDetails[i];
//			}
//		}
//		return maxAccount;
//		
//	}
//
////Sorting Based on balances
//	public static void sortBasedOnBalance(Account[] accountDetails) 
//	{
//		Account temp=null;
//		for(int i=0;i<accountDetails.length-1;i++) 
//		{
//			for(int j=i+1;j<accountDetails.length;j++) 
//			{
//				if(accountDetails[i].getBalance()<accountDetails[j].getBalance())
//				{
//					temp=accountDetails[i];
//					accountDetails[i]=accountDetails[j];
//					accountDetails[j]=temp;
//				}
//			}
//		}
//	}
//	
//	
////Setting Account details
//	private static void setAccountDetails(Account accountDetails) 
//	{
//		Scanner input = new Scanner(System.in);		
//		System.out.print("Enter Account Type(Saving/Current): ");
//		String type=input.nextLine();
//		try {
//			accountDetails.setAccountType(AccountType.valueOf(type.toUpperCase()));
//		} catch (Exception e) {
//			accountDetails.setAccountType(AccountType.SAVING);
//		}
//		System.out.print("Enter Account holder name: ");
//		String name=input.nextLine();
//		accountDetails.setName(name);
//		System.out.print("Enter Balance amount: ");
//		double balance=input.nextDouble();
//		accountDetails.setBalance(balance);
//		System.out.print("Enter id: ");
//		int id=input.nextInt();
//		accountDetails.setAccountId(id);
//
//		System.out.println("************");
//
//
//	}
//
//}
