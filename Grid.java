// represents one grid square which can be occupied by a vehicle

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Grid {
	
	
	
	private ReentrantLock spaceLock = new ReentrantLock();
	private Condition occupiedCondition = spaceLock.newCondition();
	private String representation = "| | ";
	
	private boolean isTaken = false;
	
	public Grid() {
		System.out.print(representation); //maybe dont have this here... or maybe not a problem
	}
	
	public void occupyGridSquare(Vehicle x) {
		// called by the vehicle thread
		spaceLock.lock();
		try {
			while(this.isTaken) {
				occupiedCondition.await();
			}
			// when vehicle is in the gridSquare
			isTaken = true;
			representation = "|"+x.getRepresentation()+"| ";			
			// make the thread wait here for the speed of that vehicle
			
			// Alert all the waiting things when ready to move out 
			occupiedCondition.signalAll();
		}catch(InterruptedException e){
			e.printStackTrace();
		}finally {
			representation = "| | ";
			isTaken = false;
			spaceLock.unlock();
			
		}
	}
}
