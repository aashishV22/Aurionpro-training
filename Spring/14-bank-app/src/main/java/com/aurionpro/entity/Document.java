package com.aurionpro.entity;

import java.util.Date;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToOne;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "document")
public class Document 
{
	private static int value=0;
	
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Column(name="document_id")
	private String documentId ;
	
	@Column(name = "request_id")
	private int requestId=value++;
	
	@Column(name="request_status")
	private String   requestStatus="pending"  ;
	
	
	@Column(name="customer_id")
	private int    customerId   ;
	
	@Column(name = "account_type_id")	
	private int accountTypeId;

	
	@Column(name="document_title")
	private String documentTitle;
	
	@Column(name="document_upload_date")
	private Date uploadDate;

	@Lob
	@Column(name="data" , columnDefinition="LONGBLOB")
	private byte[] data;
	
	@Column(name="document_url")
	private String url;

	@Column(name="document_type")
	private String type;
	
	@Column(name="document_size")
	private long size;
	
	@Column(name="balance")
	private double balance; 
	
	
	

	public Document(String documentTitle, String type,Date uploadDate, byte[] data) {
		this.documentTitle = documentTitle;
		this.type=type;
		this.uploadDate = uploadDate;
		this.data = data;
	}
	
	

}
