import java.util.Random;

// will be abstract after tests - for different vehicles 


public class Vehicle extends Thread {
	private int direction; // 0 = north to south, 1 = west to east
	private int speed; // how long it will wait in each grid
	private int size; // different types of vehicle may occupy more than one lane!
	private String representation;
	private Grid location; 
	private Grid lastOne;
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
	
	public Vehicle() {
		
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
		
		location.occupyGridSquare(this);	
		while (checkEnd()==true){
					
			directionTravel();
			location.occupyGridSquare(this);
			getLastOne().leaveGridSquare(this);
					
		}
		location.leaveGridSquare(this);
	}
	
	public void directionTravel(){
		
		if (getDirection() == 0) {
			location = intersection[++curr][startPos]; // have to use matrix coordinate			
		}
		if (getDirection() == 1) {
			location = intersection[startPos][++curr]; // so basically, location is moved to the next one...
		}
		
	}
	
	public Grid getLastOne() {
		if (getDirection() == 0) {
			lastOne = intersection[getCurrent()-1][startPos]; 			
		}
		if (getDirection() == 1) {
			lastOne = intersection[startPos][getCurrent()-1]; 
		}
		
		return lastOne;
	}
	
	
	public int getCurrent() {
		return curr;
	}
	
	
	
	public boolean checkEnd() {
		if (direction == 0 && curr==intersection.length-1) {
				return false;
		}
		if (direction == 1 && curr == intersection[0].length-1) {
				return false;
		}
		else 
			return true;	
		}
	
	
}











