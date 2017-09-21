// Igor Kalezic
// 3/8/16
// TCSS 143
// Assignment #9
//

public class AccountTest {
	
	public static void main(String[] args) {
		
		
		testSavings();
		testSuper();

	}
	// Tests savings account class.
	public static void testSavings () {
		// Tests constructor.
		SavingsAccount b = new SavingsAccount(5000, 5.25);
		
		
		System.out.println(b.getBalance());
		b.deposit(52);
		System.out.println(b.getBalance());
		b.withdraw(1);
		System.out.println(b.getBalance());
		
		b.withdraw(1);
		b.withdraw(1);
		b.withdraw(1);
		b.withdraw(1);
		b.withdraw(1);
		b.withdraw(1);
		
		
		
		System.out.println(b.getDeposits());
		System.out.println(b.getNumWithdrawals());
		System.out.println(b.getBalance());
		
		// Tests constructing with negative values.
		try {
			SavingsAccount a = new SavingsAccount(-2,5);
		}catch(IllegalArgumentException e) {
		    System.out.println("IllegalArgumentException: " + e.getMessage());
		}
	}
	
	// Tests super class. 
	public static void testSuper () {
		// Tests constructor.
		BankAccount b = new BankAccount(5000, 5.25);
		
		// Tests getBalance, deposit, and withdrawal methods.
		System.out.println(b.getBalance());
		b.deposit(52);
		System.out.println(b.getBalance());
		b.withdraw(1);
		System.out.println(b.getBalance());
		
		// Tests for more than 4 withdrawals because a charge needs to be added.
		b.withdraw(1);
		b.withdraw(1);
		b.withdraw(1);
		b.withdraw(1);
		b.withdraw(1);
		b.withdraw(1);
		
		
		// Tests balance, withdrawals, and deposits methods.
		System.out.println(b.getDeposits());
		System.out.println(b.getNumWithdrawals());
		System.out.println(b.getBalance());
		
		// Tests constructor with negative value.
		try {
			BankAccount a = new BankAccount(-2,5);
		}catch(IllegalArgumentException e) {
		    System.out.println("IllegalArgumentException: " + e.getMessage());
		}
		
	}

}
