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

	int assignAccountNumber = 0;
	int accountNumberExists = 1;
	int initMoneyAmount = 5000;
	int withdrawLimit = 700;
	String dateCreated = "05/21/2019";
	BankAccount bankAccount = null;
	String text = "C:\\Users\\jay4k\\Desktop\\stuff\\Bankaccountinfo\\BankAccountinfotext.text";
	// String text = "/Users/markkelly/BankAccountinfotext.text";
	Bank bank = null;
	Person accountHolder = null;
	String serializedPerson = null;

	@Before
	public void setup() {
		// Create Person
		try {
			accountHolder = new Person(name, gender, age, weight, height, hairColor, eyeColor, email);
			serializedPerson = name + Person.DELIM + gender + Person.DELIM + age + Person.DELIM + height + Person.DELIM
					+ weight + Person.DELIM + hairColor + Person.DELIM + eyeColor + Person.DELIM + email;
		} catch (Exception e) {
			System.out.print("Unexpected failure during test setup creating accountHolder");
			e.printStackTrace();
		}
		bank = new Bank();
		bankAccount = new BankAccount(initMoneyAmount, withdrawLimit, dateCreated, accountHolder);
	}

	@Test 
	public void test_create_vert1_and_gets() throws Exception {
		BankAccount acc1 = new BankAccount();
		bank.addAccount(acc1, assignAccountNumber);

		// Then
		assertEquals("balance error",0, acc1.getBalance(), 0f);
		assertEquals("withdrawal error",0, acc1.getWithdrawLimit(),0f);
		assertEquals("amount withdrawn error",0,acc1.getAmountWithdrawn(),0f);
		assertEquals("date created error","", acc1.getDateCreated());
		assertEquals("account holder error",null, acc1.getAccountHolder());
		assertEquals("account error",1,acc1.getAccountNumber());
	}
	
	@Test
	public void test_create_vert2_and_gets() throws Exception {
		// Given
		BankAccount acc1 = new BankAccount(initMoneyAmount, withdrawLimit, dateCreated, accountHolder);
		bank.addAccount(acc1, assignAccountNumber);

		// Then
		assertEquals(5000, acc1.getBalance(), 0f);
		assertEquals(700, acc1.getWithdrawLimit(),0f);
		assertEquals("05/21/2019", acc1.getDateCreated());
		assertEquals(accountHolder, acc1.getAccountHolder());
		assertSame(accountHolder,acc1.getAccountHolder());
		assertEquals(1,acc1.getAccountNumber());
	}
		

	@Test
	public void test_create_vert3_and_gets() throws Exception {
		// Given
		BankAccount acc1 = new BankAccount(1000,initMoneyAmount, withdrawLimit, dateCreated, serializedPerson);
		bank.addAccount(acc1, accountNumberExists);

		// Then
		assertEquals(5000, acc1.getBalance(), 0f);
		assertEquals(700, acc1.getWithdrawLimit(),0f);
		assertEquals("05/21/2019", acc1.getDateCreated());
		assertNotNull(acc1.getAccountHolder());	
		//TODO getAccountHolder(BankAccount)
	assertEquals(0,acc1.getInitMoneyAmount(),0f);
	assertEquals(700, acc1.getWithdrawLimit(),0f);
	Person person = acc1.getAccountHolder();
		assertEquals(name, person.getName());
		assertEquals(gender, person.getGender());
		assertEquals(age, person.getAge());
		assertEquals(height, person.getHeight(), 0);
		assertEquals(weight, person.getWeight(), 0);
		assertEquals(hairColor, person.getHairColor());
		assertEquals(eyeColor, person.getEyeColor());	
		assertEquals(email, person.getEmail());		
		assertEquals(1000,acc1.getAccountNumber());
	}
	
	//TODO convertToText	
	@Test
	public void test_convert_to_text() {
		
	}

	@Test
	public void test_create_and_deposit_money() {
		//Given
		int depositamount = 200;
		bank.addAccount(bankAccount, assignAccountNumber);
		
		//Then
		assertEquals(5000, bankAccount.getBalance(), 0f);
		bankAccount.depositMoney(depositamount);
		assertEquals(5200, bankAccount.getBalance(), 0f);
	}

	
	
	@Test
	public void test_create_and_withdraw_money() throws Exception {
		//Given
		int withdrawamount = 200;
		bank.addAccount(bankAccount, assignAccountNumber);
		
		//Then
		assertEquals(5000, bankAccount.getBalance(), 0f);
		bankAccount.withdrawMoney(withdrawamount);
		assertEquals(200, bankAccount.getAmountWithdrawn(),0f);
		assertEquals(4800, bankAccount.getBalance(), 0f);
		
	}
	
	
	
	@Test
	public void test_create_and_setWithdrawLimit_failure1() {
		//Given
		int withdrawamount = 800;
		bank.addAccount(bankAccount, assignAccountNumber);
		
		//Then
		bankAccount.withdrawMoney(withdrawamount);
		assertEquals(5000, bankAccount.getBalance(), 0f);

		assertEquals(700, bankAccount.getWithdrawLimit(), 0f);
		bankAccount.setWithdrawLimit(820);
		
		assertEquals(5000, bankAccount.getBalance(), 0f);
		bankAccount.withdrawMoney(withdrawamount);
		assertEquals(4200, bankAccount.getBalance(), 0f);
		//TODO trigger a failure with withdrawal (false) and check balance
	}

	@Test
	public void test_create_and_setWithdrawLimit_failure2() {
		//Given
		int withdrawamount = 800;
		bank.addAccount(bankAccount, assignAccountNumber);
		
		//Then
		assertEquals(700, bankAccount.getWithdrawLimit(), 0f);
		bankAccount.setWithdrawLimit(820);
		assertEquals(5000, bankAccount.getBalance(), 0f);
		bankAccount.withdrawMoney(withdrawamount);
		assertEquals(4200, bankAccount.getBalance(), 0f);
		bankAccount.withdrawMoney(withdrawamount);
		assertEquals(4200, bankAccount.getBalance(), 0f);
		//TODO trigger a failure with withdrawal that includes amountwithdrawn (false) and check balance
	}
	
	@Test
	public void test_toString() {
		
		//System.out.println(bankAccount.convertToText(bankAccount));
		System.out.println(bankAccount.toString());
		assertEquals("Your Account number is 0 Your Balance is: 5000.0 Date account created is: 05/21/2019 Withdraw limit is: 700.0 Your account holder info is: John\r\n" + 
				"m\r\n" + 
				"22\r\n" + 
				"172.0\r\n" + 
				"190.0\r\n" + 
				"brown\r\n" + 
				"green\r\n" + 
				"jufm@gmail.com",bankAccount.toString());
	}
	//TODO toString
	
}
