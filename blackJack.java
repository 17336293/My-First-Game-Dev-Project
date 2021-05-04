package project1_17336293;
import java.util.Scanner;

public class blackJack {
	//creates a simplified game of blackjack
		
	public static int drawCard() {
		//draw a card in the deck and announce the result
		int cardNumber = (int)(Math.random() * (13));
		++cardNumber;
		
		//get Rank
		String cardRank;
		switch(cardNumber) {
		case 1: cardRank = "Ace"; break;
		case 11: cardRank = "Jack"; break;
		case 12: cardRank = "Queen"; break;
		case 13: cardRank = "King"; break;
		default: cardRank = String.valueOf(cardNumber) ;break;
		}
		
		//print rank and return the value of the card
		System.out.println("Card Drawn:"+cardRank);
		
		//correct cardNumber if it is a King, Queen or Jack
		if (cardNumber > 10) {
			cardNumber = 10;
		}
		
		//address the issue of double aces
		return cardNumber;
	}
	
	public static int hit(int total, int aceCount) {
		int currentCard;
		Scanner input = new Scanner(System.in);
		boolean keepPlaying = true;
		
		//check if player wants more cards
		while ((total < 21) && (keepPlaying==true)) {
			System.out.println("\nDo you want to Hit?\nType 0 for No\n Type 1 for Yes.\nType anything else for no\n");
			String choice = input.nextLine();
			
			if (choice.compareTo("1")==0){
				currentCard = drawCard();
				//dadjust values to deal with aces
				if (currentCard == 1) {
					aceCount++;
					currentCard +=10;
				}
				
				while (((currentCard + total) > 21) && (aceCount >0)) {
					aceCount--;
					total -=10;
				}
				
				//adjust total
				total += currentCard;
				System.out.println("New Total: "+total);
			}
			
			else if (choice.compareTo("0")==0) {
				keepPlaying = false;
			} 
			
			else {
				//keepPlaying = false;
				System.out.println("Invalid Input. Please try again.");
			}
		}
	return total;
	}
	
	public static int dealerDraws(int playerTotal) {
		//draw cards for the dealer
		System.out.println("Dealer's Turn");
		int total = 0;
		int currentCard;
		int aces = 0;
		
		while ((playerTotal>total) && (total<=21)) {
			currentCard = drawCard();
			
			//assume aces = 11
			if (currentCard == 1) {
				aces++;
				total +=10;
			}
			
			//reduce score if aces occured and over 21.
			if (((total+currentCard) > 21) && (aces>0)) {
				total -=10;
				aces--;
			}
			total += currentCard;
		}
	System.out.println("Dealer gets "+total);
	return total;
	}
	
	public static void finalResult(int total, Player p1, int bet) {
		//determine if the play beat the dealer
		if (total > 21) {
			System.out.println("You have lost. Your score is over 21.\nBetter luck next time.\n");
		}
			
		else if (total < 21) {
			int dealerTotal = dealerDraws(total);
			
			if ((dealerTotal > total) && (dealerTotal<=21)) {
				System.out.println("You have lost. The dealer has won.\nBetter luck next time.\n");
			}
			
			else if (dealerTotal == total) {
				System.out.println("You have tied with the dealer.\n");
				p1.incrementScore(bet);
			}
			
			else {
				System.out.println("Success. You have beat the dealer.\n");
				p1.incrementScore(2*bet);
			}
		}
			
		else {
			System.out.println("BLACKJACK!\nYou get 4 times your the amount of bet.\n");
			p1.incrementScore(4*bet);
		}	
	}
	
	public static int[] initalDraw() {
		//initalise total as 0, create current card int to track the current card
		System.out.println("Dealing Cards:");
		int total = 0;
		int currentCard;
		int aces = 0;
		
		//draw first two cards
		for (int i=0; i<2; i++) {
			currentCard = drawCard();
			total += currentCard;
			//correct for ace
				if (currentCard == 1) {
					aces++;
					total +=10;
				}
		}
		//address double aces
		if ((total > 21) && (aces>0)) {
			total -=10;
			aces--;
		}
		
		int[] resultInitalDraw = {total, aces};
		
		return resultInitalDraw;
	}
	
	public static void play(Player p1, int bet) {
	//run the main game
	//track users score, and weather or not they have an ACE
	int[] resultInitalDraw = initalDraw();
	int total =  resultInitalDraw[0];
	int aceCount =  resultInitalDraw[1];
	
	System.out.println("Total: "+total);
	
	//ask the player if they want to draw extra cards
	int finalTotal = hit(total, aceCount);
	//determine if the player beat the dealer
	finalResult(finalTotal, p1, bet);
	System.out.println("New Score: "+p1.getScore());
	}
}
