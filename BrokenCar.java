// a broken down car. used for testing to block off roads.

public class BrokenCar extends Vehicle {
	
	String representation = "x";
	
	
	
	public BrokenCar(int direction, String rep, Grid[][] x) {
		super(direction, rep, x);	
	}
	
	public BrokenCar(Grid x) {
		
		x.occupyGridSquare(this);
		
	}
	
	public void run() {
		
		
	}

	public String getRepresentation() {
		return representation;
	}
}
