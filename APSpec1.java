
// makes junction of grid and displays spec1 functionality

public class APSpec1 {
	
	public static void main(String args[]) {
		// make junction, this could all be put in a class, Render constructor would be a good one.
			int m = 10;
			int n = 20;
			GridSquare[][] junction = new GridSquare[m][n];
			
			
			for(int i=0;i<m;i++) {
				System.out.println("");
					for(int j=0;j<n;j++) {
						junction[i][j] = new GridSquare(); 
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
				System.exit(0);		// end when rendering ends			
				
				

			/*	Vehicle testCar = new Car(0, "o", junction);
				testCar.start();*/
			}		
	

}
