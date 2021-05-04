package project1_17336293;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Main {
	
	public static void main(String[] args) {
		//load main menu and scoreboard
		System.out.println("Game Console TM loaded.");
		String filename = "scoreboard.txt";
		File file = new File(filename);
		
		//prepare to write names to scoreboard
		createFile(file);
		Scanner input = new Scanner(System.in);
		
		boolean lockMain = true;
		do {
			System.out.println("Type 1 to start as a new player?\nType 0 to exit the console.");
			String menuChoice = input.nextLine();
			switch(menuChoice) {
				case "0" : lockMain = false;break;
				case "1" : gameMenu(file); break;
				default: System.out.println("Invalid Choice. Please try again. \nIf you wish to exit 0");break;
			}
		} while (lockMain);
		
		//end program
		System.out.println("Goodbye for now!\n");
		try {
			//print scoreboard
			getScoreboard();
		} catch (Exception e) {
			//it is possible that a scoreboard file, or its contents becomes corrupted, than the scoreboard will be reset
			try {
				System.out.println("Apologise, but it appears that the file has become corrupted. Reseting leader board.");
				PrintWriter writer = new PrintWriter(file);
				writer.print("");
				writer.close();
			} catch (Exception ignore) {}
		}
		input.close();
	};

	public static void gameMenu(File file) {
		Scanner input = new Scanner(System.in);
		
		//ask for new player info
		System.out.println("Please enter your name:");
		String playerName = input.nextLine().replaceAll(",","");
		System.out.println("Please enter a gambling limit. If it is 0, you cannot play Blackjack.");
		PlayerLimit p1 = new PlayerLimit(playerName, 0); 
		try {
			int limit = input.nextInt();
			p1.setLimit(limit);
		} catch(Exception ex) {
			System.out.println("Invalid Input. Betting Suspended.");
		}
		
		//choose a game to play
		System.out.println("\nHi "+p1.getName());
		System.out.println("Please choose a game from the list below:");
		System.out.println("Type 0 to terminate this program.\n");
		boolean lockMain = true;
		String menu1Choice;
		menu1Choice = input.nextLine();
		
			//print list of games available
		while (lockMain){
				game_choice();
				menu1Choice = input.nextLine();
				switch(menu1Choice) {
					case "0" : lockMain = false;break;
					case "1" : RockPaperScissors.play(p1);break;
					case "2" : GuessThatNumber.play(p1);break;
					case "3" : MontyHall.play(p1);break;
					case "4" : BettingMenu.beginBetting(p1);break;
					default: System.out.println("Invalid Choice. Please try again. \nIf you wish to exit 0");break;
				}
				
			};
		writeFile(file, p1);
	}
	
	public static void game_choice() {
		//prints a menu showing the list of games available to the user
		System.out.println("Please choose a game from the list below:");
		System.out.println("1. Rock, Paper ,Scissors");
		System.out.println("2. Coin Guessing Game");
		System.out.println("3. Monty Hall");
		System.out.println("4. Blackjack");
		System.out.println("Type 0 to exit the console.\n");
	}
	
	public static void createFile(File file) {
		//get file if it exists, else create new file
		Scanner input = null;
		try {
			input = new Scanner(file);
			System.out.println("File accessed");
			
		} catch(IOException e) {	
			try {
				file.createNewFile();
				System.out.println("File created");
				} catch(Exception en) {}
		}
	}
	
	public static void writeFile(File file, Player newPlayer) {
		//update scorebord with a players score
		try {
			PrintWriter output = new PrintWriter(new FileWriter(file, true));
			output.println(newPlayer.getName()+","+newPlayer.getScore());
			output.close();
		} catch (IOException e2) {
			System.out.println("Error. Could not save players score.");
		};
	}
	
	public static void getScoreboard() {
		//retrieve file with all players listed
		String filename = "scoreboard.txt";
		File file = new File(filename);
		readScoreboard(file);
	}
	
	public static void readScoreboard(File file) {
		//display the contents of the file
		String display;
		Player p1;
		ArrayList<Player> players = new ArrayList<Player>();
		
		try {
			//get a list of player names, if exists
			Scanner input = new Scanner(file);
			while (input.hasNext()) {
				String line = input.nextLine();
				String[] lineSplit = line.split(",");
				String name = lineSplit[0];
				double score = Double.parseDouble(lineSplit[1]);
				p1 = new Player(name, score);
				players.add(p1);
				//System.out.print(p1.toString());
			}
			players.sort(null);
			
			//print player scores
			System.out.println("Scoreboard");
			System.out.println("Name\t\tScore");
			PlayerVIP topPlayer = new PlayerVIP(players.get(0).getName());
			topPlayer.setScore(players.get(0).getScore());
			System.out.print(topPlayer);
		
			for (int i = 1; i<players.size(); i++) {
				System.out.print(players.get(i).toString());
			}
		
			} catch(Exception ex) {
				ex.printStackTrace();
			}
	}
}
