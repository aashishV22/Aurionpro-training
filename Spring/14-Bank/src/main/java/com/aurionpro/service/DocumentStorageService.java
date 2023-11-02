package com.aurionpro.service;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.aurionpro.entity.Document;
import com.aurionpro.repository.DocumentRepository;

@Service
public class DocumentStorageService {
	
	@Autowired
	private DocumentRepository fileDbRepo;
	
	public Document store(MultipartFile file) throws IOException, ParseException 
	{
		 Date inputDate = new Date();
		 SimpleDateFormat inputFormat = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");
		 SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd");
		 Date date = inputFormat.parse(inputDate.toString());
//		 String formattedDate = outputFormat.format(date);
	    
	    String documentTitle = StringUtils.cleanPath(file.getOriginalFilename());
	    Document document = new Document(documentTitle,file.getContentType() , date, file.getBytes());
	    
	    return fileDbRepo.save(document);
	}
	
	public Document getFile(String id) 
	{
		
		return fileDbRepo.findById(id).get() ;
	}
	
	public Stream<Document> getAllFiles() 
	{
	    return fileDbRepo.findAll().stream();
	}

	public void update(Document store) {
		fileDbRepo.save(store);
	}
}
