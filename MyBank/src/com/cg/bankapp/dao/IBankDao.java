package com.cg.bankapp.dao;

import com.cg.bankapp.bean.Customer;

public interface IBankDao {
	public void createAccount(Customer customerObj);

	public String checkBalance(int accountNo);

	public Boolean accountCheck(int accountNo);

	public String deposit(int accountNo, long depositAmount);
	
	public String withdrawl(int accountNo, long withdrwalAmount);

}
