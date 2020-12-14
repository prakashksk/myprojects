package com.cg.bankapp.Client;

import java.util.Scanner;

import com.cg.bankapp.bean.Customer;
import com.cg.bankapp.exception.BankException;
import com.cg.bankapp.service.BankService;
import com.cg.bankapp.validation.BankValidation;

public class Client {
	public static void main(String[] args) {
		Scanner scannerObj = new Scanner(System.in);
		BankService bankServiceObj = new BankService();

		while (true) {
			System.out.println("Welcome to My Bank");
			System.out.println("Choose one option ");

			System.out.println("1-> Open new Account");
			System.out.println("2-> Check Balance");
			System.out.println("3-> Deposit Amount");
			System.out.println("4-> Money withdrawl");
			System.out.println("5-> Transfer Amount to another Account");
			System.out.println("6-> Print Transactions");
			System.out.println("7-> Exit");

			int option = scannerObj.nextInt();
			switch (option) {

			case 1:

				System.out.println("Enter Full name");
				String name = scannerObj.next();
				try {
					while (!BankValidation.checkName(name)) {
						System.out.println("Please Enter your name ");
						name = scannerObj.next();
						name += scannerObj.nextLine();
					}
				} catch (BankException e) {
					// TODO Auto-generated catch block
					System.err.println(e);
					e.printStackTrace();
				}
				System.out.println("Enter Date of birth (DD/MM/YYYY)");
				String dob = scannerObj.next();

				System.out.println("Enter Mobile number");
				String mobileNumber = scannerObj.next();
				try {
					while (!BankValidation.mobileNumberCheck(mobileNumber)) {
						System.out.println("Please Enter valid Mobile number");
						mobileNumber = scannerObj.next();
						mobileNumber += scannerObj.nextLine();

					}
				} catch (BankException e) {
					System.err.println(e);
					e.printStackTrace();
				}

				System.out.println("Enter  mailId");
				String mailId = scannerObj.next();
				try {
					while (!BankValidation.maildIdCheck(mailId)) {
						System.out.println("Please enter valid E-maild");
						mailId = scannerObj.next();
						mailId = scannerObj.nextLine();
					}
				} catch (BankException e) {
					System.err.println(e);
					e.printStackTrace();
				}

				System.out.println("Enter amount to be deposited");
				int amount = scannerObj.nextInt();
				System.out.println("Set 4 digit pin");
				int pin = scannerObj.nextInt();

				long accountNo = (int) ((Math.random()) * 945645076);

				System.out.println();
				Customer customerObj = new Customer(accountNo, name, dob, mobileNumber, mailId, pin, amount);

				bankServiceObj.createAccount(customerObj);
				System.out.println("Account created successfully &  your Account number is " + accountNo);
				System.out.println();
				System.out.println("   Any queries contact 9492665689");
				break;

			case 2:

				System.out.println("Please enter your Account number ");
				int accountNo1 = scannerObj.nextInt();
//				while (!BankValidation.accountCheck(accountNo1)) {
//					System.out.println("Enter valid Accountnumber");
//					accountNo1 = scannerObj.nextInt();
//				}
				String message = bankServiceObj.checkBalance(accountNo1);
				System.out.println(message);

				break;

			case 3:

				System.out.println("Please enter your account number ");
				int accountNo2 = scannerObj.nextInt();
				while (!BankValidation.accountCheck(accountNo2)) {
					System.out.println("Enter valid Accountnumber : ");
					accountNo2 = scannerObj.nextInt();

				}
				System.out.println("Enter amount to be deposited ");
				int amount1 = scannerObj.nextInt();
				bankServiceObj.deposit(accountNo2, amount1);

			case 4:

				System.out.println("Please Enter your Account number ");
				int accountNo3 = scannerObj.nextInt();
				while (!BankValidation.accountCheck(accountNo3)) {
					System.out.println("Enter valid account Number ");
					accountNo3 = scannerObj.nextInt();
				}
				System.out.println("Enter amount to be withdrawn : ");
				int withdrawlAmount = scannerObj.nextInt();
				bankServiceObj.withdrawl(accountNo3, withdrawlAmount);
			}
		}

	}
}