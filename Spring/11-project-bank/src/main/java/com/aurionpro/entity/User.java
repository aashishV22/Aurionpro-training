package com.aurionpro.entity;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "users")
public class User 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="user_id")
	private int    id   ;
			
	@Column(name="user_Fname")
	private String firstName ;
	
	@Column(name="user_Lname")
	private String lastName ;
			
	@Column(name="user_Username")
	private String email;
	
	@Column(name="user_password")
	private String password  ;
	
	@OneToMany(mappedBy = "user")
	@JsonIgnore
	private List<Account> accounts = new ArrayList<>();
	
			
}
