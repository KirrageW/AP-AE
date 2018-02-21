
public class BrokenCar extends Vehicle {
	
	
	
	
	public BrokenCar(int direction, String rep, Grid[][] x) {
		super(direction, rep, x);	
	}
	
	public BrokenCar(Grid x) {
		
		x.occupyGridSquare(this);
		
	}

}
