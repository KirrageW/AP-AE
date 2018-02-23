
public class spawnTraffic extends Thread {
	
	private Grid[][] junction;
	private int density;
	private String shape;
	private int direction;
	private int roadLower;
	private int roadUpper;
	
	// constructor - i wanted to just give a vehicle reference, but i need anonymous creation in my spawning run method. not sure how to get rid of the reference 
	// that would be attached to the vehicle... 
	public spawnTraffic(Grid[][] x, int traffic, int vehicleDirection, String vehicleShape, int roadLower, int roadUpper) {
		this.junction = x;
		this.density = traffic;
		this.direction = vehicleDirection;
		this.shape = vehicleShape;
		this.roadLower = roadLower;
		this.roadUpper = roadUpper;
	}
	
	public void run() {
		for (;;) {
			
			try {
				Thread.sleep(density);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			new Car (direction, shape, junction, roadLower, roadUpper).start();	
		}
	}
		

}
