import java.util.ArrayList;

public class spawnTraffic extends Thread {
	
	private Grid[][] junction;
	private int density;
	private String shape;
	private int direction;
	private int roadLower;
	private int roadUpper;
	private String name;
	
	// for spec2 statistics
	private Statistics stats;
	private ArrayList<Long> runTimes;
	private Render renderer;
	
	// constructor - i wanted to just give a vehicle reference, but i need anonymous creation in my spawning run method. not sure how to get rid of the reference 
	// that would be attached to the vehicle... this was also a problem for collecting run times for each thread for the statistics stuff.
	public spawnTraffic(Grid[][] x, int traffic, int vehicleDirection, String vehicleShape, int roadLower, int roadUpper, String name, Render r) {
		this.junction = x;
		this.density = traffic;
		this.direction = vehicleDirection;
		this.shape = vehicleShape;
		this.roadLower = roadLower;
		this.roadUpper = roadUpper;
		this.runTimes = new ArrayList<Long>();
		this.name = name;
		renderer = r;
	}
	
	
	public void run() {
		while (renderer.isAlive()) {
			
			try {
				Thread.sleep(density);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			new Car (direction, shape, junction, roadLower, roadUpper, this).start(); // if this thread had a reference it would say the thread is already running, 																								
																// or would not record the proper time it took to run through the grid (overwritten by next one created)						
		}
		
		sendToStats();
	}
	
	public void collectRunTimes(long threadTime) {
		runTimes.add(threadTime);
	}
	
	public void sendToStats() {
		Statistics statCalculator = new Statistics(runTimes, name);
		statCalculator.publishResults();
	}
	
	
	
}
