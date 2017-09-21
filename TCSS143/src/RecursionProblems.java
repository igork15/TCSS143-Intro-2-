// Igor Kalezic
// 2/23/16
// TCSS 143
// Assignment #7
//
// This program is a combination of different methods: sumPositiveIntegers, multiply,
// stripLeadingWhiteSpaces, anyPrimes, isPalindrome, and countCharacters.




public class RecursionProblems {

	public static void main(String[] args) {
		
		//Test cases for sum of positive integers in an array.
		int[] testInts = { };	
		System.out.println("sum of array {} = " + sumPositiveIntegers(testInts, 0));
		testInts = new int[] { -1, -4, -6 };
		System.out.println("sum of array { -1, -4, -6 } = " + sumPositiveIntegers(testInts, 0));
		testInts = new int[] {1};
		System.out.println("sum of array {1} = " + sumPositiveIntegers(testInts, 0));
		testInts = new int[] {-1, 0, 4, 1};
		System.out.println("sum of array {-1, 0, 4, 1} = " + sumPositiveIntegers(testInts, 0));		
		System.out.println();
		
		//Test cases for multiplying the first parameter by the second parameter.
		System.out.println("multiplying 3 x 0= " + multiply(3, 0));
		System.out.println("multiplying 0 x 3= " + multiply(0, 3));
		System.out.println("multiplying 1 x 4= " + multiply(1, 4));
		System.out.println("multiplying 4 x 1= " + multiply(4, 1));
		System.out.println("multiplying 4 x -1= " + multiply(4, -1));
		System.out.println("multiplying -4 x 1= " + multiply(-4, 1));
		System.out.println("multiplying -4 x -1= " + multiply(-4, -1));
		System.out.println("multiplying 20 x 30= " + multiply(20, 30));
		System.out.println();
		
		//Test cases for removing leading white spaces from string.
		System.out.println("strip spaces,     hello world " + stripLeadingWhitespace("    hello world"));
		System.out.println("empty string" + stripLeadingWhitespace(""));
		System.out.println("escape chars " + stripLeadingWhitespace("  \t\n\t  "));
		System.out.println("escape and letters " + stripLeadingWhitespace("  \nabcde"));
		System.out.println("letters and escape " + stripLeadingWhitespace("abc  \nde"));
		System.out.println();
		
		//Test cases for determining whether there are prime numbers within a given range.
		System.out.println("any primes? 402 - 408 " + anyPrimes(402, 408));
		System.out.println("any primes? 17 - 17 " + anyPrimes(17, 17));
		System.out.println("any primes? 14 - 16 " + anyPrimes(14, 16));
		System.out.println("any primes? 2 - 2 " + anyPrimes(2, 2));
		System.out.println("any primes? 4 - 4 " + anyPrimes(4, 4));
		System.out.println("any primes? 14 - 17 " + anyPrimes(14, 17));
		System.out.println();
		
		//Test cases for determining whether a string is a palindrome or not.
		System.out.println("is it a palindrome? AmanaplanacanalPanama " + isPalindrome("AmanaplanacanalPanama"));
		System.out.println("is it a palindrome? igor " + isPalindrome("igor"));
		System.out.println("is it a palindrome? AblewasIereIsawElba " + isPalindrome("AblewasIereIsawElba"));
		System.out.println();
		
		//Test cases for counting the occurance of a specific character in a character 
		//array.
		System.out.println("count characters 'm' in menaka " + countCharacters('m', "menaka") );
		System.out.println("count characters 'a' in menaka " + countCharacters('a', "menaka") );
		System.out.println("count characters 'z' in menaka " + countCharacters('z', "menaka") );
		
	}

	//This method returns the sum of positive integers in an array.
	public static int sumPositiveIntegers(int[] array, int i) {

		if (i != array.length) {
			if (array[i] < 1) {
				return sumPositiveIntegers(array, i + 1);
			} else {
				return sumPositiveIntegers(array, i + 1) + array[i];
			}

		}

		return 0;
	}

	//This method returns the first parameter multiplied by the second parameter.
	public static int multiply(int a, int b) {

		if (b != 0 && a != 0 && b > 0) {
			return multiply(a, b - 1) + a;

		}
		if (b < 0) {
			return multiply(a, b + 1) - a;
		}
		return 0;
	}

	//This method returns a string with the leading white spaces removed.
	public static String stripLeadingWhitespace(String a) {
		int i = 0;
		if (a.contains(" ")) {
			if (a.charAt(i) == ' ') {
				return stripLeadingWhitespace(a.substring(i + 1));

			}
		}

		return a;
	}

	//This method returns true if there are any prime numbers within the given range
	//and returns false if there are not. This method also calls the isPrime method.
	public static boolean anyPrimes(int a, int b) {
		if (a <= b) {

			if (a <= 2) {
				return true;
			}
			if (isPrime(a)) {
				return true;
			}
			else {
				return anyPrimes(a + 1, b);
			}
			

		}

		return false;

	}
	
	//This method returns true if the given string is a palindrome and returns false
	//if it is not.
	public static boolean isPalindrome(String a) {
		a = a.toLowerCase();
		if (a.length() <= 1) {
			return true;
		}

		if (a.charAt(0) != a.charAt(a.length() - 1)) {
			return false;

		}
		return isPalindrome(a.substring(1, a.length() - 1));

	}
	
	//This method returns how many times a certain character appears within a 
	//given string.
	public static int countCharacters (char x, String sample) {
		if (sample.length() > 0) {
			if (x == sample.charAt(0)) {
				return countCharacters(x, sample.substring(1)) + 1;
			}else {
				
				return countCharacters(x, sample.substring(1));
			}
					
			
		}
		return 0;
	}
	
	//This method determines whether the given value is a prime number or not.
	//Also calls the hasDivisor method.
	public static boolean isPrime(int val) {
		if (val <= 0) {
			throw new IllegalArgumentException();
		} else if (val <= 3) {
			return true;
		} else {
			return !hasDivisor(val, 2, val / 2 + 1);
		}
	}
	

	//This method returns if the given values have a divisor or not.
	public static boolean hasDivisor(int num, int low, int high) {
		if (low >= high) {
			return false;
		} else if (num % low == 0) {
			return true;
		} else {
			return hasDivisor(num, low + 1, high);
		}
	}
}
