import java.util.Random;

// will be abstract after tests - for different vehicles 


public class Vehicle extends Thread {
	private int direction; // 0 = north to south, 1 = west to east
	private int speed; // how long it will wait in each grid
	private int size; // different types of vehicle may occupy more than one lane!
	private String representation;
	private Grid location; 
	private Grid[][] intersection; // needs one of these...
	protected int startPos; 
	private int curr;
	
	public Vehicle(int direction, String rep, Grid[][] x) {
		
		this.direction = direction;
		this.speed = speed;
		this.size = size;
		this.representation = rep;
		this.intersection = x;
		Random rand = new Random(); 
		speed = rand.nextInt(1000);
		//System.out.println(speed);
		curr = 0;
		if (direction == 0) {
			startPos = rand.nextInt(x[0].length);
			//System.out.println(startPos);
			location = intersection[curr][startPos];
		}
		if (direction == 1) {
			startPos = rand.nextInt(x.length);
			location = intersection[startPos][curr]; //get number of rows also...
			//System.out.println(startPos);
		}
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
	
	public void move() {  // need to get them to move
		location.occupyGridSquare(this);
		try {
			Thread.sleep(speed);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}

	public void run() {
		Grid temp = location;
		int count = 0;
	
		while (checkEnd()==true){
			
			
		
			//enters one and saves the location reference
			location.occupyGridSquare(this);
			if (count>0)
				temp.leaveGridSquare(this);
			temp = location;
			
			// updates location and tries enterering new grid
			directionTravel();
			location.occupyGridSquare(this);
			
			// leaves old grid once successful
			temp.leaveGridSquare(this);
			// updates temp to second location
			temp = location;
		
			
			count++;
		}
		location.leaveGridSquare(this);
	}
	
	public void directionTravel(){
		
		if (getDirection() == 0) {
			location = intersection[curr++][startPos]; // have to use matrix coordinate			
		}
		if (getDirection() == 1) {
			location = intersection[startPos][curr++]; // so basically, location is moved to the next one...
		}
		
	}
	
	
	
	public boolean checkEnd() {
		if (direction == 0 && curr==intersection.length) {
				return false;
		}
		if (direction == 1 && curr == intersection[0].length) {
				return false;
		}
		else 
			return true;	
		}
	
	
}











