

// makes junction of grids.......

public class Spec1Main {
	
	public static void main(String args[]) {
		
			int m = 10;
			int n = 20;
			Grid[][] junction = new Grid[m][n];
			
			// make junction
			for(int i=0;i<m;i++) {
				System.out.println("");
					for(int j=0;j<n;j++) {
						junction[i][j] = new Grid(); 
					}				
			}

			
			// start drawing on a separate thread
				Render renderer = new Render(junction);
				renderer.start();
				
				
				// spawn vehicles indefinitely
				while (renderer.isAlive()) {
					try {
						Thread.sleep(500); // every half a second
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					// spawn one of each of these types of vehicles: 
					new Car(0,"o",junction).start();
					new Car(1,"-",junction).start();
				}
				
				System.exit(0);
				
				
				
				
				// for testing
				
			/*	Vehicle testCar = new Car(0, "o", junction);
				testCar.start();
				BrokenCar testBroke1 = new BrokenCar(junction[5][5]);
				BrokenCar testBroke2 = new BrokenCar(junction[5][6]);
				BrokenCar testBroke3 = new BrokenCar(junction[5][7]);
				BrokenCar testBroke4 = new BrokenCar(junction[5][8]);
				BrokenCar testBroke5 = new BrokenCar(junction[5][9]);
				BrokenCar testBroke6 = new BrokenCar(junction[5][10]);*/
				
				
				
								
			}		
		

}
