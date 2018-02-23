// draws the junction of gridsquares and any vehicle that may be in one, every 20 milliseconds, to system.out

public class Render extends Thread{
	
	
	private Grid[][] junction;
	private StringBuilder frame;
	private int counter;
	
	public Render(Grid[][] x) {
		this.junction = x;
			
	}
	
	public void run() {
		while(counter<2000) {
			try {
				frame = new StringBuilder();
				frame.append("\r\n----------------------------------------");
				for(int i=0;i<junction.length;i++) {
					frame.append("\r\n");
					for(int j=0;j<junction[i].length;j++) {
						frame.append(junction[i][j].getRepresentation());
					}		
				}
				frame.append("\r\n----------------------------------------");
				
				Thread.sleep(20);
				counter++;
				System.out.print(frame);
			
			} catch (InterruptedException e) {
				e.printStackTrace();
			}		
		}
		
		//System.exit(0); // closes program after drawing 2000 times, at 20 milliseconds is 40 seconds. 
	}
	
	
	
}
