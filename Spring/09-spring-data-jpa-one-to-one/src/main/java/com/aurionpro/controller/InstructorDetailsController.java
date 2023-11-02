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
import com.aurionpro.entity.InstructorTechDetail;
import com.aurionpro.service.InstructorDetailsService;
import com.aurionpro.service.InstructorService;

@RestController
@RequestMapping("/app")
public class InstructorDetailsController 
{
	private InstructorDetailsService service;
	public InstructorDetailsController(InstructorDetailsService service)
	{
		super();
		this.service = service;
	}


	@GetMapping("/details")
	public ResponseEntity<List<InstructorTechDetail>> getAllStudents()
	{	
		List<InstructorTechDetail> detailsAll=service.findAll();
		return new ResponseEntity<>(detailsAll,HttpStatus.OK) ;
	}

	
	@PostMapping("/details")
	public ResponseEntity<InstructorTechDetail> addNewStudent(@RequestBody  InstructorTechDetail instructorDetails){
		InstructorTechDetail newInstructor=service.save(instructorDetails);
		return  new ResponseEntity<>(newInstructor,HttpStatus.CREATED);
	}
	
	@PutMapping("/details")
	public ResponseEntity<InstructorTechDetail> UpdateStudent(@RequestBody  InstructorTechDetail instructorDetails) {
		InstructorTechDetail updateInstructor=service.save(instructorDetails);
		return new ResponseEntity<>(updateInstructor,HttpStatus.OK);
	}
	
	@DeleteMapping	("/details/{instructorDetailsId}")
	public ResponseEntity<HttpStatus> deleteStudent(@PathVariable int instructorDetailsId) {
		service.deleteInstructorDetailsById(instructorDetailsId);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	
	
}
