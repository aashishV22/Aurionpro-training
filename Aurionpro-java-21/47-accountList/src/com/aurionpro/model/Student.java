package com.aurionpro.model;

public class Student {
	private int studentId;
	private String studentName;
	private double percentage;
	
	public Student(int studentId, String studentName, double percentage) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.percentage = percentage;
	}
	
	public Student() {
		
	}
	
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public double getPercentage() {
		return percentage;
	}
	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}
	@Override
	public String toString() {
		return "Student [studentId=" + studentId + ", studentName=" + studentName + ", percentage=" + percentage + "]";
	}
	
	
	
}
