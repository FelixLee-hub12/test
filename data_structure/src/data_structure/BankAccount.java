package data_structure;

public class BankAccount {

	private String accountNum;
	private String accountName;
	private double balance;
	
	 public BankAccount(String noIn, String nameIn) {
		 accountNum = noIn;
		 accountName = nameIn;
		 balance = 0;
	 }
	
	public String getAccountNum() {
		return accountNum;
	}
	

	public String getAccountName() {
		return accountName;
	}
	
	public double getBalance() {
		return balance;
	}
	
	public void deposit(double amountIn) {
		balance += amountIn;
	}
	
	public void withdrawal(double amountOut) {
		balance -= amountOut;
	}
	
}
