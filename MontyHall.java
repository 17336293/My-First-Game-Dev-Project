package project1_17336293;

import java.util.Scanner;

public class MontyHall {
	
	public static int getDoor() {
		//AI chooses one of three doors
		int doorNum = (int)(Math.random() * 3)+1;
		return doorNum;
	}
	
	public static int revealSecondDoor(int[] options, int initalGuess, int answer) {
		//reveal one of the goat doors
		int reveal = 0;
		
		//if only one door left is a goat
		for (int i = 0; i<options.length; i++) {
			if ((options[i] != initalGuess) && (options[i] != answer)) {
				reveal = options[i];
			} 
		}
		
		//if correct answer choosen on first try, randomly pick one of the two other goat doors
		if (answer == initalGuess) {
			int randSwitch = (int)(Math.random()*2);
			if (randSwitch == 0) {
				for (int i = 0; i<options.length; i++) {
					if ((options[i] != initalGuess) && (options[i] != reveal)) {
						reveal = options[i];
						break;
					} 
				}
			}
		}
		
		return reveal;
	}
	
	public static void secondRound(String initalGuessStr, int answer, Player p1) {
		//start the second round of monthy hall
		int initalGuess = Integer.parseInt(initalGuessStr);
		int currentGuess = initalGuess;
		int[] options = {1,2,3};
		System.out.println("You choose door "+initalGuess+"\n");
		
		//determine goat door
		int reveal = revealSecondDoor(options,initalGuess,answer);
		
		//offer to switch
		System.out.println("Door "+reveal+" has a goat.\nIf you want to switch, type 'SWITCH'");
		Scanner input3 = new Scanner(System.in);
		String playerSwitch = input3.nextLine();
		boolean switchYN = (playerSwitch.equals("SWITCH"));
		
		if (switchYN){
			System.out.println("You switched to the other door.\n");
			for (int i = 0; i<options.length; i++) {
				if (options[i] != reveal && options[i] != initalGuess) {
					currentGuess = options[i];
					break;
				}
			}
		}

		//determine if the player has won or lost
		System.out.println("You choose door "+currentGuess+"\nThe car is behind door "+answer+".\n");
		boolean winYN = ((initalGuess == answer) ^ (switchYN == true));
		System.out.println((winYN) ? "You win. You get 100 points." : "Sorry, better luck next time.");
		if (winYN) {p1.incrementScore(100);}
		
	}
	
	public static void play(Player p1) {
		//tells the player how to play
		int answer = getDoor();
		
		//ask for input
		Scanner input3 = new Scanner(System.in);
		boolean lock = true;
		
		do {
			//run first round
			System.out.println("There are three doors. Please choose a Door (1, 2 or 3)");
			String playerDecision = input3.nextLine();
			switch(playerDecision) {
				case "0": lock = false; break;
				case "1":
				case "2":
				case "3": secondRound((playerDecision),answer, p1);
				answer = (int)(Math.random() * 3)+1; 
				System.out.println("Game concluded. Type anything to continue playing\n");
				System.out.println("Type 0 if you wish to exit");
				String leave = input3.nextLine();
				
				if (leave.compareTo("0") == 0){
					lock = false;
				}
				break;
				default: System.out.println("wrong input. Please try again."); break;
			} 
			answer = getDoor();
			
		} while (lock);
			System.out.println("Monty Hall has concluded.");
	}
}
