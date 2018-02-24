// represents one grid square which can be occupied by a vehicle
// find out how to rename classes - better to call this class gridSquare

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class GridSquare {
			
	private ReentrantLock spaceLock = new ReentrantLock();
	private Condition occupiedCondition = spaceLock.newCondition();
	
	private String representation = "| "; // what the square is visually drawn as
	
	private boolean isTaken = false;
	
	public GridSquare() {
	}
	
	// method for a thread to change the visual representation to look like it is inside it
	public void occupyGridSquare(Vehicle x) {
		try {
			Thread.sleep(x.getSpeed());
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}	
		
		spaceLock.lock();

		try {
			// if this square is already taken
		    while (isTaken) {
		        occupiedCondition.await(); // thread goes to sleep and must try again later
		    }	    
		    isTaken = true;
		    representation = "|"+x.getRepresentation();	// gets the vehicle's represenation to change it
				
		} catch (InterruptedException e) {
			e.printStackTrace();
	
		} finally {
		    spaceLock.unlock(); // releases the lock for other threads to try and enter the square. though at this point they will be put to sleep by await
		}
		
	}
	
	// can only be called if the vehicle has entered the next grid square (see run method in Vehicle)
	public void leaveGridSquare(Vehicle x) {			
		spaceLock.lock();
		try {
		    isTaken = false;	    
		    occupiedCondition.signalAll(); // isTaken set back to false and waiting threads signalled to try and get in the square.
		} finally {
		   spaceLock.unlock();
		   representation = "| ";
		   
		}
			
	}
	
	// used by the renderer to draw the squares.
	public String getRepresentation() {
			return representation;
	}
	
	
}
