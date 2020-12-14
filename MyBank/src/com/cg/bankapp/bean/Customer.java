package com.cg.bankapp.bean;

public class Customer {

	private long accountNo;
	private String name;
	private String dob;
	private String mobileNumber;
	private String mailId;
	private int pin;
	private long balance;

	public String getName() {
		return name;
	}

	public long getAccountNo() {
		return accountNo;
	}

	public void setAccountNo(long accountNo) {
		this.accountNo = accountNo;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Customer(long accountNo, String name, String dob, String mobileNumber, String mailId, int pin, int balance) {
		super();
		this.name = name;
		this.dob = dob;
		this.mobileNumber = mobileNumber;
		this.mailId = mailId;
		this.pin = pin;
		this.balance = balance;
	}

	public String getDob() {
		return dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getMobileNumber() {
		return mobileNumber;
	}

	public void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	public String getMailId() {
		return mailId;
	}

	public void setMailId(String mailId) {
		this.mailId = mailId;
	}

	public int getPin() {
		return pin;
	}

	public void setPin(int pin) {
		this.pin = pin;
	}

	public long getBalance() {
		return balance;
	}

	public void setBalance(long balance) {
		this.balance = balance;
	}

}