
// an abstract class providing basic functionality for 'vehicle' threads that interact with grid square locks and conditions
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

// will be abstract after tests - for different vehicles 

public abstract class Vehicle extends Thread {

	protected int direction; // 0 = north to south, 1 = west to east, 2 = east to west, 3 = south to north
	protected int speed; // how long it will wait in each grid
	protected String representation;
	// gridSquare references
	protected GridSquare nextSquare; 
	protected GridSquare currentSquare;
	protected GridSquare[][] junction; // ref to whole junction
	// for navigation 
	protected int startPos;
	protected int curr;

	// added for spec2
	protected long startTime;
	protected long estimatedTime;
	protected Generator spawnedBy;

	// spec1 constructor; simple, concise, random spawn point along entire matrix axis
	public Vehicle(int direction, String rep, GridSquare[][] x) {

		this.direction = direction;
		this.representation = rep;
		this.junction = x;

		Random rand = new Random();
		speed = rand.nextInt(1000);

		if (direction == 0) {
			curr = 0;
			startPos = rand.nextInt(x[0].length);
			nextSquare = junction[curr][startPos];
		}
		if (direction == 1) {
			curr = 0;
			startPos = rand.nextInt(x.length);
			nextSquare = junction[startPos][curr];
		}
		if (direction == 2) {
			curr = x.length - 1;
			startPos = rand.nextInt(x[0].length);
			nextSquare = junction[curr][startPos];
		}
		if (direction == 3) {
			curr = x[0].length - 1;
			startPos = rand.nextInt(x.length);
			nextSquare = junction[startPos][curr];
		}

	}

	// spec 2 constructor - added two new ints to denote boundaries for random spawn
	// location
	// this allows the vehicle to be randomly spawned only in a certain area, or
	// constrained down to a single lane
	public Vehicle(int direction, String rep, GridSquare[][] x, int spawnZoneLower, int spawnZoneUpper,
			Generator spawnedBy) {

		this.direction = direction;
		this.representation = rep;
		this.junction = x;

		Random rand = new Random();

		// speed set for all, but could easily be another variable in the vehicle
		// constructor
		speed = rand.nextInt(1000);

		startPos = ThreadLocalRandom.current().nextInt(spawnZoneLower, spawnZoneUpper);

		if (direction == 0) {
			curr = 0;
			nextSquare = junction[curr][startPos];
		}
		if (direction == 1) {
			curr = 0;
			nextSquare = junction[startPos][curr];
		}
		if (direction == 2) {
			curr = x.length - 1;
			nextSquare = junction[curr][startPos];
		}
		if (direction == 3) {
			curr = x[0].length - 1;
			nextSquare = junction[startPos][curr];
		}

		this.spawnedBy = spawnedBy;
	}

	public Vehicle() {
	}

	public int getDirection() {
		return direction;
	}

	public int getSpeed() {
		return speed;
	}

	public String getRepresentation() {
		return representation;
	}

	// run method of the thread
	public void run() {
		startTime = System.nanoTime(); // begin timing
		
		// main movement sequence
		nextSquare.occupyGridSquare(this);
		while (checkEnd() == true) {

			directionTravel();
			nextSquare.occupyGridSquare(this);
			getSquareStillIn().leaveGridSquare(this);
		}
		nextSquare.leaveGridSquare(this);
		
		// end time and send to generator before thread dies
		estimatedTime = System.nanoTime() - startTime;
		if (spawnedBy != null) {
			spawnedBy.collectRunTimes(estimatedTime);}
	}

	// this method gives a reference to the next square, so it can try and occupy it
	public void directionTravel() {

		if (getDirection() == 0) {
			nextSquare = junction[++curr][startPos]; // have to use matrix coordinate
		}
		if (getDirection() == 1) {
			nextSquare = junction[startPos][++curr]; // so basically, location is moved to the next one...
		}
		if (getDirection() == 2) {
			nextSquare = junction[--curr][startPos]; 
		}
		if (getDirection() == 3) {
			nextSquare = junction[startPos][--curr]; 
		}
	}

	// fetch a ref to the square it's still occupying, so it can leave it when ready
	public GridSquare getSquareStillIn() {
		if (getDirection() == 0) {
			currentSquare = junction[getCurrent() - 1][startPos];
		}
		if (getDirection() == 1) {
			currentSquare = junction[startPos][getCurrent() - 1];
		}
		if (getDirection() == 2) {
			currentSquare = junction[getCurrent() + 1][startPos];
		}
		if (getDirection() == 3) {
			currentSquare = junction[startPos][getCurrent() + 1];
		}

		return currentSquare;
	}

	// helped method for the above
	public int getCurrent() {
		return curr;
	}

	// checks to see if the thread has reached the end of its 'road'
	public boolean checkEnd() {
		if (direction == 0 && curr == junction.length - 1) {
			return false;
		}
		if (direction == 1 && curr == junction[0].length - 1) {
			return false;
		}
		if ((direction == 2 || direction == 3) && curr == 0) {
			return false;
		} else
			return true;
	}

	// returns the estimated time it took to reach the end of the grid[][]. in
	// nanoseconds...
	public long getRunTime() {
		return estimatedTime;
	}
}
