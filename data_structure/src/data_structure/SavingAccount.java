package data_structure;

public class SavingAccount extends BankAccount{

	private double interestRate;
	public SavingAccount(String noIn, String nameIn, double interestRate) {
		// TODO Auto-generated constructor stub
		super(noIn,nameIn);
		setInterestRate(interestRate);
		
	}

	public void setInterestRate(double rate) {
		this.interestRate = rate;
	}
	
	public double getInterestRate() {
		return this.interestRate;
	}
	
	public double calculateInterest() {
		return super.getBalance() * (interestRate/100);
	}
}

