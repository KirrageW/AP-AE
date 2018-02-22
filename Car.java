
public class Car extends Vehicle{
	
	int size = 1;

	public Car(int direction, String rep, Grid[][] x) {
		super(direction, rep, x);
	}
	
	public Car(int direction, String rep, Grid[][] x, int spawnLower, int spawnHigher) {
		super(direction, rep, x, spawnLower, spawnHigher);
	}
	

}
