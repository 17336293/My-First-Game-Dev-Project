package project1_17336293;
import java.util.Scanner;

public class RockPaperScissors {
	public static void menu() {
		//read players how to play
		System.out.println("\nChoose Rock, Paper or Scissors?");
		System.out.println("Type 1 for Rock?");
		System.out.println("Type 2 for Paper?");
		System.out.println("Type 3 for Scissors?");
		System.out.println("Type 0 to Exit the game");
	}
	
	public static void play(Player p1) {
		///choose what the AI will pick
		int ai = (int)(Math.random() * 3)+1;
		
		//read the rules
		Scanner input1 = new Scanner(System.in);
		boolean lock = true;
		
		do {
			//ask players to choose rock, paper or scissors
			menu();
			String playerDecision = input1.nextLine();
			switch(playerDecision) {
				case "0": lock = false; break;
				case "1":
				case "2":
				case "3":game(playerDecision, ai, p1);
				ai = (int)(Math.random() * 3)+1; 
				System.out.println("Game concluded. Type anything to continue playing\n");
				System.out.println("Type 0 if you wish to exit");
				String leave = input1.nextLine();
				
				if (leave.compareTo("0") == 0){
					lock = false;
				}
				break;
				default: System.out.println("wrong input. Please try again."); break;
			} 
		} while (lock);
			System.out.println("Rock Paper Scissors has concluded.");
		}
	
	public static String[][] winLooseTable() {
		//returns an array that lists the outcomes based on what the player and ai decide.
		String[][] table = new String[3][3];
		table[0][0] = "d";
		table[0][1] = "w";
		table[0][2] = "l";
		table[1][0] = "l";
		table[1][1] = "d";
		table[1][2] = "w";
		table[2][0] = "w";
		table[2][1] = "l";
		table[2][2] = "d";	
		return table;
	}
	
	public static void game(String playerDecision, int ai , Player p1) {//, Player p1) {
		//determine if the player is succesful or not.
		String[] results = {"Rock","Paper","Scissors"};
		
		int player = Integer.parseInt(playerDecision);
	
		System.out.println("Player Choose: "+results[player-1]);
		System.out.println("AI Choose: "+results[ai-1]);
	
		String[][] outcomes = winLooseTable();
		String outcome = outcomes[ai-1][player-1];
		if (outcome == "w") {
			System.out.println("winner");
			System.out.println("You have won 10 points");
			p1.incrementScore(10);
		}
		else if (outcome == "d") {
			System.out.println("draw");
		}
		else{
			System.out.println("loss");
		}
	}
	
}
