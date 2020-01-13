package bankAccountApp;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;

import bankAccountApp.BankAccount;

import org.junit.Before;
import org.junit.Test;

public class BankTest {
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

	//TODO add test for remaining methods
	
	
	//TODO add Bank constructor test. Check for no accounts
	
	//TODO test add account - check that account is added
	
	//TODO convertToText method
	
	//
	
	@Before
	public void setup() {
		// Create Person
		try {
			accountHolder = new Person(name, gender, age, weight, height, hairColor, eyeColor, email);
		} catch (Exception e) {
			System.out.print("Unexpected failure during test setup");
			e.printStackTrace();
		}
		bank = new Bank();
	}

	@Test
	public void testCreateAccount_DeleteAccount() throws Exception {
		//Given
		BankAccount acc1 = new BankAccount(initMoneyAmount, withdrawLimit, dateCreated, accountHolder);
		bank.addAccount(acc1, ifloadaccManager);
		int accountNumber = acc1.getAccountNumber();
		bank.deleteAccount(acc1.getAccountNumber());
		
		//Then
		assertNull("Account was not deleted:" + accountNumber, bank.findAccount(accountNumber));
	}

	//TODO findAccount method
	@Test
	public void testFindAccount()
	{
		
	}
	
	@Test
	public void testGetAccounts() throws Exception {
		//Given
		BankAccount acc1 = new BankAccount(initMoneyAmount, withdrawLimit, dateCreated, accountHolder);
		BankAccount acc2 = new BankAccount(1000, withdrawLimit, dateCreated, accountHolder);
		bank.addAccount(acc2, ifloadaccManager);
		bank.addAccount(acc1, ifloadaccManager);
		
		//Then
		ArrayList<BankAccount> accounts = bank.getAccounts();	
		//TODO add assert for number accounts
	}
	
	//TODO getAccountsLoaded 
	@Test
	public void testgetAccountsLoaded() {
		
	}
	
	
	@Test
	public void testCreateAccount_GetAverageBalance() throws Exception {
		//Given
		int acct1Amount = 5000;
		int acct2Amount = 10000;
		BankAccount acc1 = new BankAccount(acct1Amount, withdrawLimit, dateCreated, accountHolder);
		BankAccount acc2 = new BankAccount(acct2Amount, withdrawLimit, dateCreated, accountHolder);
		bank.addAccount(acc1, ifloadaccManager);
		bank.addAccount(acc2, ifloadaccManager);

		//Then
		assertEquals(7500, bank.getAverageBalance(), 0f);
	}

	@Test
	public void testCreateAccount_GetMaximumBalance() throws Exception {
		//Given
		int acct1Amount = 5000;
		int acct2Amount = 10000;		
		BankAccount acc1 = new BankAccount(acct1Amount, withdrawLimit, dateCreated, accountHolder);
		BankAccount acc2 = new BankAccount(acct2Amount, withdrawLimit, dateCreated, accountHolder);
		bank.addAccount(acc2, ifloadaccManager);
		bank.addAccount(acc1, ifloadaccManager);
		
		//Then
		assertEquals(10000, bank.getMaximumBalance(), 0f);
	}

	@Test
	public void testCreateAccount_GetMinimumBalance() throws Exception {
		//Given
		BankAccount acc1 = new BankAccount(initMoneyAmount, withdrawLimit, dateCreated, accountHolder);
		BankAccount acc2 = new BankAccount(1000, withdrawLimit, dateCreated, accountHolder);
		bank.addAccount(acc2, ifloadaccManager);
		bank.addAccount(acc1, ifloadaccManager);
		
		//Then
		assertEquals(1000, bank.getMinimumBalance(), 0f);
	}

	
}
