package com.aurionpro;

import java.util.List;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.aurionpro.dao.StudentDao;
import com.aurionpro.entity.Student;

@SpringBootApplication
public class Application implements CommandLineRunner{

	private StudentDao studentDao;
	
	
	public Application(StudentDao studentDao) 
	{
		super();
		this.studentDao = studentDao;
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		addNewStudent();
//		findStudent();
//		findAllStudents();
//		deleteStudentById();
		findStudentByFirstName();
	}	

	private void findStudentByFirstName() {
		String firstName="vedang";
		
		List<Student> students = studentDao.findStudent(firstName);
		System.out.println(students);
	}

	private void deleteStudentById() {
		int id=11;
		studentDao.deleteStudent(id);
	}

	private void findAllStudents() {
		List<Student> students= studentDao.findAll();
		for (Student student : students) {
			System.out.println(student);
		}
	}

	private void findStudent() {
		int id=181;
		Student student = studentDao.findStudent(id);
		System.out.println(student);
	}

	private void addNewStudent() 
	{
		
		Student student=new Student("virang","patel","vira@gmail.com");
		studentDao.saveStudent(student);
		System.out.println("student saved");
	}

}
