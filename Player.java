package project1_17336293;

public class Player implements Comparable<Player> {
	//constructor, where name is the player name and score is the players total score
	private String name = "No Name";
	private double score = 0;
	
	public Player(){
		//no args constructor
	}
	
	public Player(String newName){
		//args based constructor
		this.setName(newName);
	}
	
	public Player(String newName, double newScore){
		//args based constructor
		this.setName(newName);
		this.setScore(newScore);
	}
	
	public Player(String newName, String newScore){
		//args based constructor
		this.setName(newName);
		this.setScore(Double.parseDouble(newScore));
	}
	
	public String getName() {
		//getter for the name attribute
		return this.name;
	}
	
	public double getScore() {
		//getter for the score attribute for a particular player
		return this.score;
	}
	
	public void setName(String newName) {
		//setter for the name attribute
		if (newName != "") {
			this.name = newName;
		}
	}
	
	public void incrementScore(double increase) {
		//increase score by fixed amount
		double oldScore = this.getScore();
		this.setScore(oldScore+increase);
	}
	
	public void decrementScore(double increase) {
		//decrease score by fixed amount
		double oldScore = this.getScore();
		this.setScore(oldScore-increase);
		
		//prevent negative scores
		if (this.getScore() < 0) {
			this.setScore(0);
		}
	}
	
	public void setScore(double newScore) {
		//setter for the score attribute
		this.score = newScore;
	}
	
	public int compareTo(Player p2) {
		//comparison interface
		if (this.getScore()==p2.getScore()) {
			return 0;
		}
		
		else if (this.getScore()>p2.getScore()) {
			return -1;
		}
		
		else {
			return 1;
		}
	}
	
	@Override
	public String toString() {
		//returns a string containing the player name and their score
		String result = this.getName() +"\t\t"+this.getScore()+"\n";
		return result;
	}

}
