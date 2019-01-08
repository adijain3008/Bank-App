package com.mindtree.bank.entity;

public class Customer {

	private Bank bank;
	private long accountNumber;
	private String name;
	private String gender;
	private int balance;
	private String location;
	private String panID;
	private String dateOfBirth;
	private int age;
	private long phoneNumber;
	
	public Customer() {
		super();
	}

	public Bank getBank() {
		return bank;
	}

	public void setBank(Bank bank) {
		this.bank = bank;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public long getAccountNumber() {
		return accountNumber;
	}

	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getPanID() {
		return panID;
	}

	public void setPanID(String panID) {
		this.panID = panID;
	}

	public String getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(String dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public long getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	@Override
	public String toString() {
		return "accountNumber=" + accountNumber + ", name=" + name + ", gender=" + gender
				+ ", balance=" + balance + ", location=" + location + ", panID=" + panID + ", dateOfBirth="
				+ dateOfBirth + ", age=" + age + ", phoneNumber=" + phoneNumber + ", bankName=" + bank.getName();
	}
	
	
	
}
