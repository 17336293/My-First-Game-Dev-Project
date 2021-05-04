package project1_17336293;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;
import java.io.PrintWriter;
import java.io.FileWriter;

public class Scorboard {
	
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
		//write contents to file
		//note: curretnly overrides the contents of file
		try {
			PrintWriter output = new PrintWriter(new FileWriter(file, true));
			output.println(newPlayer.getName()+","+newPlayer.getScore());
			output.close();
		} catch (IOException e2) {};
	}
	
	public static int fileSize(String fileName) {
		//get the size of the csv file
		int lines = 0;
		try {
			BufferedReader contents = new BufferedReader(new FileReader(fileName));
			while (contents.readLine() != null) lines++;
				contents.close();
		} catch(Exception en) {}
		return lines;
	}
	
	public static void main(String[] args) {
		//get number of lines in file
		File file = new File("scoreboard.txt");
		createFile(file);
		Player newPlayer1 = new Player("Chris",120);
		Player newPlayer2 = new Player("Ben",120);
		writeFile(file, newPlayer1);
		writeFile(file, newPlayer2);
		int lines = fileSize("scoreboard.txt");
		System.out.println(lines);
	}
}