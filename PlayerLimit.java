package project1_17336293;

public class PlayerLimit extends Player{
	//create limit attriute to track the max you can bet
	private int limit = 0;
	
	public PlayerLimit() {
		//no args constructor
		super();
	}
	
	public PlayerLimit(String newName, int newLimit) {
		//args constructor
		super(newName);
		this.setLimit(newLimit);		
	}
	
	public int getLimit() {
		//getter for the limit
		return this.limit;
	}
	
	public void setLimit(int newLimit) {
		//set the betting limit
		if (newLimit < 0) {
			this.limit = 0;
			System.out.println("You cannot have a negitive score. Betting limit set to 0");
		}
		
		else {
			this.limit = newLimit;
		}
	}
}