// a broken down car. used for testing to block off roads.

public class BrokenCar extends Vehicle {
	
	String representation = "x"; // what it will look like on the grid
	
	
	
	public BrokenCar(int direction, String rep, GridSquare[][] x) {
		super(direction, rep, x);	
	}
	
	// simply occupies the square its given in the constructor. 
	public BrokenCar(GridSquare x) {
		
		x.occupyGridSquare(this);
		
	}
	
	// doesn't move
	public void run() {	
	}

	// is still drawn by the renderer
	public String getRepresentation() {
		return representation;
	}
}
