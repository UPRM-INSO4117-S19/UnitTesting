import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class WalletTest {
	
	/*
	 *  This test class assumes that the following are manually
	 *  tested and thus free of defects:
	 *  + Wallet(int ones, int fives, int tens, int twenties, int hundreds)
	 *  + getters
	 *  + setters
	 *  
	 */
	
	/* Test equals */
	
	/* Two clones should be equals */
	@Test
	public void testTwoClonesAreEqual() {
		Wallet w1 = new Wallet(0,1,2,3,4);
		Wallet w2 = new Wallet(0,1,2,3,4);
		assertTrue(w1.equals(w2));
	}
	
	/* equals is transitive */
	
	/* An object must be equals to itself */
	
	/* Two objects with at least one different property are not equals */
	
	

	@Test
	void test() {
		fail("Not yet implemented");
	}

}
