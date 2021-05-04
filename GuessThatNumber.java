package project1_17336293;
import java.util.Scanner;

public class GuessThatNumber {
	
	public static void game(int limit, Player p1) {
		//set answer
		int answer = (int)(Math.random() * (limit));
		int guess = -1;
		int numberGuesses = 0;
		
		//ask player for guess
		Scanner input2 = new Scanner(System.in);
		
		while (guess != answer) {
			guess = input2.nextInt();
			numberGuesses++;
			
			//if answer incorrect, tell them if it was too high or too low		
			System.out.println(((guess < answer) && (guess != answer)) ? "Too low." : "Too high.");
		}
		
		//game concluded
		int pointsWon = ((limit-1))-(numberGuesses*10);
		if (pointsWon < 0) {
			pointsWon = 0;
		}
		
		System.out.println("Correct. You have won "+pointsWon+" Points.");
		p1.incrementScore(pointsWon);
	}
	
	public static boolean setLock() {
		//set locking mechanism to repeat games
		Scanner input2 = new Scanner(System.in);
		System.out.println("Game concluded. Type anything to continue playing\n");
		System.out.println("Type 0 if you wish to exit");
		String leave = input2.nextLine();
		return (leave.compareTo("0") != 0);
	}
	
	public static void play(Player p1) {
		//read rules
		Scanner input2 = new Scanner(System.in);
		menu();
		
		boolean lock = true;
		
		do {
			//ask players to choose rock, paper or scissors
			String playerDecision = input2.nextLine();
			switch(playerDecision) {
				case "0": lock = false; break;
				case "1":game(501,p1); 
				lock = setLock();
				break;
				case "2":game(101,p1); 
				lock = setLock();
				break;
				case "3":game(51,p1);
				lock = setLock();
				break;
				default: System.out.println("Wrong input. Please try again."); 
			} 
		} while (lock);
		System.out.println("Guessing game has concluded.");
		}
	
	public static void menu() {
		//Explain how to play
		System.out.println("How to play: \nGuess a number between 0 and a set limit.");
		System.out.println("If you get it right first try, you get points equal to the highest number in the list.");
		System.out.println("Every failed try reduces the number of points you can win is reduced by 10.\n");
		
		//read players how to play
		System.out.println("Select the difficulty you would like to play");
		System.out.println("Type 1 for Easy (500 numbers)?");
		System.out.println("Type 2 for Medium (100 numbers)?");
		System.out.println("Type 3 for Hard (50 numbers)");
		System.out.println("Type 0 to Exit the game");
	}
}
