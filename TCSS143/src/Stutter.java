// Igor Kalezic
// 3/15/16
// TCSS 143
// Assignment #10
//
// This program will modify an ArrayList by making the elements appear twice in a row
// instead of just once. For example, an ArrayList with elements of "hi", "hello", "bye" 
// will be modified to "hi", "hi", "hello", "hello", "bye", "bye". This doubles the size
// of the ArrayList.

import java.util.ArrayList;

public class Stutter {
	
	public static void main(String[] args) {
		double i = -1;
		
		System.out.println(i);
		System.out.println(Math.sqrt(i));
		
//		// Tests with odd amount of elements.
//		ArrayList<String> array = new ArrayList<String>();
//		array.add("how");
//		array.add("are");		
//		array.add("you?");
//		
//		// Tests with even amount of elements.
//		ArrayList<String> arrayTwo = new ArrayList<String>();
//		arrayTwo.add("how");
//		arrayTwo.add("are");		
//		arrayTwo.add("you?");
//		arrayTwo.add("i'm");
//		arrayTwo.add("fine");		
//		arrayTwo.add("thanks");
//		arrayTwo.add("blah");
//		
//		// Tests with one element.
//		ArrayList<String> arrayThree = new ArrayList<String>();
//		arrayThree.add("blah");
//		
//		stutter(array);
//		System.out.println(array);
//		System.out.println();
//		
//		stutter(arrayTwo);
//		System.out.println(arrayTwo);
//		System.out.println();
//		
//		stutter(arrayThree);
//		System.out.println(arrayThree);
	}
	
	// This method takes an ArrayList of strings as a parameter and repeats the elements
	// consecutively, doubling the size of the list.
	public static void stutter(ArrayList<String> array) {
		for (int i = 0; i <= array.size()-1; i++) {
			String x = array.get(i);
			array.set(i , x + ',' +x );
			
			
			
		}
		
	}

}
