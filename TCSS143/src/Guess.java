// Igor Kalezic
// 2/09/16
// TCSS 143
// Assignment #5
/*This program will generate a random number, ask for input from the user as to what the number is. If the user guesses too high
 * the program will print "lower" to tell the user that the number is lower than what they wrote and vice versa. The program will
 * also ask the user if they want to keep playing after they've guessed correctly. When they say no the program will print statistics
 * that include the number of games they've played, number of guesses per game, the max amount of guesses it took for one game,
 * and the total guesses from all games played.
*/

import java.util.*;

public class Guess {

	public static final int RANGE = 100;

	
	public static void main(String[] args) {
		Scanner console = new Scanner(System.in);	
		Random rand = new Random();	
		
		int totalGames = 0;
		int numberToGuess;
		int compareToMaxGuesses = 0;
		int maxGuesses = 0;
		int numberOfGuesses = 0;
		
		String answer;
		
		instructions();
		
				
		do {
			
			
			numberToGuess = rand.nextInt(RANGE) + 1;
			
			compareToMaxGuesses = game(console, numberToGuess);
			
			numberOfGuesses += compareToMaxGuesses;
			
			if(compareToMaxGuesses > maxGuesses) {
				maxGuesses = compareToMaxGuesses;
			}
			
			
			System.out.print("Do you want to play again? ");
			answer = console.next();
			System.out.println();
			totalGames++;
			
		}while(answer.charAt(0)== 'y' || answer.charAt(0)== 'Y');
		
		
		stats(totalGames, numberOfGuesses, maxGuesses);
		
	}

	//This method prints out the instructions to the game. 
	public static void instructions() {

		
		System.out.println("This program allows you to play a guessing game.");
		System.out.println("I will think of a number between 1 and 100");
		System.out.println("and will allow you to guess until you get it.");
		System.out.println("For each guess, I will tell you whether the");
		System.out.println("right answer is higher or lower than your guess.");
		System.out.println();
		
		
	}

	//This method takes two parameters. It is the method for one playthrough of the game. It returns how many guesses it took
	//to guess the correct number.
	public static int game(Scanner console, int numberToGuess) {
		
		
		int numberOfGuesses = 0;
		int userGuess;
		
				
		System.out.println("I'm thinking of a number...");
		
		do {
			System.out.print("Your guess? ");

			userGuess = console.nextInt();

			if(userGuess > numberToGuess) {
				System.out.println("Lower");
				numberOfGuesses++;

			}else if(userGuess < numberToGuess) {
				System.out.println("Higher");
				numberOfGuesses++;
			}
		}while(userGuess != numberToGuess);
			
		numberOfGuesses++;
		
		if(numberOfGuesses == 1) {
			System.out.println("You got it right in " + numberOfGuesses + " guess");
			System.out.println();
		}else{
			System.out.println("You got it right in " + numberOfGuesses + " guesses");
			System.out.println();
		}
		
		
		return numberOfGuesses;	
		}
	

	//This method takes three parameters. It prints the statistics of the game; total games, total guesses, max guesses in a game,
	//and number of guesses per game.
	public static void stats(int totalGames, int numberOfGuesses, int maxGuesses)  {
		
		
		System.out.println("Overall results:");
		System.out.println("   Total games = " + totalGames);
		System.out.println("   Total number of guesses = " + numberOfGuesses);
		System.out.println("   Guesses per game = " + 1.0*numberOfGuesses/totalGames);
		System.out.println("   Max guesses = " + maxGuesses);
		
		
	}
	
}
