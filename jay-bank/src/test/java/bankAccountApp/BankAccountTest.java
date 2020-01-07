package bankAccountApp;

import static org.junit.Assert.*;

import org.junit.Before;

import bankAccountApp.BankAccount;
import org.junit.Test;

public class BankAccountTest {
	String name = "John";
	char gender = 'm';
	int age = 22;
	int weight = 190;
	float height = 172;
	String hairColor = "brown";
	String eyeColor = "green";
	String email = "jufm@gmail.com";

	int ifloadaccManager = 0;
	int initMoneyAmount = 5000;
	int withdrawLimit = 700;
	String dateCreated = "05/21/2019";
	BankAccount bankAccount = null;
	String text = "C:\\Users\\jay4k\\Desktop\\stuff\\Bankaccountinfo\\BankAccountinfotext.text";
	// String text = "/Users/markkelly/BankAccountinfotext.text";
	Bank bank = null;
	Person accountHolder = null;

	// TODO add tests for remaining methods

	// TODO add test for remaining methods

	@Before
	public void setup() {
		// Create Person
		try {
			accountHolder = new Person(name, gender, age, weight, height, hairColor, eyeColor, email);
		} catch (Exception e) {
			System.out.print("Unexpected failure during test setup creating accountHolder");
			e.printStackTrace();
		}
		bank = new Bank();
		bankAccount = new BankAccount(initMoneyAmount, withdrawLimit, dateCreated, accountHolder);
	}

	@Test
	public void test_create_vert2_and_gets() throws Exception {
		// Given
		BankAccount acc1 = new BankAccount(initMoneyAmount, withdrawLimit, dateCreated, accountHolder);
		bank.addAccount(acc1, ifloadaccManager);

		// Then
		// TODO add remaining asserts
		assertEquals(5000, acc1.getBalance(), 0f);
	}
	
	@Test
	public void test_create_and_withdraw_money() throws Exception {
		//Given
		int withdrawamount = 200;
		bank.addAccount(bankAccount, ifloadaccManager);
		
		//Then
		assertEquals(5000, bankAccount.getBalance(), 0f);
		bankAccount.withdrawMoney(withdrawamount);
		assertEquals(4800, bankAccount.getBalance(), 0f);
	}

	@Test
	public void test_create_and_deposit_money() {
		//Given
		int depositamount = 200;
		bank.addAccount(bankAccount, ifloadaccManager);
		
		//Then
		assertEquals(5000, bankAccount.getBalance(), 0f);
		bankAccount.depositMoney(depositamount);
		assertEquals(5200, bankAccount.getBalance(), 0f);
	}

	@Test
	public void test_create_and_setWithdrawLimit() {
		//Given
		int withdrawamount = 800;
		bank.addAccount(bankAccount, ifloadaccManager);
		
		//Then
		assertEquals(700, bankAccount.getWithdrawLimit(), 0f);
		bankAccount.setWithdrawLimit(820);
		assertEquals(5000, bankAccount.getBalance(), 0f);
		bankAccount.withdrawMoney(withdrawamount);
		assertEquals(4200, bankAccount.getBalance(), 0f);
	}



}
