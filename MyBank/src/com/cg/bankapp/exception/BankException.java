package com.cg.bankapp.exception;

public class BankException extends Exception {

	public BankException(String msg) {
		super(msg);
		System.err.println(msg);
	}

}
