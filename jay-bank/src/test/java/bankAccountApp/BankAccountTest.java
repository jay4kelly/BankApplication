package bankAccountApp;

import static org.junit.Assert.*;
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
	BankAccount bankAccountManager = new BankAccount();
	String text = "C:\\Users\\jay4k\\Desktop\\stuff\\Bankaccountinfo\\BankAccountinfotext.text";
	//String text = "/Users/markkelly/BankAccountinfotext.text";
	Bank accManager = new Bank();

	@Test
	public void testCreateAccount() throws Exception {
		Person accountHolder = new Person(name, gender, age, weight, height, hairColor, eyeColor, email);
		BankAccount acc1 = new BankAccount(initMoneyAmount, withdrawLimit, dateCreated, accountHolder);
		acc1.initilizeAccount(initMoneyAmount);
		accManager.setAccountsLoaded(bankAccountManager.loadFromText(text));

		if (accManager.getAccountsLoaded() > 0) {
			ifloadaccManager = 2;
		} else if (accManager.getAccountsLoaded() == 0) {
			ifloadaccManager = 0;
		}
		accManager.addAccount(acc1, ifloadaccManager);

		assertEquals(5000, acc1.getBalance(), 0f);
	}
	
	@Test
	public void testCreateAccount_DeleteAccount() throws Exception {
		Person accountHolder = new Person(name, gender, age, weight, height, hairColor, eyeColor, email);
		BankAccount acc1 = new BankAccount(initMoneyAmount, withdrawLimit, dateCreated, accountHolder);
		acc1.initilizeAccount(initMoneyAmount);
		accManager.setAccountsLoaded(bankAccountManager.loadFromText(text));

		if (accManager.getAccountsLoaded() > 0) {
			ifloadaccManager = 2;
		} else if (accManager.getAccountsLoaded() == 0) {
			ifloadaccManager = 0;
		}
		accManager.addAccount(acc1, ifloadaccManager);
		System.out.println("Your account number is " + acc1.getAccountNumber());
		//assertEquals(5000, acc1.getBalance(), 0f);
		//assertEquals("john", acc1.getAccountHolderName(acc1), 0f);

		accManager.deleteAccount(acc1.getAccountNumber());
		//assertEquals("john", acc1.getAccountHolderName(acc1), 0f);
		assertEquals(5000, acc1.getBalance(), 0f);

	}
	@Test
	public void testCreateAccount_GetAverageBalance() throws Exception {
		Person accountHolder = new Person(name, gender, age, weight, height, hairColor, eyeColor, email);
		BankAccount acc1 = new BankAccount(initMoneyAmount, withdrawLimit, dateCreated, accountHolder);
		acc1.initilizeAccount(initMoneyAmount);
		accManager.setAccountsLoaded(bankAccountManager.loadFromText(text));

		if (accManager.getAccountsLoaded() > 0) {
			ifloadaccManager = 2;
		} else if (accManager.getAccountsLoaded() == 0) {
			ifloadaccManager = 0;
		}
		accManager.addAccount(acc1, ifloadaccManager);
		System.out.println("Your account number is " + acc1.getAccountNumber());
		assertEquals(1,acc1.getAccountNumber());
		//assertEquals(5000, acc1.getBalance(), 0f);
		//assertEquals("john", acc1.getAccountHolderName(acc1), 0f);
		accManager.addAccount(acc1, ifloadaccManager);
		System.out.println("Your account number is " + acc1.getAccountNumber());
		
		assertEquals(5000,accManager.getAverageBalance(),0f);

	}
	@Test
	public void testCreateAccount_GetMaximumBalance() throws Exception {
		Person accountHolder = new Person(name, gender, age, weight, height, hairColor, eyeColor, email);
		BankAccount acc1 = new BankAccount(initMoneyAmount, withdrawLimit, dateCreated, accountHolder);
		acc1.initilizeAccount(initMoneyAmount);
		accManager.setAccountsLoaded(bankAccountManager.loadFromText(text));

		if (accManager.getAccountsLoaded() > 0) {
			ifloadaccManager = 2;
		} else if (accManager.getAccountsLoaded() == 0) {
			ifloadaccManager = 0;
		}
		BankAccount acc2 = new BankAccount(1000, withdrawLimit, dateCreated, accountHolder);
		accManager.addAccount(acc2, ifloadaccManager);
		System.out.println("Your account number is " + acc1.getAccountNumber());
		accManager.addAccount(acc1, ifloadaccManager);
		System.out.println("Your account number is " + acc1.getAccountNumber());
		assertEquals(5000,accManager.getMaximumBalance(),0f);
	}
	@Test
	public void testCreateAccount_GetMinimumBalance() throws Exception {
		Person accountHolder = new Person(name, gender, age, weight, height, hairColor, eyeColor, email);
		BankAccount acc1 = new BankAccount(initMoneyAmount, withdrawLimit, dateCreated, accountHolder);
		acc1.initilizeAccount(initMoneyAmount);
		accManager.setAccountsLoaded(bankAccountManager.loadFromText(text));

		if (accManager.getAccountsLoaded() > 0) {
			ifloadaccManager = 2;
		} else if (accManager.getAccountsLoaded() == 0) {
			ifloadaccManager = 0;
		}
		BankAccount acc2 = new BankAccount(1000, withdrawLimit, dateCreated, accountHolder);
		accManager.addAccount(acc2, ifloadaccManager);
		System.out.println("Your account number is " + acc1.getAccountNumber());
		accManager.addAccount(acc1, ifloadaccManager);
		System.out.println("Your account number is " + acc1.getAccountNumber());
		assertEquals(5000,accManager.getMinimumBalance(),0f);
	}
	
}
