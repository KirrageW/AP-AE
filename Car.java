// concrete class, size is a potential attribute for future extension - perhaps cars take up one lane, another class representing a wide load could
// take up two lanes, and have a reduced speed...

public class Car extends Vehicle{
	
	// preset Car-like attributes would go here, such as size, speed limits etc.

	public Car(int direction, String rep, GridSquare[][] x) {
		super(direction, rep, x);
	}
	
	public Car(int direction, String rep, GridSquare[][] x, int spawnLower, int spawnHigher, Generator spawnedBy) {
		super(direction, rep, x, spawnLower, spawnHigher, spawnedBy);
	}
	

}
