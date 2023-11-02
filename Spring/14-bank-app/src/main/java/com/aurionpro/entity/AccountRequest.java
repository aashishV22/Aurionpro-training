package com.aurionpro.entity;

import org.springframework.boot.context.properties.bind.DefaultValue;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "account_requests")
public class AccountRequest 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="request_id")
	private int    requestId   ;
	
	@Column(name="request_status")
	private String   requestStatus="pending" ;
	
	
	@Column(name="customer_id")
	private int    accountNumber   ;
	
	@OneToOne
	@JoinColumn(name = "type_id")	
	private AccountType typeId;
}
