package bankAccountApp;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.fail;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.Test;

public class ACHServiceTest {

	int account = 1000;
	int routingNumber = 123456;
	int destinationBank = 789;
	int toAccount = 2000;
	int badDestinationBank = 100;

	@Test
	public void testRegisterAccount() {
		boolean result = false;
		// Given
		ACHServiceImpl service = mock(ACHServiceImpl.class);

		// When
		// Successful register
		when(service.registerAccount(account, routingNumber, destinationBank, toAccount)).thenReturn(true);
		// Unsuccessful register
		when(service.registerAccount(account, routingNumber, badDestinationBank, toAccount)).thenReturn(false);

		// Then
		result = service.registerAccount(account, routingNumber, destinationBank, toAccount);
		assertThat("failed to register account", result, equalTo(true));
		result = service.registerAccount(account, routingNumber, badDestinationBank, toAccount);
		assertThat("did not fail register as expected", result, equalTo(false));
	}

	@Test
	public void testTransferAmount() {
		// TODO implement
		
		//Given
		ACHServiceImpl service = mock(ACHServiceImpl.class);
		float amount = 300;
		
		// When
		//TODO add when conditions for true and false
		
		// Then
		boolean result = service.transferAmount(account, routingNumber, destinationBank, toAccount,
				amount);
		assertThat("failed to transfer amount",result, equalTo(true));
		//TODO add false
	}

}
