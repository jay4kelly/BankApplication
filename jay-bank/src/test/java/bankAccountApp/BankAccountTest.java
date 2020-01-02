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
	public void test() throws Exception {
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
}
