package com.aurionpro.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.aurionpro.entity.Student;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class StudentDaoImpl implements StudentDao
{
	private EntityManager manager;					
	
	public StudentDaoImpl(EntityManager manager) 
	{
		super();
		this.manager = manager;
	}

	@Transactional
	@Override
	public void saveStudent(Student student) 
	{
		manager.persist(student);
		
	}

	@Override
	public Student findStudent(int id) 
	{
		return manager.find(Student.class, id);
	}

	@Override
	public List<Student> findAll() {
		TypedQuery<Student> query = manager.createQuery("from Student",Student.class);
		return query.getResultList();
	}

	@Transactional
	@Override
	public void deleteStudent(int id) {
		Student student = manager.find(Student.class, id);
		if(student!=null) {
			manager.remove(student);
			System.out.println("Deleted Successfully");
		}else {
			System.out.println("Could not found the student with id= "+id);
		}
		
	}

	@Override
	public List<Student> findStudent(String firstName) {
		TypedQuery<Student> query = manager.createQuery("select s from Student s where s.firstName = ?1",Student.class);
		query.setParameter(1, firstName);
		
		return query.getResultList();
	}
	
	
}
