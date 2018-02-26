// displays spec2 functionality

public class APSpec2 {
	
	public static void main(String args[]) {
		
		// choose juntion parameters
		int m = 10;
		int n = 20;
		
		// init junction 
		GridSquare[][] junction = new GridSquare[m][n];
		for(int i=0;i<m;i++) {
				for(int j=0;j<n;j++) {
					junction[i][j] = new GridSquare(); 
				}				
		}
	
		// makes use of a new generator class - a threaded object that can spawn vehicles as usual, but with varying 
		// delays between spawns - representing traffic density		
			Render renderer = new Render(junction);
			renderer.start();
	/*		Generator spawner = new Generator(junction, 500, 0,"o", 0,10, "N-S", renderer); // grid, traffic delay, direction, shape, random spawn point between last two numbers
			spawner.start();
			Generator spawner1 = new Generator(junction, 1000, 2,"o", 10,20, "S-N", renderer);  
			spawner1.start();
			Generator spawner2 = new Generator(junction, 1500, 1,"-", 0,5, "W-E", renderer);  
			spawner2.start();
			Generator spawner3 = new Generator(junction, 1500, 3,"-", 5,10, "E-W", renderer);  
			spawner3.start();
			
			try {
				spawner.join();
				spawner1.join();
				spawner2.join();
				spawner3.join();
				System.exit(0); // end program when these threads have finished.
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			*/
			
			Generator test1 = new Generator(junction, 1500, 1,"o", 0,m/2, "blocked lanes", renderer);  
			test1.start();
			Generator test2 = new Generator(junction, 1500, 1,"-", m/2,m, "open road", renderer);  
			test2.start();
			BrokenCar testBroke1 = new BrokenCar(junction[0][10]);
			BrokenCar testBroke2 = new BrokenCar(junction[1][10]);
			BrokenCar testBroke3 = new BrokenCar(junction[2][10]);
			BrokenCar testBroke4 = new BrokenCar(junction[3][10]);
			BrokenCar testBroke5 = new BrokenCar(junction[4][10]);
			
			try {
				test1.join();
				test2.join();
				System.exit(0); 
			} catch (InterruptedException e) {
				e.printStackTrace();
			}	
		}	
}
