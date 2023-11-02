package com.aurionpro.service;

import java.util.List;

import com.aurionpro.entity.InstructorTechDetail;

public interface InstructorDetailsService {

	List<InstructorTechDetail> findAll();

	InstructorTechDetail save(InstructorTechDetail instructorDetails);

	void deleteInstructorDetailsById(int instructorDetailsId);


}
