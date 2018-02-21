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
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		spaceLock.lock();
		//System.out.println("I've gone in "+this);
		try {
		    
		    while (isTaken) {
		    	//System.out.println("I'm in here: "+this);
		        occupiedCondition.await();
		    }
		    
		    isTaken = true;
		    representation = "|"+x.getRepresentation();	
			
		
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	
		} finally {
		    spaceLock.unlock();
		    //System.out.println("I'm unlocking this: "+this);
		}
		
	}
	
	//should only be successful if the vehicle has entered the next grid square
	public void leaveGridSquare(Vehicle x) {
		//System.out.println("I'm leaving this: "+this);
			
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
