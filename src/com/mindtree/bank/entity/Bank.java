package com.mindtree.bank.entity;

public class Bank {

	private int bankCode;
	private String name;
	private String ifsc;
	private String branch;

	public Bank() {
		super();
	}

	public int getBankCode() {
		return bankCode;
	}

	public void setBankCode(int bankCode) {
		this.bankCode = bankCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIfsc() {
		return ifsc;
	}

	public void setIfsc(String ifsc) {
		this.ifsc = ifsc;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

	@Override
	public String toString() {
		return "bankCode=" + bankCode + ", name=" + name + ", ifsc=" + ifsc + ", branch=" + branch;
	}

}
