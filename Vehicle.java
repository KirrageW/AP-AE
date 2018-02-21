// an abstract class providing basic functionality for 'vehicle' threads that interact with grid square locks and conditions
import java.util.Random;

// will be abstract after tests - for different vehicles 


public abstract class Vehicle extends Thread {
	
	protected int direction; // 0 = north to south, 1 = west to east
	protected int speed; // how long it will wait in each grid
	protected int size; // different types of vehicle may occupy more than one lane!
	protected String representation;
	protected Grid location; 
	protected Grid lastOne;
	protected Grid[][] junction; // needs one of these...
	protected int startPos; 
	protected int curr;
	
	public Vehicle(int direction, String rep, Grid[][] x) {
		
		this.direction = direction;
		this.representation = rep;
		this.junction = x;
		
		Random rand = new Random(); 
		speed = rand.nextInt(1000);
		
		
		if (direction == 0) {
			curr = 0;
			startPos = rand.nextInt(x[0].length);
			location = junction[curr][startPos];
		}
		if (direction == 1) {
			curr = 0;
			startPos = rand.nextInt(x.length);
			location = junction[startPos][curr]; 			
		}
		if (direction == 2) {
			curr = x.length-1;
			startPos = rand.nextInt(x[0].length);
			location = junction[curr][startPos]; 			
		}
		if (direction == 3) {
			curr = x[0].length-1;
			startPos = rand.nextInt(x.length);
			location = junction[startPos][curr]; 			
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
		
	public String getRepresentation() {
		return representation;
	}
	
	public void run() {
		location.occupyGridSquare(this);	
		while (checkEnd()==true){
					
			directionTravel();
			checkEnd();
			location.occupyGridSquare(this);
			getLastOne().leaveGridSquare(this);		
		}
		location.leaveGridSquare(this);
	}
	
	public void directionTravel(){
		
		if (getDirection() == 0) {
			location = junction[++curr][startPos]; // have to use matrix coordinate			
		}
		if (getDirection() == 1) {
			location = junction[startPos][++curr]; // so basically, location is moved to the next one...
		}
		if (getDirection() == 2) {
			location = junction[--curr][startPos]; // so basically, location is moved to the next one...
		}	
		if (getDirection() == 3) {
			location = junction[startPos][--curr]; // so basically, location is moved to the next one...
		}		
	}
	
	public Grid getLastOne() {
		if (getDirection() == 0) {
			lastOne = junction[getCurrent()-1][startPos]; 			
		}
		if (getDirection() == 1) {
			lastOne = junction[startPos][getCurrent()-1]; 
		}
		if (getDirection() == 2) {
			lastOne = junction[getCurrent()+1][startPos]; 			
		}
		if (getDirection() == 3) {
			lastOne = junction[startPos][getCurrent()+1]; 
		}
		
		return lastOne;
	}
	
	
	
	
	
	
	public int getCurrent() {
		return curr;
	}
	
	
	public boolean checkEnd() {
		if (direction == 0 && curr==junction.length-1) {
				return false;
		}
		if (direction == 1 && curr == junction[0].length-1) {
				return false;
		}
		if ((direction == 2 || direction == 3) && curr == 0) {
			return false;
		}
		else 
			return true;	
		}	
}



