import java.util.Timer;

// makes intersection of grids.......

public class Spec1Main {
	
	public static void main(String args[]) {
		
			int m = 20;
			int n = 20;
			Grid[][] intersection = new Grid[m][n];
			
			// make intersection
			for(int i=0;i<m;i++) {
				System.out.println("");
					for(int j=0;j<n;j++) {
						intersection[i][j] = new Grid(); 
					}				
			}

			
			// start drawing
				Render renderer = new Render(intersection);
				renderer.start();
				
				// spawn cars
				/*for (int i = 0; i < 1000; i++) {
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					new Vehicle(0,"o",intersection).start();
					new Vehicle(1,"-",intersection).start();
				}*/
				
				Vehicle testCar = new Vehicle(0, "o", intersection);
				testCar.start();
								
			}		
		

}
