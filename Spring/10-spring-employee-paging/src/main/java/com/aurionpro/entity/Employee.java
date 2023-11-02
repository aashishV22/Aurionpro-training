package com.aurionpro.entity;

import java.util.Date;

import jakarta.persistence.CascadeType;
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
	@Table(name = "employee")
	public class Employee 
	{
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column(name="employee_id")
		private int    id   ;
		
		@Column(name="employee_Fname")
		private String firstName ;
		@Column(name="employee_Lname")
		private String lastName ;
		
		@Column(name="employee_email")
		private String email;
		
		@Column(name="employee_doj")
		private Date   doj  ;
			
		@Column(name="employee_dob")
		private Date   dob  ;
		
	}
