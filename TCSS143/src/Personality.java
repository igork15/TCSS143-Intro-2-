// Igor Kalezic
// 2/16/16
// TCSS 143
// Assignment #6
 
// This program will read a file that contains the names and answers of people who took a 70 question personality 
// test called the Keirsey Temperament Sorter. There are four dimensions to the test. The program will compare
// the answers to each dimension and compare it to the total answers possible. It will create a new file and 
// write the output to the file. The final output will have the percentages enclosed in brackets and the personality
// type the person is based on those percentages. The personality type is four letters.



import java.io.*;
import java.util.*;

public class Personality {

	/**
	 * @param args
	 * @throws FileNotFoundException
	 */
	public static void main(String[] args) throws FileNotFoundException {
		
		//Scanner reads the file and creates the output file to be written to.
		Scanner inputFile = new Scanner(new File("personality.txt"));
		PrintStream outputFile = new PrintStream(new File("personalityOut.txt"));

		String lineOfAnswers;

		int totalAnswers = 20;

		int extIntPercentage;
		int sensIntuPercentage;
		int thinkFeelPercentage;
		int judgePercPercentage;

		
		do {
			
			//Writes the name of the person that took the test and a colon to the file.
			outputFile.print(inputFile.nextLine() + ": ");
			
			//Stores the whole line in the file as a variable and changes it to lower case.
			lineOfAnswers = inputFile.nextLine();
			lineOfAnswers = lineOfAnswers.toLowerCase();
			
			//Creates an integer array of size four for the four dimensions.
			int[] theCounters = new int[4];

			//Initializes a counter that is used in the for loops for the expression to be accurate.
			int theExpressionCounter = 0;

			//Creates a character array of the line that has the answers in the file.
			char[] theLetters = lineOfAnswers.toCharArray();

			extIntPercentage = introExtroIterations(theLetters, theCounters);

			sensIntuPercentage = senseIntuitIterations(theLetters, theCounters, theExpressionCounter,totalAnswers);

			thinkFeelPercentage = thinkFeelIterations(theLetters, theCounters, theExpressionCounter,totalAnswers);

			judgePercPercentage = judgePerceivIterations(theLetters, theCounters, theExpressionCounter,totalAnswers);

			
			//Writes to the file the percentages the person got on the four dimensions.
			outputFile.print("[" + extIntPercentage + ", ");
			outputFile.print(sensIntuPercentage + ", ");
			outputFile.print(thinkFeelPercentage + ", ");
			outputFile.print(judgePercPercentage + "]" + " " + "=" + " ");

			//Prints the letters that accompany the percentages for each dimension.
			printPersonalityType(extIntPercentage, outputFile, 'I','E');
			
			printPersonalityType(sensIntuPercentage, outputFile, 'N', 'S');

			printPersonalityType(thinkFeelPercentage, outputFile, 'F', 'T');
			System.out.println(" ");
			System.out.println();
			printPersonalityType(judgePercPercentage, outputFile, 'P', 'J');

		} while (inputFile.hasNextLine());

		inputFile.close();
	}

	//This method takes two parameters and goes through the array of answers and increments the counters if there is a b answer
	//and subtracts one from the total answers if the answer is a '-'. The method returns the percentage of b answers
	//compared to total answers for the dimension of introvert and extrovert.
	public static int introExtroIterations(char[] theLetters, int[] theCounters) {

		int bAnswers = theCounters[0];
		double percentage;
		int totalAnswers = 10;

		for (int i = 0; i <= 63; i += 7) {

			if (theLetters[i] == 'b') {
				bAnswers++;

			} else if (theLetters[i] == '-') {
				totalAnswers--;
			}
		}

		percentage = Math.round((1.0 * bAnswers / totalAnswers) * 100);
		int percent = (int) (percentage + 0.5);

		return percent;

	}

	//This method takes four parameters does the same thing as the method above for the dimension of sensing and intutition.
	public static int senseIntuitIterations(char[] theLetters, int[] theCounters, int theCounter, int totalAnswers) {

		int bAnswers = theCounters[1];
		double percentage;

		for (int i = 1; i <= 66; i++) {

			if (theLetters[i] == 'b') {
				bAnswers++;

			} else if (theLetters[i] == '-') {
				totalAnswers--;
			}
			theCounter++;
			if (theCounter % 2 == 0) {
				i += 5;
			}
		}

		percentage = Math.round((1.0 * bAnswers / totalAnswers) * 100);
		int percent = (int) (percentage + 0.5);

		return percent;
	}

	//This method takes four parameters and  does the same thing as the method above for the dimension of thinking and feeling.
	public static int thinkFeelIterations(char[] theLetters, int[] theCounters, int counter, int totalAnswers) {

		int bAnswers = theCounters[2];
		double percentage;

		for (int i = 3; i <= 68; i++) {

			if (theLetters[i] == 'b') {
				bAnswers++;

			} else if (theLetters[i] == '-') {
				totalAnswers--;
			}
			counter++;
			if (counter % 2 == 0) {
				i += 5;
			}
		}

		percentage = Math.round((1.0 * bAnswers / totalAnswers) * 100);
		int percent = (int) (percentage + 0.5);

		return percent;
	}

	//This method takes four parameters and does the same thing as the method above for the dimension of judging and perceiving.
	public static int judgePerceivIterations(char[] theLetters, int[] theCounters, int counter, int totalAnswers) {

		int bAnswers = theCounters[3];
		double percentage;

		for (int i = 5; i <= 70; i++) {

			if (theLetters[i] == 'b') {
				bAnswers++;

			} else if (theLetters[i] == '-') {
				totalAnswers--;
			}
			counter++;
			if (counter % 2 == 0) {
				i += 5;
			}
		}

		percentage = Math.round((1.0 * bAnswers / totalAnswers) * 100);
		int percent = (int) (percentage + 0.5);

		return percent;

	}
	
	//This method takes four parameters and prints the personality type of the person that took the test.
	public static void printPersonalityType(int theAnswers, PrintStream outputFile, char a, char b) {
		
		
		if (theAnswers > 50) {
			outputFile.print(a);
			
		} else if (theAnswers < 50) {
			outputFile.print(b);
			
		} else {
			outputFile.print('X');
		}

		
	}
}
