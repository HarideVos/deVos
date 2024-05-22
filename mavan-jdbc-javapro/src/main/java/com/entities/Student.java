package com.entities;

public class Student {
	private int id;
	private String name;
	private double gpa;
	private String address;
	private String gradde;

	public Student(int id, String name, double gpa, String address, String gradde) {
		super();
		this.id = id;
		this.name = name;
		this.gpa = gpa;
		this.address = address;
		this.gradde = gradde;
	}
	
	public Student(String name, double gpa, String address, String gradde) {
		super();
		this.name = name;
		this.gpa = gpa;
		this.address = address;
		this.gradde = gradde;
	}

	public Student() {
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getGpa() {
		return gpa;
	}
	public void setGpa(double gpa) {
		this.gpa = gpa;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getGradde() {
		return gradde;
	}
	public void setGrade(String gradde) {
		this.gradde = gradde;
	}
	
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", gpa=" + gpa + ", address=" + address + ", grade=" + gradde
				+ "]";
	}
	
	
}
