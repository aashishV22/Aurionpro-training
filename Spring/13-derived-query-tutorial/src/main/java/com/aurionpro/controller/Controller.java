package com.aurionpro.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aurionpro.entity.Tutorial;
import com.aurionpro.repository.TutorialRepository;

@RestController
@RequestMapping("/app")
public class Controller {
	@Autowired
	private TutorialRepository repository;
	
	@GetMapping("/tutorials")
	public ResponseEntity<List<Tutorial>> getAllTutorialsEntity(){
		List<Tutorial> tutorials = repository.findAll();
		return new ResponseEntity<>(tutorials,HttpStatus.OK);
	}	
	
}
