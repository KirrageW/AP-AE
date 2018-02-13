// will be abstract after tests - for different vehicles 


public class Vehicle extends Thread {
	private int direction; // 0 = north to south, 1 = west to east
	private int speed; // how long it will wait in each grid
	private int size; // different types of vehicle may occupy more than one lane!
	private String representation;
	
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

	
	public void run() {
		try {
			Grid.accomodateGridSquare(this); // so does need some coordinates - but would this be from the array made in main.... ??
		}
		
		
	}
	
	
}














