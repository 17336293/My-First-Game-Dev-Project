package project1_17336293;

public class LimitedPlayer extends Player{
	//creates a limited player class. If the player limit is less than the
	private float limit = 0;
	
	public LimitedPlayer() {
		//no args constructor
		super();
	}
	
	public LimitedPlayer(String newName, float newLimit) {
		//args based constructor
		super(newName);
		this.setLimit(newLimit);
	}
	
	public void setLimit(float newLimit) {
		//sets the limit, unless it is less than 0, in which case the limit is set to 0
		if (newLimit<0) {
			System.out.println("Error. Limit cannot be less than 0. Set to 0");
			this.limit = 0;
		}
		
		else {
			this.limit = newLimit;
		}
	}
	
	public float getLimit() {
		//returns the limit for the player
		return this.limit;
	}
}
