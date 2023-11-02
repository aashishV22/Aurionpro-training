package com.aurionpro.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aurionpro.entity.Instructor;
import com.aurionpro.service.InstructorService;

@RestController
@RequestMapping("/app")
public class InstructorController 
{
	private InstructorService service;
	public InstructorController(InstructorService service) 
	{
		super();
		this.service = service;
	}
	
	@GetMapping("/instructors")
	public ResponseEntity<List<Instructor>> getAllStudents(){
		return new ResponseEntity<>(service.findAll(),HttpStatus.OK) ;
	}

	
	@PostMapping("/instructors")
	public ResponseEntity<Instructor> addNewStudent(@RequestBody  Instructor instructor){
		Instructor newInstructor=service.save(instructor);
		return  new ResponseEntity<>(newInstructor,HttpStatus.CREATED);
	}
	
	@PutMapping("/instructors")
	public ResponseEntity<Instructor> UpdateStudent(@RequestBody  Instructor instructor) {
		Instructor updateInstructor=service.save(instructor);
		return new ResponseEntity<>(updateInstructor,HttpStatus.OK);
	}
	
	@DeleteMapping	("/instructors/{instructorId}")
	public ResponseEntity<HttpStatus> deleteStudent(@PathVariable int instructorId) {
		service.deleteInstructorById(instructorId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@PutMapping("/instructors/{id}/details/{detailsId}")
	public ResponseEntity<HttpStatus> updateInstructorDetailsOfInstructor(@PathVariable int id,@PathVariable int detailsId) {
		service.updateInstructorDetailsOfInstructor(id,detailsId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
}
