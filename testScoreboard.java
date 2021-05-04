package project1_17336293;

import java.io.File;
import java.util.Scanner;
import java.util.ArrayList;

public class testScoreboard {

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
