package com.aurionpro.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "account")
public class Account 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="account_number")
	private int    accountNumber   ;
	
	@OneToOne
	@JoinColumn(name = "type_id")	
	private AccountType typeId;
	
	@Column(name="account_balance")
	private double balance;
	
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="customer_id" ,referencedColumnName="customer_id")
	private Customer customerId;


	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="bank_id" ,referencedColumnName="bank_id")
	private Bank bankId;

	@OneToMany(mappedBy = "accountNo")
	@JsonIgnore
	private List<Transaction> transactions = new ArrayList<>();
	
}

