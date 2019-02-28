import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Random;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class WalletTest {

	/*
	 *  This test class assumes that the following are manually
	 *  tested and thus free of defects:
	 *  + Wallet(int ones, int fives, int tens, int twenties, int hundreds)
	 *  + getters
	 *  + setters
	 *  
	 */

	/**
	 * 
	 *  Test equals 
	 *  
	 */

	/* Two clones should be equals */
	@Test
	public void testTwoClonesAreEqual() {
		Wallet w1 = new Wallet(0,1,2,3,4);
		Wallet w2 = new Wallet(0,1,2,3,4);
		assertTrue(w1.equals(w2));
	}
	
	/* Returns false with non-wallet parameter */
	@Test
	public void testNonWalletNotEquals() {
		Object o = new Object();
		Wallet w = new Wallet(1,1,1,1,1);
		assertFalse(w.equals(o));
	}
	
	/* equals is reflexive */
	@Test
	public void testObjectEqualToItself() {
		Wallet w1 = new Wallet(0,1,2,3,4);
		assertTrue(w1.equals(w1));
	}

	/* equals is transitive */
	@Test
	public void testEqualsTransitive() {
		Wallet w1 = new Wallet(0,1,2,3,4);
		Wallet w2 = new Wallet(0,1,2,3,4);
		Wallet w3 = new Wallet(0,1,2,3,4);
		assertTrue(w1.equals(w3));
	}

	/* Two objects with at least one different property are not equals */
	@Test
	public void testEqualsFalseWhenDifferent() {
		int[] params = new int[]{0, 0, 0, 0, 0};
		Wallet w1 = new 
				Wallet(
						params[0], 
						params[1], 
						params[2], 
						params[3],
						params[4]);
		for(int i=0; i<5; i++) {
			params[i] = 1;
			Wallet w2 = new 
					Wallet(
							params[0], 
							params[1], 
							params[2], 
							params[3],
							params[4]);
			assertFalse(w1.equals(w2));
			params[i] = 0;
		}
	}

	/**
	 * 
	 * Test Copy Constructor
	 * 
	 */
	
	@Test
	public void testCopyContructor() {
		
		Wallet w = new Wallet(1,2,3,4,5);
		Wallet w2 = new Wallet(w);
		assertAll("Copy Contructor",
				() -> assertEquals(w.getOnes(),w2.getOnes()),
				() -> assertEquals(w.getFives(), w2.getFives(), "fives"),
				() -> assertEquals(w.getTens(), w2.getTens()),
				() -> assertEquals(w.getTwenties(), w2.getTwenties()),
				() -> assertEquals(w.getHundreds(), w2.getHundreds())
				);	
	}
	
	@ParameterizedTest
	@MethodSource("walletAmountProvider2")
	public void testAmountConstructor(Wallet w, int amount) {
		Wallet w2 = new Wallet(amount);
		assertAll("Amount Contructor",
				() -> assertEquals(w.getOnes(),w2.getOnes()),
				() -> assertEquals(w.getFives(), w2.getFives(), "fives"),
				() -> assertEquals(w.getTens(), w2.getTens()),
				() -> assertEquals(w.getTwenties(), w2.getTwenties()),
				() -> assertEquals(w.getHundreds(), w2.getHundreds())
				);
	}
	
	static Arguments[] walletAmountProvider() {
		return new Arguments[] {
				Arguments.arguments(new Wallet(0,0,0,0,0), 0),
				Arguments.arguments(new Wallet(1,1,1,1,1), 136)
		};
	}
	
	static Arguments[] walletAmountProvider2() {
		Random genRand = new Random();
		int numCases = 100;
		Arguments[] result = new Arguments[numCases];
		for (int i=0; i<numCases; i++) {
			int ones = genRand.nextInt(5);
			int fives = genRand.nextInt(2);
			int tens = genRand.nextInt(2);
			int twenties = genRand.nextInt(5);
			int hundreds = genRand.nextInt(100);
			Wallet w = new Wallet(ones, fives, tens, twenties, hundreds);
			int amount = ones + fives*5 + tens*10 + twenties*20 + hundreds*100;
			result[i] = Arguments.arguments(w, amount);
		}
		return result;
	}
	

	
	
	
	

}
