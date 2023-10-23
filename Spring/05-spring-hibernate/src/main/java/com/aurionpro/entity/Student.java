package com.aurionpro.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "studentnew")
public class Student 
{
	//Auto increment id and primary key is id
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	@Column(name="name")
	private String firstName;
	@Column(name="last_name")
	private String lastname;
	@Column(name="email")
	private String email;
	
	
	public Student() 
	{
		super();
	}
	public Student(int id, String firstName, String lastname, String email) 
	{
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastname = lastname;
		this.email = email;
	}
	public Student(String firstName, String lastname, String email) 
	{
		super();
		this.firstName = firstName;
		this.lastname = lastname;
		this.email = email;
	}
//Getters and setters
	public int 	getId() 						{		return id;						}
	public String getFirstName() 				{		return firstName;				}
	public String getLastname() 				{		return lastname;				}
	public String getEmail() 					{		return email;					}

	public void   setId(int id) 				{		this.id = id;					}
	public void   setFirstName(String firstName){		this.firstName = firstName;		}
	public void   setLastname(String lastname) 	{		this.lastname = lastname;		}
	public void   setEmail(String email)		{		this.email = email;				}
	
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", firstName=" + firstName + ", lastname=" + lastname + ", email=" + email + "]";
	}
	
	
}
