package com.cg.bankapp.service;

import com.cg.bankapp.bean.Customer;

public interface IBankService {
	public void createAccount(Customer customerObj);

	public String checkBalance(int accountNo);

	public String deposit(int accountNo, long depositAmount);

	public String withdrawl(int accountNo, long withdrawlAmount);

}
