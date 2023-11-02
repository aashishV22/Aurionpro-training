package com.aurionpro.service;

import java.util.List;
import java.util.Optional;

import com.aurionpro.entity.Instructor;

public interface InstructorService 
{
	List<Instructor> findAll();

	Optional<Instructor> findInstructorById(int instructorId);

	Instructor save(Instructor instructor);

	void deleteInstructorById(int instructorId);

	void updateInstructorDetailsOfInstructor(int id, int detailsId);
}
