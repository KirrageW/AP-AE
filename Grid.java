// represents one grid square which can be occupied by a vehicle

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Grid {
	
	
	
	
	private ReentrantLock spaceLock = new ReentrantLock();
	private Condition occupiedCondition = spaceLock.newCondition();
	private String representation = "| ";
	private String emptyRepresentation = "| ";
	
	
	private boolean isTaken = false;
	
	public Grid() {
	}
	
/*	public String toString() {
		if (isTaken == false)
			return emptyRepresentation;
		else
			return representation;	
	}*/
	
	public void occupyGridSquare(Vehicle x) {
		System.out.println(this+ "has been called");
		
		// called by the vehicle thread
		spaceLock.lock();
		//System.out.println("vehicle has locked grid square "+this);
		
		try {
			while(this.isTaken) {
				occupiedCondition.await();
				
			}
			// when vehicle is in the gridSquare
			isTaken = true;
						
			// change visual of grid to represent presence of vehicle
			representation = "|"+x.getRepresentation();	
			
			// make vehicle sleep here, after changing visual rep.
			x.sleep(x.getSpeed());
			
			// Alert all the waiting things when ready to move out 
			//occupiedCondition.signalAll();
		}catch(InterruptedException e){
		//	e.printStackTrace();
		}//finally {
			
			// set back to empty	
			//isTaken = false; // BUT WHAT IF THREAD CANNOT ENTER NEXT ONE???????
			//spaceLock.unlock();
			//representation = "| ";
			
		//}
	}
	
	//should only be successful if the vehicle has entered the next grid square
	public void leaveGridSquare(Vehicle x) {
	
			
			isTaken = false;
			occupiedCondition.signalAll();
			//System.err.println(this+" grid square is unlocked");
			representation = "| ";
			spaceLock.unlock();
			
	}
	
	public void setRepresentation(String x) {
		representation = x;
	}

	
	public String getRepresentation() {
		// TODO Auto-generated method stub
	//	if (!isTaken) {
		//	return emptyRepresentation;
		//}
		//else {
			return representation;
		//}
	}
	
	
}
