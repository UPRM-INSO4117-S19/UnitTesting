
import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CustomerTestWithMockWallet {

	private Customer c1;

	@BeforeEach
	public void setUp() {

		Wallet w = mock(Wallet.class);
		when(w.getOnes()).thenReturn(1);
		when(w.getFives()).thenReturn(1);
		when(w.getTens()).thenReturn(1);
		when(w.getTwenties()).thenReturn(1);
		when(w.getHundreds()).thenReturn(1);
		when(w.getAmount()).thenReturn(136);
		
		c1 = new Customer("123", "Bienve", "Velez", w);
	}
	
	@Test
	public void testCanAfford() {
		assertTrue(c1.canAfford(100), "Can afford 100");
		assertFalse(c1.canAfford(200),"Cannot afford 200");
	}


}
