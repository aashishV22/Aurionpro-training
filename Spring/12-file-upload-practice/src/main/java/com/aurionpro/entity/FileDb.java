package com.aurionpro.entity;

import org.hibernate.annotations.GenericGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "files")
public class FileDb 
{
	@Id
	@GeneratedValue(generator = "uuid")
	@GenericGenerator(name = "uuid", strategy = "uuid2")
	@Column(name="file_id")
	private String fileId;
	
	@Column(name="file_name")
	private String fileName;

	@Column(name="file_type")
	private String file_type;

	@Lob
	@Column(name="data")
	private byte[] data;

	public FileDb(String fileName, String file_type, byte[] data) {
		this.fileName = fileName;
		this.file_type = file_type;
		this.data = data;
	}
	
	

}
