
public class Customer {

	private String id;
	private String name;
	private String lastName;
	private Wallet wallet;
	
	public Customer(String id, String name, String lastName, Wallet wallet) {
		super();
		this.id = id;
		this.name = name;
		this.lastName = lastName;
		this.wallet = wallet;
	}
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getLastName() {
		return lastName;
	}
	public Wallet getWallet() {
		return wallet;
	}
	public void setId(String id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public void setWallet(Wallet wallet) {
		this.wallet = wallet;
	}
	
	public boolean canAfford(int moneyAmount) {
		return moneyAmount <= this.getWallet().getAmount();
	}
	
	public void earn(int amount) {
		this.wallet.add(amount);
	}
	
	
	
}
