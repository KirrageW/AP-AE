import java.util.Timer;
import java.util.TimerTask;

public class Render extends Thread{
	
	
	private Grid[][] intersection;
	private StringBuilder frame;
	
	public Render(Grid[][] x) {
		this.intersection = x;
			
	}
	
	public void run() {
		while(true) {
			try {
				frame = new StringBuilder();
				frame.append("\r\n---------------------------------------------------------------\r\n");
				for(int i=0;i<intersection.length;i++) {
					frame.append("\r\n");
					for(int j=0;j<intersection[i].length;j++) {
						frame.append(intersection[i][j].getRepresentation());
					}		
				}
				frame.append("\r\n---------------------------------------------------------------\r\n");
				
				Thread.sleep(200);
				System.out.print(frame);
			
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
	}
	}
	
	// And From your main() method or any other method
	

}
