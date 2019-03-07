import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class CustomerTest {


	private Customer c1;
	
	@BeforeEach
	public void setUp() {
		Wallet w = new Wallet(1,1,1,1,1);
		c1 = new Customer("123", "Bienve", "Velez", w);
	}
	
	@Test
	public void testGetters() {
		assertEquals("123", c1.getId());
		assertEquals("Bienve", c1.getName());
		assertEquals("Velez", c1.getLastName());
		Wallet w = new Wallet(1,1,1,1,1);
		assertEquals(w, c1.getWallet());
	}
	
	@Test
	public void testCanAfford() {
		assertTrue(c1.canAfford(100));
		assertFalse(c1.canAfford(200));
	}
	
	@Test
	public void testEarn() {
		c1.earn(50);
		assertEquals(c1.getWallet().getAmount(),186);
	}
	
}
