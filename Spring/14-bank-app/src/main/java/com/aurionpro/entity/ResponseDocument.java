package com.aurionpro.entity;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDocument 
{
	private int customerId;
	private Date uploadDate;
	private String requestStatus;
	private int accountTypeId;
	private String name;
	private String url;
	private String type;
	private long size;	
	private double balance;
}
