
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// this class will need the estimatedRunTime of each thread, and the spawnTraffic class ID that created it...

public class Statistics {
	
	private ArrayList<Long> runTimes;
	private ArrayList<spawnTraffic> generators;

	
	public Statistics() {
		runTimes = new ArrayList<Long>();
		generators = new ArrayList<spawnTraffic>();
	}
	
	public long getRunTime(spawnTraffic spawner) {	
		for (int i=0;  i< generators.size(); i++) {
			if generators[i].equals(spawner){
				
			}
			
		}
	}
	
	
	// gets sent the time and the generator who created it, by every thread that makes it to the end of the grid
	public void saveRunTime(long duration, spawnTraffic spawnedBy) { // and add the spawner.......
		runTimes.add(duration);
		generators.add(spawnedBy);
	}
	
	private void calculateThings() {
		for (int i =0; i < runTimes.size(); i++) {
			
		}
	}
	
	public void displayStatistics() {
		//System.out.println(runTimes.iterator());
	}

}
