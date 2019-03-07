/*
 * Represents a wallet with dollar bills form various denominations
 */
public class Wallet {

	private int ones;
	private int fives;
	private int tens;
	private int twenties;
	private int hundreds;

	public Wallet(int ones, int fives, int tens, int twenties, int hundreds) {
		super();
		this.ones = ones;
		this.fives = fives;
		this.tens = tens;
		this.twenties = twenties;
		this.hundreds = hundreds;
	}

	/*
	 * Creates a new wallet with exactly the same bills as the parameter wallet
	 */
	public Wallet(Wallet w) {
		this.ones = w.ones;
		this.fives = w.fives;
		this.tens = w.tens;
		this.twenties = w.twenties;
		this.hundreds = w.hundreds;
	}

	/*
	 * Return true if and only if the parameter wallet contains exactly the same bills 
	 * as the target object.
	 */
	public boolean equals(Object o) {
		if (o instanceof Wallet) {
			Wallet w = (Wallet) o;
			return ((this.ones     == w.ones) &&
					(this.fives    == w.fives) &&
					(this.tens     == w.tens) &&
					(this.twenties == w.twenties) &&
					(this.hundreds == w.hundreds));
		}
		return false;
	}

	/*
	 * Creates a new wallet with the minimal number of bills necessary to represent the
	 * number of dollars received as a parameter
	 */
	public Wallet(int dollars) {
		hundreds = dollars / 100;
		dollars -= hundreds * 100;
		twenties = dollars / 20;
		dollars -= twenties * 20;
		tens = dollars / 10;
		dollars -= tens * 10;
		fives = dollars / 5;
		dollars -= fives * 5;
		ones = dollars;
	}

	// Getters 
	public int getOnes()     { return ones; }
	public int getFives()    { return fives; }
	public int getTens()     { return tens; }
	public int getTwenties() { return twenties; }
	public int getHundreds() { return hundreds; }

	// Setters
	public void setOnes(int ones)         { this.ones = ones; }
	public void setFives(int fives)       { this.fives = fives; }
	public void setTens(int tens)         { this.tens = tens; }
	public void setTwenties(int twenties) { this.twenties = twenties; }
	public void setHundreds(int hundreds) { this.hundreds = hundreds; }

	/*
	 * Returns the amount of money in dollars contained in the wallet
	 */
	public int getAmount() {
		// YOUR CODE HERE
		return 1*ones + 5*fives + 10*tens + 20*twenties + 100*hundreds;
		//return 0; // Dummy return. Please change and remove comment
	}

	/*
	 * Modifies the target wallet to add the bills from the parameter wallet
	 */
	public Wallet add(Wallet w2) {
		// YOUR CODE HERE
		this.ones += w2.ones;
		this.tens += w2.tens;
		this.fives += w2.fives;
		this.twenties += w2.twenties;
		this.hundreds += w2.hundreds;

		return this; // Dummy return. Please change and remove comment
	}

	/*
	 * Modifies the target wallet to add the minimal number of bills necessary to add
	 * the amount of money represented by the dollars parameter
	 */
	public Wallet add(int dollars) {
		Wallet w = new Wallet(dollars);
		this.add(w);
		// YOUR CODE HERE
		return this; // Dummy return. Please change and remove comment
	}

	/*
	 * Modifies the target wallet to contain the same amount as before, but using the minimal
	 * number of bills
	 */
	public Wallet minimize() {
		// YOUR CODE HERE
		return null; // Dummy return. Please change and remove comment
	}
	
	@Override
	public String toString() {
		return "Wallet(" +
				"$100=" + this.hundreds + ", " +
				"$20=" + this.twenties + ", " +
				"$10=" + this.tens + ", " +
				"$5=" + this.fives + ", " +
				"$1=" + this.ones + ")";
			
	}
}