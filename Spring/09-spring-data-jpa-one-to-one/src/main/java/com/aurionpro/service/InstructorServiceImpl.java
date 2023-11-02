package com.aurionpro.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.aurionpro.entity.Instructor;
import com.aurionpro.entity.InstructorTechDetail;
import com.aurionpro.repository.InstructorDetailsRepository;
import com.aurionpro.repository.InstructorRepository;

@Service
public class InstructorServiceImpl implements InstructorService{
	private InstructorRepository repository;
	private InstructorDetailsRepository detailsRepository;
	
	public InstructorServiceImpl(InstructorRepository repository,InstructorDetailsRepository detailsRepository) 
	{
		super();
		this.repository = repository;
		this.detailsRepository=detailsRepository;
	}

	@Override
	public List<Instructor> findAll() {
		return repository.findAll();
	}

	@Override
	public Optional<Instructor> findInstructorById(int instructorId) {
		return repository.findById(instructorId);	
	}

	@Override
	public Instructor save(Instructor instructor) {
		return repository.save(instructor);
	}

	@Override
	public void deleteInstructorById(int instructorId) {
		if(repository.existsById(instructorId)) 
		{
			repository.deleteById(instructorId);			
		}
	}

	@Override
	public void updateInstructorDetailsOfInstructor(int id, int detailsId) {
		Instructor instructor=repository.findById(id).get();
		InstructorTechDetail details= detailsRepository.findById(detailsId).get();
		instructor.setDetail(details);
		repository.save(instructor);
		
	}

}
