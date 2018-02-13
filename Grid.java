import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Grid {
	
	
	
	private ReentrantLock spaceLock = new ReentrantLock();
	private Condition occupiedCondition = spaceLock.newCondition();
	private String representation = "| | ";
	
	private boolean isTaken = false;
	
	public Grid() {
		System.out.print(representation);
	}
	
	public void accomodateGridSquare(Vehicle x) {
		// called by the vehicle
		spaceLock.lock();
		try {
			while(this.isTaken) {
				occupiedCondition.await();
			}
			
			isTaken = true;
			// when vehicle is in the gridSquare - draw a car here and make it wait for variable length
			// use this
			representation = "|"+x.getRepresentation()+"| ";
			x.getSpeed();
			
			
			// Alert all the waiting things when ready to move out 
			occupiedCondition.signalAll();

		}catch(InterruptedException e){
			e.printStackTrace();
		}finally {
			spaceLock.unlock();
		}
	}
	

}
