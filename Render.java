// draws the junction of gridsquares and any vehicle that may be in one, every 20 milliseconds, to system.out

public class Render extends Thread{
	
	
	private GridSquare[][] junction; // ref to the junction
	private StringBuilder frame;
	private int counter;
	private final int RUNFOR = 2000; // draw this many times - basically a timer
	private final int REFRESHRATE = 20; // draw every 20 milliseconds
	
	public Render(GridSquare[][] x) {
		this.junction = x;
			
	}
	
	public void run() {
		while(counter<RUNFOR) {
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
				
				Thread.sleep(REFRESHRATE);
				counter++;
				System.out.print(frame);
			
			} catch (InterruptedException e) {
				e.printStackTrace();
			}		
		}
	}
	
	
	
	
}
