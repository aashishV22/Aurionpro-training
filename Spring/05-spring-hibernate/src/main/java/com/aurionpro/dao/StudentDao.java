package com.aurionpro.dao;

import java.util.List;

import com.aurionpro.entity.Student;

public interface StudentDao 
{
	 public void saveStudent(Student student);

	public Student findStudent(int i);

	public List<Student> findAll();

	public void deleteStudent(int id);

	public List<Student> findStudent(String firstName);

	public void updateStudent(Student student);

	public void updateStudentById(int id);

	
}
