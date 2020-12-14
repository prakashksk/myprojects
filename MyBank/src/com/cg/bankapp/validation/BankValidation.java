package com.cg.bankapp.validation;

import com.cg.bankapp.dao.BankDao;
import com.cg.bankapp.exception.BankException;

public class BankValidation {

	public static Boolean checkName(String name) throws BankException {
		String regexName = "\\p{Upper}(\\p{Lower}+\\s?)";
		String patternName = "(" + regexName + "){2,3}";
		System.out.println("The name is: " + name);
		try {
			if (name.matches(patternName)) {
				return true;
			} else {
				throw new BankException("Invalid name");
			}
		} catch (BankException exception) {
			System.err.println(exception);
			return false;

		}
	}

	public static Boolean mobileNumberCheck(String mobileNumber) throws BankException {
		String regex = "(0/91)?[7-9][0-9]{9}";
		System.out.println("The phone number is: " + mobileNumber);

		try {
			if (mobileNumber.matches(regex))
				return mobileNumber.matches(regex);
			else

			{
				throw new BankException("Invalid mobile number");

			}
		} catch (BankException exception) {
			System.err.println(exception);
			return false;
		}

	}

	public static boolean maildIdCheck(String email) throws BankException {
		String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
		try {
			if (email.matches(regex))
				return email.matches(regex);
			else {
				throw new BankException("Invalid E-mail Id");
			}
		} catch (BankException exception) {
			System.err.println(exception);
			return false;
		}
	}

	public static Boolean accountCheck(int accountNo) {
		BankDao bankDaoObj = new BankDao();
		return bankDaoObj.accountCheck(accountNo);

	}
}