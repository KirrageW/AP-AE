// will be abstract after tests - for different vehicles 


public class Vehicle extends Thread {
	private int direction; // 0 = north to south, 1 = west to east
	private int speed; // how long it will wait in each grid
	private int size; // different types of vehicle may occupy more than one lane!
	private String representation;
	private Grid location;
	
	public Vehicle(int direction, int speed, int size, String rep) {
		this.direction = direction;
		this.speed = speed;
		this.size = size;
		this.representation = rep;
	}
	
	public int getDirection() {
		return direction;
	}
	
	public int getSpeed() {
		return speed;
	}
	
	public int getSize() {
		return size;
	}
	
	private void setRepresentation() {
		representation = "o";
	}
	
	public String getRepresentation() {
		return representation;
	}
	
	public void move(Grid x ) {  // need to get them to move
		x.accomodateGridSquare(this);
		
		
		
	}

	
	public void run() {
		try {
			location.accomodateGridSquare(this); // so does need some coordinates - but would this be from the array made in main.... ??
		}
		
		
	}
	
	
}














