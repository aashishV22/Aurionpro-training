package com.aurionpro.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "account_type")
public class AccountType 
{
	@Id
	@Column(name="type_id")
	private int typeId;
	
	@OneToOne(mappedBy = "typeId")
	@JsonIgnore
	private Account account;
	
	@Column(name="type_name")
	private String typeName;
}
