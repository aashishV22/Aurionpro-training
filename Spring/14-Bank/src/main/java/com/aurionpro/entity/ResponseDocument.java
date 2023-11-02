package com.aurionpro.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDocument 
{
	private String name;
	private String url;
	private String type;
	private long size;	
}
