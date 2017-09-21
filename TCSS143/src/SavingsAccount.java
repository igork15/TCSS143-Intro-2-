// Igor Kalezic
// 3/8/16
// TCSS 143
// Assignment #9
//
// This class extends the BankAccount class. New savings account.

public class SavingsAccount extends BankAccount {
	
	// Constructor for the class.
	public SavingsAccount(double theBalance, double theRate) {
		super(theBalance, theRate);
		
	}
	
	// This method withdraws money from account. Takes one parameter and subtracts that value from the balance. Calls the active method,
	// the super class withdraw, setNumWithdrawals, getNumWithdrawals, setBalance, and getBalance methods.
	public void withdraw(double theAmount) {
		if (active()) {
			super.withdraw(theAmount);
			super.setNumWithdrawals(super.getNumWithdrawals() + 1);
			if (super.getNumWithdrawals() > 4) {
				super.setBalance(super.getBalance() -1);
			}
		}
		
		
	}
	// This method deposits money. Takes one parameter and adds it to the balance. Calls active method, the super getBalance, deposit, setDeposits, 
	// and getDeposits methods.
	public void deposit(double theAmount) {
		if (active() || super.getBalance() + theAmount > 25) {
			super.deposit(theAmount);
			
			super.setDeposits(super.getDeposits()+1);
			
		}
		
		
	}
	
	// Keeps track of monthly charges. Calls the super getNumWithdrawals, setBalance, getBalance methods and the active method.
	public void monthlyProcess() {
		if (super.getNumWithdrawals() > 4) {
			super.setBalance(super.getBalance()-1);
			
		}
		
		if (super.getBalance() < 25) {
			active();
		}
		
	}
	
	// Private method that determines whether an account is active or not. Calls the super getBalance method.
	private boolean active() {
		if (super.getBalance() > 25) {
			return true;
		}
		return false;
		
	}

}
