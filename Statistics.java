import java.util.ArrayList;

// a class to perform maths and stuff on the run times of threads
// note that it is a one to one association with a Generator.

public class Statistics {
	
	private ArrayList<Long> threadTimes;
	private String generatorID; // which generator is it analysing results from
	
	
	public Statistics(ArrayList<Long> threadTimesForAGenerator, String id) {
		this.threadTimes = threadTimesForAGenerator;
		this.generatorID = id;
	}
	
	private long calculateAverage() {
		  Long sum = (long) 0.0;
		  if(!threadTimes.isEmpty()) {
		    for (Long time : threadTimes) {
		        sum += time;
		    }
		    return sum.longValue() / threadTimes.size();
		  }
		  return sum;
		}
	private long getMin() {
		Long min = threadTimes.get(0);
			for (int i = 0; i < threadTimes.size(); i ++) {
				if (min > threadTimes.get(i)){
					min = threadTimes.get(i);
				}				
			}
			
		return min;
	}	
	private long getMax() {
		Long max = threadTimes.get(0);
			for (int i = 0; i < threadTimes.size(); i ++) {
				if (max < threadTimes.get(i)){
					max = threadTimes.get(i);
				}
				
			}
		return max;
	}
	
	private double convertToMilliseconds(long x) {
		double y = x/1000000;
		return y;
	}
	
	public void publishResults() {
		StringBuilder data = new StringBuilder();
		data.append("\r\nThe average time of vehicles made by the "+generatorID+" generator to finish was : "+convertToMilliseconds(calculateAverage()));
		data.append("\r\nThe slowest thread took : "+convertToMilliseconds(getMax()) +" milliseconds");
		data.append("\r\nThe fastest thread took : "+convertToMilliseconds(getMin()) +" milliseconds");
		data.append("\r\n-----------------------------------------\r\n");
		System.out.print(data);
		
	}
	
	
	

}
