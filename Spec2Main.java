
public class Spec2Main {
	
	public static void main(String args[]) {
		
		// choose juntion parameters
		int m = 10;
		int n = 20;
		
		// init junction
		Grid[][] junction = new Grid[m][n];
		for(int i=0;i<m;i++) {
				for(int j=0;j<n;j++) {
					junction[i][j] = new Grid(); 
				}				
		}

		
		// makes use of a new spawner class - a threaded object that can spawn vehicles as usual, but with varying 
		// delays between spawns - representing traffic density
		
			Render renderer = new Render(junction);
			renderer.start();
			spawnTraffic spawner = new spawnTraffic(junction, 500, 0,"o", 0,10); // grid, traffic delay, direction, shape, random spawn point between last two numbers
			spawner.start();
			spawnTraffic spawner1 = new spawnTraffic(junction, 1000, 2,"o", 10,20);  
			spawner1.start();
			spawnTraffic spawner2 = new spawnTraffic(junction, 1500, 1,"-", 0,5);  
			spawner2.start();
			spawnTraffic spawner3 = new spawnTraffic(junction, 1500, 3,"-", 5,10);  
			spawner3.start();
										
		}		

}
