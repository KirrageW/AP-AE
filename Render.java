// draws the junction of gridsquares and any vehicle that may be in one, every 20 milliseconds, to system.out

import java.util.Timer;
import java.util.TimerTask;

public class Render extends Thread{
	
	
	private Grid[][] junction;
	private StringBuilder frame;
	
	public Render(Grid[][] x) {
		this.junction = x;
			
	}
	
	public void run() {
		while(true) {
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
				System.out.print(frame);
			
			} catch (InterruptedException e) {
				e.printStackTrace();
			}		
		}
	}
}
