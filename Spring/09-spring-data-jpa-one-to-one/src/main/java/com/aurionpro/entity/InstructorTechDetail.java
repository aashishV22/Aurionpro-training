package com.aurionpro.entity;


import java.util.Date;

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
@Table(name = "instructor_techdetail")
public class InstructorTechDetail 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int 	id;
	@Column(name="youtube_url")
	private String youtubeUrl;
	@Column(name="giturl")
	private String gitUrl;

	@OneToOne(mappedBy = "detail")
	@JsonIgnore
	private Instructor instructor;
	
//	public InstructorTechDetail(int id, String youtubeUrl, String gitUrl) 
//	{	super();
//		this.id 		= id		;
//		this.youtubeUrl = youtubeUrl;
//		this.gitUrl 	= gitUrl	;
//	}
//	public InstructorTechDetail() 
//	{		super();	}
//	
//	public int 	  getId   	   ()				 {		return id        ;				}
//	public String getYoutubeUrl() 				 {		return youtubeUrl;				}
//	public String getGitUrl	   () 				 {		return gitUrl    ;				}
//	
//	public void setYoutubeUrl(String youtubeUrl) {		this.youtubeUrl = youtubeUrl;	}
//	public void setGitUrl	 (String gitUrl) 	 {		this.gitUrl = gitUrl		;	}
//	public void setId     	 (int id)	 		 {		this.id = id				;	}
//	@Override
//	public String toString() 
//	{	return "InstructorTechDetail [id=" + id + ", youtubeUrl=" + youtubeUrl + ", gitUrl=" + gitUrl + "]";	}

	
	
}
