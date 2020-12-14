package com.cg.bankapp.service;

import com.cg.bankapp.bean.Customer;
import com.cg.bankapp.dao.BankDao;

public class BankService implements IBankService {
	BankDao bankDaoObj = new BankDao();

	public void createAccount(Customer customerObj) {
		bankDaoObj.createAccount(customerObj);
	}

	public String checkBalance(int accountNo) {
		return bankDaoObj.checkBalance(accountNo);
	}

	@Override
	public String deposit(int accountNo, long depositAmount) {
		return bankDaoObj.deposit(accountNo, depositAmount);
	}

	@Override
	public String withdrawl(int accountNo, long withdrawlAmount) {
		return bankDaoObj.deposit(accountNo, withdrawlAmount);
	}

}
