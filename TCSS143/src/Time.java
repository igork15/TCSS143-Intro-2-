// Igor Kalezic
// 3/1/16
// TCSS 143
// Assignment #8
//
// This program will store the time in military format. It has constructors, an adding
// method, a getTime method that shows the time in decimal format, and a method that
// converts the time to a string.


public class Time {
	//Fields for the class.
	private int myHours;
	private int myMinutes;
	private int mySeconds;

	//Default constructor for the time.
	public Time() {
		myHours = 0;
		myMinutes = 0;
		mySeconds = 0;

	}

	//Constructor that allows the user to set the time. Throws exception if values are less
	// than zero. Limits to integers less than 24.
	public Time(int theHours, int theMinutes, int theSeconds) {
		if (theHours < 0 || theMinutes < 0 || theSeconds < 0) {
			throw new IllegalArgumentException("Values cannot be negative.");
		}

		myHours = theHours;	
		myMinutes = theMinutes;
		mySeconds = theSeconds;
		
		while (myHours >= 24) {
			myHours -= 24;
		}
		while (myMinutes >= 60) {
			myMinutes -= 60;
		}
		while (mySeconds >= 60) {
			mySeconds -= 60;
		}

	}

	//Method that adds two times together. Throws exception if values are less than negative.
	//if the seconds value is greater than 60 the minutes gets incremented by 1 and the
	//difference is the seconds value. Same with the minutes parameter.
	public void add(int theHours, int theMinutes, int theSeconds) {
		if (theHours < 0 || theMinutes < 0 || theSeconds < 0) {
			throw new IllegalArgumentException("Values cannot be negative.");
		}

		myHours += theHours;
		myMinutes += theMinutes;
		mySeconds += theSeconds;

		while (myHours >= 24) {
			myHours -= 24;

		}
		while (myMinutes >= 60) {
			myMinutes -= 60;
			myHours += 1;

		}
		while (mySeconds >= 60) {
			mySeconds -= 60;
			myMinutes += 1;

		}

	}

	//Converts the values to a string.
	public String toString() {
		return myHours + ":" + myMinutes + ":" + mySeconds;
	}

	//Converts the time to a decimal value.
	public double getTime() {
		return myHours + (myMinutes / 60.0) + (mySeconds / 3600.0);
	}

}