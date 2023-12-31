package com.aurionpro.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.aurionpro.entity.Document;
import com.aurionpro.entity.ResponseDocument;
import com.aurionpro.service.DocumentStorageService;

@RestController
@RequestMapping("/document")
public class DocumentController 
{
	@Autowired
	private DocumentStorageService documentService;
	
	@PostMapping("/upload")
	public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file){
		String message="";
		try 
		{
			Document store = documentService.store(file);
			String fileDownloadUri = ServletUriComponentsBuilder
					.fromCurrentContextPath()
					.path("/document/files/")
					.path(String.valueOf(store.getDocumentId()))
					.toUriString();
			System.out.println(fileDownloadUri);
			store.setSize(file.getSize());
			store.setUrl(fileDownloadUri);
			System.out.println(store);
			documentService.update(store);
			message = "Uploaded the file successfully: " + file.getOriginalFilename()+"\nFile size: "+file.getSize();
			return new ResponseEntity<String>(message,HttpStatus.OK);
		}catch(Exception e) 
			{	
				message = "Could not upload the file: " + file.getOriginalFilename() + "!\nFile size: "+file.getSize();
				return new ResponseEntity<String>(message,HttpStatus.EXPECTATION_FAILED);
			}
	}
	 

	@GetMapping("/files")
	public ResponseEntity<List<ResponseDocument>> getAllFiles(){
		List<ResponseDocument> files=documentService.getAllFiles()
										.map(dbFile->
											{
												String fileDownloadUri = ServletUriComponentsBuilder
																			.fromCurrentContextPath()
																			.path("/document/files/")
																			.path(dbFile.getDocumentId())
																			.toUriString();
												System.out.println(fileDownloadUri);
												return new ResponseDocument
															(		dbFile.getDocumentTitle(),
																	fileDownloadUri,
																	dbFile.getType(),
																	dbFile.getData().length);
											}).collect(Collectors.toList());
	
		return new ResponseEntity<>(files,HttpStatus.OK);
	}
	
	@GetMapping("/files/{id}")
	  public ResponseEntity<byte[]> getFile(@PathVariable String id) {
	    Document fileDB = documentService.getFile(id);

	    return ResponseEntity.ok()
	        .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + fileDB.getDocumentTitle() + "\"")
	        .body(fileDB.getData());
	  }
}
