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
	int withdrawLimit = 760;
	String dateCreated = "05/21/2019";
	BankAccount bankAccount = new BankAccount();
	String text = "C:\\Users\\jay4k\\Desktop\\stuff\\Bankaccountinfo\\BankAccountinfotext.text";
	// String text = "/Users/markkelly/BankAccountinfotext.text";
	Bank bank = null;
	Person accountHolder = null;

	//TODO add tests for remaining methods
	
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
	}

	@Test
	public void test_create_ver2_and_gets() throws Exception {
		// Given
		BankAccount acc1 = new BankAccount(initMoneyAmount, withdrawLimit, dateCreated, accountHolder);
		bank.addAccount(acc1, ifloadaccManager);

		// Then
		//TODO add remaining asserts
		assertEquals(5000, acc1.getBalance(), 0f);
	}

}
