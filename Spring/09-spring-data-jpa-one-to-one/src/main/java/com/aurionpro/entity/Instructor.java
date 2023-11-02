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
@Table(name = "instructor")
public class Instructor 
{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int    id   ;
	@Column(name="name")
	private String name ;
	@Column(name="email")
	private String email;
	@Column(name="doj")
	private Date   doj  ;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "fk_detail_id")
	private InstructorTechDetail detail;
	
	
	
//	public Instructor(int id, String name, String email, Date doj) 
//	{
//		super();
//		this.id   = id   ;
//		this.name = name ;
//		this.email= email;
//		this.doj  = doj  ;
//	}
//	public Instructor()					{		super();				}
//	
//	public int 	  getId   ()			{		return id;				}
//	public String getName ()  			{		return name;			}
//	public String getEmail() 			{		return email;			}
//	public Date   getDoj  () 			{		return doj;				}	
//	
//	public void setId     (int id)	 	{		this.id = id;			}
//	public void setName (String name) 	{		this.name = name;		}
//	public void setEmail(String email) 	{		this.email = email;		}
//	public void setDoj   (Date doj)		{		this.doj = doj;			}
//	
//	@Override
//	public String toString() 
//	{	return "Instructor [id=" + id + ", name=" + name + ", email=" + email + ", doj=" + doj + "]";	}
}
