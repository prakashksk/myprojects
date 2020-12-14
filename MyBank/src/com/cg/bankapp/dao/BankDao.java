package com.cg.bankapp.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.cg.bankapp.bean.Customer;
import com.cg.bankapp.exception.BankException;

public class BankDao implements IBankDao {

	Connection conn;
	Customer customerObj;

	public BankDao() {

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl", "hr", "India123");

			System.out.println("yes connected");
		} catch (ClassNotFoundException | SQLException e) {

			e.printStackTrace();
		}

	}

	@Override
	public void createAccount(Customer customerObj) {
		try {
			PreparedStatement preparedStatement = conn.prepareStatement("insert into Customer values(?,?,?,?,?,?,?)");
			preparedStatement.setLong(1, customerObj.getAccountNo());

			preparedStatement.setString(2, customerObj.getName());
			preparedStatement.setString(3, customerObj.getDob());
			preparedStatement.setString(4, customerObj.getMobileNumber());
			preparedStatement.setString(5, customerObj.getMailId());
			preparedStatement.setInt(6, customerObj.getPin());
			preparedStatement.setLong(7, customerObj.getBalance());
			preparedStatement.execute();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public String checkBalance(int accountNo) {
		try {
			PreparedStatement preparedStatement = conn
					.prepareStatement("select balance from Customer where AccountNo=?");
			preparedStatement.setLong(1, accountNo);
			ResultSet resultSetObj = preparedStatement.executeQuery();
			// resultSetObj.next();
			while (resultSetObj.next()) {
				// System.out.println(rs.getString(1));
				long balance = resultSetObj.getLong("balance");
				return "Balance in your Account " + "with Account number" + accountNo + " is " + balance;

			}

			long balance = resultSetObj.getLong("balance");
			return "Balance in your Account " + "with Account number" + accountNo + " is " + balance;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "Error";
		}
	}

	public Boolean accountCheck(int accountNo) {
		try {
			PreparedStatement preparedStatement = conn.prepareStatement("Select * from Customer where accountNo=?");
			preparedStatement.setLong(1, accountNo);
			ResultSet resultSetObj = preparedStatement.executeQuery();
			if (resultSetObj.next())
				return true;
			else

				return false;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	@Override
	public String deposit(int accountNo, long depositAmount) {
		try {
			PreparedStatement preparedStatement = conn
					.prepareStatement("UPDATE Customer SET balance =balance+? WHERE accountNo=?");
			preparedStatement.setLong(1, depositAmount);
			preparedStatement.setInt(2, accountNo);
			preparedStatement.executeUpdate();

			ResultSet resultSetObj = preparedStatement.executeQuery();
			resultSetObj.next();
			long balance = resultSetObj.getLong("balance");
			return "updated Balance in your Account " + "with Account number" + accountNo + " is " + balance;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public String withdrawl(int accountNo, long withdrawlAmount) {

		try {
			PreparedStatement preparedStatement = conn
					.prepareStatement("UPDATE Customer SET balance =balance-? WHERE accountNo=?");
			preparedStatement.setLong(1, withdrawlAmount);
			preparedStatement.setInt(2, accountNo);
			preparedStatement.executeUpdate();

			ResultSet resultSetObj = preparedStatement.executeQuery();
			resultSetObj.next();
			long balance = resultSetObj.getLong("balance");
			return "withdrwal amount : " + withdrawlAmount + "updated Balance in your account : " + balance;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
