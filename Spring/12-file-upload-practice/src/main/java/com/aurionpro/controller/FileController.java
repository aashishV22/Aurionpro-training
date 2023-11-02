package com.aurionpro.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.aurionpro.entity.FileDb;
import com.aurionpro.message.ResponseFile;
import com.aurionpro.message.ResponseMessage;
import com.aurionpro.service.FileStorageService;

@RestController
@RequestMapping("/app")
public class FileController 
{
	@Autowired
	private FileStorageService service;
	
	@PostMapping("/upload")
	public ResponseEntity<ResponseMessage> uploadFile(@RequestParam("file") MultipartFile file){
		String message="";
		try 
		{
			service.store(file);
			message = "Uploaded the file successfully: " + file.getOriginalFilename()+"\nFile size: "+file.getSize();
			return ResponseEntity.status(HttpStatus.OK).body(new ResponseMessage(message));
		}catch(Exception e) 
			{	
				message = "Could not upload the file: " + file.getOriginalFilename() + "!\nFile size: "+file.getSize();
		      	return ResponseEntity.status(HttpStatus.EXPECTATION_FAILED).body(new ResponseMessage(message));
			}
	}
	
	@GetMapping("/files")
	public ResponseEntity<List<ResponseFile>> getAllFiles(){
		List<ResponseFile> files=service.getAllFiles().map(dbFile->{
			String fileDownloadUri = ServletUriComponentsBuilder
			          .fromCurrentContextPath()
			          .path("/app/files/")
			          .path(dbFile.getFileId())
			          .toUriString();

			      return new ResponseFile(
			          dbFile.getFileName(),
			          fileDownloadUri,
			          dbFile.getFile_type(),
			          dbFile.getData().length);
		}).collect(Collectors.toList());
	
		return new ResponseEntity<>(files,HttpStatus.OK);
	}
	
	@GetMapping("/files/{id}")
	  public ResponseEntity<byte[]> getFile(@PathVariable String id) {
	    FileDb fileDB = service.getFile(id);

	    return ResponseEntity.ok()
	        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileDB.getFileName() + "\"")
	        .body(fileDB.getData());
	  }
}
