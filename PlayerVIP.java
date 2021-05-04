package project1_17336293;

public class PlayerVIP extends Player{
	
	public PlayerVIP() {
		//no args constructor
		super();
	}
	
	public PlayerVIP(String newName) {
		//args constructor
		super(newName);
	}
	
	@Override
	public String toString() {
		//returns the name to be printed on the leaderboards
		String result = this.getName()+"(MVP) \t"+this.getScore()+"\n";
		return result;
	}

}


