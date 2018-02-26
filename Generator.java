import java.util.ArrayList;

public class Generator extends Thread {
	
	private GridSquare[][] junction;
	private int density; // amount of traffic - influuences how long thread sleeps for between spawning new vehicles
	
	// i struggled to give the generator a reference to a pre made car, because it is better to have anonymous creation in the run method
	// perhaps I could have made a new vehicle constructor that parsed a single string of information, simply to reduce the required number of attributes
	// ..but it's not too bad
	private String shape;
	private int direction; 
	private int roadLower;
	private int roadUpper;
	// a name for the generator - useful for identifying it in the statistics report
	private String name;
	
	// for spec2 statistics
	private ArrayList<Long> runTimes;
	private Render renderer;
	
	// constructor - i wanted to just give a vehicle reference, but i need anonymous creation in my spawning run method. not sure how to get rid of the reference 
	// that would be attached to the vehicle... this was also a problem for collecting run times for each thread for the statistics stuff.
	public Generator(GridSquare[][] x, int traffic, int vehicleDirection, String vehicleShape, int roadLower, int roadUpper, String name, Render r) {
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
		// runs whilst the renderer is still drawing
		while (renderer.isAlive()) {
			
			try {
				Thread.sleep(density);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			new Car (direction, shape, junction, roadLower, roadUpper, this).start(); // if this thread had a reference it would say the thread is already running, 																								
																// or would not record the proper time it took to run through the grid (overwritten by next one created)						
		}
		// and sends statistics off at the end
		sendToStats();
	}
	
	// adds run times of its Vehicle thread spawn to an arraylist.
	public void collectRunTimes(long threadTime) {
		runTimes.add(threadTime);
	}
	
	// make a stats class to perform operations on that arraylist
	public void sendToStats() {
		// check that the array list contains some results
		if (!runTimes.isEmpty()) {
		Statistics statCalculator = new Statistics(runTimes, name);
		statCalculator.publishResults();
		}
		else
			System.out.println("No thread made by the "+name+" generator made it to the other side!");
	}
	
	
	
	
}
