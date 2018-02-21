// represents one grid square which can be occupied by a vehicle

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Grid {
	
	
	
	
	private ReentrantLock spaceLock = new ReentrantLock();
	private Condition occupiedCondition = spaceLock.newCondition();
	
	private String representation = "| ";
	private String emptyRepresentation = "| ";
	private Grid nextGrid;
	
	
	private boolean isTaken = false;
	
	public Grid() {
	}
	
	
	public void occupyGridSquare(Vehicle x) {
	
		spaceLock.lock();
		try {
		    
		    while (isTaken = false) {
		        occupiedCondition.await();
		    }
		   
		
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	
		} finally {
		    spaceLock.unlock();
		}
		
		
		
	
			spaceLock.lock();
			try {
			    isTaken = true;
			    representation = "|"+x.getRepresentation();	
				Thread.sleep(x.getSpeed());
			
			} catch (InterruptedException e) {
				e.printStackTrace();
				
			} finally {
			    spaceLock.unlock();
			}
						
			
			
			
	}
	
	//should only be successful if the vehicle has entered the next grid square
	public void leaveGridSquare(Vehicle x) {
	
			
		spaceLock.lock();
		try {
		    isTaken = false;
		    representation = "| ";
		    occupiedCondition.signalAll();
		} finally {
		   spaceLock.unlock();
		   
		}
			
	}
	
	public void setRepresentation(String x) {
		representation = x;
	}

	
	public String getRepresentation() {
			return representation;
	}
	
	
}
