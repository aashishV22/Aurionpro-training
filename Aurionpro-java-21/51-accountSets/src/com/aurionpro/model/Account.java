package com.aurionpro.model;

import java.util.Objects;

public class Account 
{
	private String accountHolderName;
	private String accountType;
	public Account(String accountHolderName, String accountType) {
		super();
		this.accountHolderName = accountHolderName;
		this.accountType = accountType;
	}
	public String getAccountHolderName() {
		return accountHolderName;
	}
	public void setAccountHolderName(String accountHolderName) {
		this.accountHolderName = accountHolderName;
	}
	public String getAccountType() {
		return accountType;
	}
	public void setAccountType(String accountType) {
		this.accountType = accountType;
	}
	@Override
	public String toString() {
		return "Account [accountHolderName=" + accountHolderName + ", accountType=" + accountType + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(accountHolderName, accountType);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Account other = (Account) obj;
		return Objects.equals(accountHolderName, other.accountHolderName)
				&& Objects.equals(accountType, other.accountType);
	}
	
	
	
	
}
