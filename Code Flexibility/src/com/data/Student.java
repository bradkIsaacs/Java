package com.data;

public class Student {
	private String studentName;
	private int studentID;
	private double studentGpa;
	//constructor
	public Student(String studentName, int studentID, double studentGpa) {
		super();
		this.studentName = studentName;
		this.studentID = studentID;
		this.studentGpa = studentGpa;
	}
	//Getters and Setters
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public int getStudentID() {
		return studentID;
	}
	public void setStudentID(int studentID) {
		this.studentID = studentID;
	}
	public double getStudentGpa() {
		return studentGpa;
	}
	public void setStudentGpa(double studentGpa) {
		this.studentGpa = studentGpa;
	}
}
