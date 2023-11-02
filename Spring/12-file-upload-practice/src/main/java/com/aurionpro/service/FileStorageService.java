package com.aurionpro.service;

import java.io.IOException;
import java.util.stream.Stream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.aurionpro.entity.FileDb;
import com.aurionpro.repository.FileDbRepository;

@Service
public class FileStorageService {
	
	@Autowired
	private FileDbRepository fileDbRepo;
	
	public FileDb store(MultipartFile file) throws IOException 
	{
	    String fileName = StringUtils.cleanPath(file.getOriginalFilename());
	    FileDb FileDB = new FileDb(fileName, file.getContentType(), file.getBytes());
	    return fileDbRepo.save(FileDB);
	}
	
	public FileDb getFile(String id) 
	{
		return fileDbRepo.findById(id).get() ;
	}
	
	public Stream<FileDb> getAllFiles() 
	{
	    return fileDbRepo.findAll().stream();
	}
}
