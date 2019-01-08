package com.mindtree.bank.entity;

public class Employee {

	private Bank bank;
	private int empid;
	private String name;
	private double salary;
	private String department;
	private String designation;
	private String gender;
	private String dateOfJoining;
	
	public Employee() {
		super();
	}

	public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}

	public int getEmpid() {
		return empid;
	}

	public void setEmpid(int empid) {
		this.empid = empid;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getDateOfJoining() {
		return dateOfJoining;
	}

	public void setDateOfJoining(String dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}

	@Override
	public String toString() {
		return "empid=" + empid + ", name=" + name + ", salary=" + salary + ", department="
				+ department + ", designation=" + designation + ", gender=" + gender + ", dateOfJoining="
				+ dateOfJoining + ", bankName=" + bank.getName();
	}
	
	
}
