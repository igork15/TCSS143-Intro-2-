// Igor Kalezic
// 3/8/16
// TCSS 143
// Assignment #9
//
// This program will keep track of the balance, deposits, withdrawals, annual interest rate, and monthly service charge. This program will
// also serve as a super class.


public class BankAccount {
	
	// class fields.
	private double myBalance;
	private int myNumberDeposits;
	private int myNumberWithdrawals;
	private double myAnnRate;
	private double myMonthlyServiceCharge;
	
	// This method is the constructor for a new bank account. It takes two double parameters and throws an exception if the parameters
	// are negative.
	public BankAccount(double theBalance, double theRate) {
		if (theBalance < 0 || theRate < 0) {
			throw new IllegalArgumentException("Values cannot be negative.");
		}
		myBalance = theBalance;
		myAnnRate = theRate;
		
	}
	
	// This method takes a double parameter that is the amount of money to be deposited in the account. It adds the amount to the
	// myBalance field. Throws illegal argument exception if value is negative.
	public void deposit(double theAmount) {
		if (theAmount < 0 ) {
			throw new IllegalArgumentException("Values cannot be negative.");
		}
		
		myBalance += theAmount;
		
		myNumberDeposits++;
		
	}
	
	// This method takes a double parameter and subtracts the value of the parameter from the myBalance field to serve as a withdraw
	// from the account. Throws illegal argument exception if value is negative.
	public void withdraw(double theAmount) {
		if (theAmount < 0 ) {
			throw new IllegalArgumentException("Values cannot be negative.");
		}
		
		myBalance -= theAmount;
		
		myNumberWithdrawals++;
	}
	
	// This method calculates the monthly interest in the account. Takes no parameters.
	public void calcInterest() {
		double theMonthlyRate = myAnnRate/1200;
		double theMonthlyInterest = myBalance * theMonthlyRate;
		
		myBalance += theMonthlyInterest;
	}
	
	// This method calls the calcInterest method and adds a service charge. The myNumberWithdrawals, myNumberDeposits, and myMonthlyServiceCharge
	// fields are set to 0.
	public void monthlyProcess() {
		myBalance -= myMonthlyServiceCharge;
		
		calcInterest();
		
		myNumberWithdrawals = 0;
		myNumberDeposits = 0;
		myMonthlyServiceCharge = 0;

	}
	
	// Returns the balance.
	public double getBalance() {
		return myBalance;
	}
	// Sets the balance.
	public void setBalance(double theAmount) {
		myBalance = theAmount;
	}
	// Returns the number of withdrawals made.
	public int getNumWithdrawals() {
		return myNumberWithdrawals;
	}
	// Sets the number of withdrawals made.
	public int setNumWithdrawals(int theAmount) {
		return myNumberWithdrawals + theAmount;
		
	}
	// Sets the number of deposits made.
	public int setDeposits(int theAmount) {
		return myNumberDeposits + theAmount;
	}
	// Returns the number of deposits.
	public int getDeposits() {
		return myNumberDeposits;
	}
	

}
