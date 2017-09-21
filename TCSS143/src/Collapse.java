// Igor Kalezic
// 3/15/16
// TCSS 143
// Assignment #10
//
// This program will take the elements in an Array List and combine the elements
// in adjacent indexes together as pairs. So index 0 at first will have one word and 
// after the collapse method is called will have two words. The ArrayList will shorten
// by half. If there is an odd amount of elements the first elements will be paired up
// and the last element will be left by itself.

import java.util.ArrayList;

public class Collapse {

	public static void main(String[] args) {
		
		// Tests with even amount of elements.
		ArrayList<String> array = new ArrayList<String>();
		array.add("four");
		array.add("score");
		array.add("and");
		array.add("seven");
		array.add("years");
		array.add("ago");
		
		// Tests with odd amount of elements.
		ArrayList<String> arrayTwo = new ArrayList<String>();
		arrayTwo.add("to");
		arrayTwo.add("be");
		arrayTwo.add("or");
		arrayTwo.add("not");
		arrayTwo.add("to");
		arrayTwo.add("be");
		arrayTwo.add("hamlet");
		
		// Tests with one element.
		ArrayList<String> arrayThree = new ArrayList<String>();
		arrayThree.add("blah");
		
		// Tests with two elements.
		ArrayList<String> arrayFour = new ArrayList<String>();
		arrayFour.add("blah");
		arrayFour.add("blah");
		
		
		collapse(array);
		
		collapse(arrayTwo);
		
		collapse(arrayThree);
		
		collapse(arrayFour);
		
		System.out.println(array);
		System.out.println();
		
		System.out.println(arrayTwo);
		System.out.println();
		
		System.out.println(arrayThree);
		System.out.println();
		
		System.out.println(arrayFour);

	}
	
	// This method takes an ArrayList of strings and modifies the ArrayList by pairing
	// up the strings.
	public static void collapse(ArrayList<String> array) {
		for (int i = 0; i < array.size()-1; i++) {
			String x = array.get(i);
			String y = array.get(i+1);
			
			array.set(i, '(' + x + ',' + y + ')');
			array.remove(i+1);
		}
		
	}

}	
