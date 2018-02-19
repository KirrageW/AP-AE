import java.util.Timer;

// makes intersection of grids.......

public class Spec1Main {
	
	public static void main(String args[]) {
		/*
		int m = 20;
		int n = 20;
		Grid[][] intersection = new Grid[m][n];
		for(int i=0;i<m;i++) {
			for(int j=0;j<n;j++) {
				intersection[i][j] = new Grid();
			}		
		}
		
		for(int i=0;i<intersection.length;i++) {
			System.out.println("");
			for(int j=0;j<intersection[i].length;j++) {
				intersection[i][j].toString();
			}			
		}
		
		for(int i=0;i<intersection.length;i++) {
			System.out.println("");
			for(int j=0;j<intersection[i].length;j++) {
				System.out.print(intersection[i][j].getRepresentation());
			}		
		}
		
		
		Render drawer = new Render(intersection);
		Vehicle testCar = new Vehicle(0,1000,5,"o", intersection);
		
		testCar.start();		
		drawer.start();
		
		
		//Timer timer = new Timer();
		//timer.schedule(new Render(intersection), 20, 200);
		
		*/
		
		// makes intersection of grids.......


			// new version	
			int m = 20;
			int n = 20;
			Grid[][] intersection = new Grid[m][n];
			
			for(int i=0;i<m;i++) {
				System.out.println("");
					for(int j=0;j<n;j++) {
						intersection[i][j] = new Grid(); // MIGHT NOT NEED... LOOK AT WHAT VEHICLE NEEDS...this will be the Grid's coordinate - relative position in array, and will be unique
					}				
			}
				
				Vehicle testCar = new Vehicle(0,"o", intersection);
		/*		Vehicle testCar2 = new Vehicle(1,"-", intersection);
				Vehicle testCar3 = new Vehicle(1,"-", intersection);
				Vehicle testCar4 = new Vehicle(1,"-", intersection);
				Vehicle testCar5 = new Vehicle(1,"-", intersection);
				Vehicle testCar6 = new Vehicle(1,"-", intersection);
				Vehicle testCar7 = new Vehicle(1,"-", intersection);*/
				
				Render renderer = new Render(intersection);
				renderer.start();
				
				testCar.start();
			/*	testCar2.start();
				testCar3.start();
				testCar4.start();*/
				
				
				
				for (int i = 0; i < 1000; i++) {
					try {
						Thread.sleep(500);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					new Vehicle(0,"o",intersection).start();
					new Vehicle(1,"-",intersection).start();
				}
				
				
				
			}		
		

}
