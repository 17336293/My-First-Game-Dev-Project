package project1_17336293;

import java.util.Scanner;

public class BettingMenu {	
	public static void beginBetting(PlayerLimit p1) {
		//check the players score
		System.out.println("Score "+p1.getScore());
		System.out.println("Limit "+p1.getLimit()+"\n");
		
		//if not valid (ie: if the player has a score or betting limit of 0, exit. Else, start betting
		if (p1.getScore() == 0) {
			System.out.println("Sorry, but You cannot play this game while your score is 0.");
			System.out.println("This game requires you to gamble away your score.\n");
		}
				
		//if the user said they didn't want to gamble
		else if (p1.getLimit() == 0) {
			System.out.println("You have indicated you don't want to play betting based games.");
			System.out.println("You have been returned to the main menu. Please play another game.\n");
		}
				
		//if the user has a score greater than 0 and you have indicated that they want to gamble
		else {
			bettingMenu(p1); 
		}
	}
	
	public static void bettingMenu(PlayerLimit p1) {
		//create menu to check how much the user wants to bet
		Scanner input = new Scanner(System.in);
		int bet = 0;
		
		boolean requestBet = true;
		do {
			try {
				//ask user for their bets
				bet = input.nextInt();
			
				//logical checks
				if (bet>p1.getScore()) {
					System.out.println("Error. Cannot bet more points than you have.\n");
				}
				
				else if (bet > p1.getLimit()) {
					System.out.println("Error. Cannot bet more than your betting limit.\n");
				}
			
				//if valid amount entered, begin blackjack
				else {
					System.out.println("Bet:"+bet);
					p1.decrementScore(bet);
					blackJack.play(p1,bet);
					requestBet = false;
				}
			//exit if a letter or none integer is entered
			} catch (Exception e) {
				System.out.println("Invalid input. Returned to menu.\n");
				requestBet = false;
			}
		} while (requestBet);
	}
}