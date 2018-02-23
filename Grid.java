// represents one grid square which can be occupied by a vehicle
// find out how to rename classes - better to call this class gridSquare

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Grid {
			
	private ReentrantLock spaceLock = new ReentrantLock();
	private Condition occupiedCondition = spaceLock.newCondition();
	
	private String representation = "| ";
	
	private boolean isTaken = false;
	
	public Grid() {
	}
	
	
	public void occupyGridSquare(Vehicle x) {
		try {
			Thread.sleep(x.getSpeed());
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}	
		
		spaceLock.lock();

		try {	    
		    while (isTaken) {
		        occupiedCondition.await();
		    }	    
		    isTaken = true;
		    representation = "|"+x.getRepresentation();	
				
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
		    occupiedCondition.signalAll();
		} finally {
		   spaceLock.unlock();
		   representation = "| ";
		   
		}
			
	}
	
	public void setRepresentation(String x) {
		representation = x;
	}

	public String getRepresentation() {
			return representation;
	}
	
	
}
