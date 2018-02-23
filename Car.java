// concrete class, size is a potential attribute for future extension - perhaps cars take up one lane, another class representing a wide load could
// take up two lanes, and have a reduced speed...

public class Car extends Vehicle{
	
	int size = 1;

	public Car(int direction, String rep, Grid[][] x) {
		super(direction, rep, x);
	}
	
	public Car(int direction, String rep, Grid[][] x, int spawnLower, int spawnHigher, spawnTraffic spawnedBy) {
		super(direction, rep, x, spawnLower, spawnHigher, spawnedBy);
	}
	

}
