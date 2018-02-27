import java.util.ArrayList;

// a class to perform maths and stuff on the run times of threads
// note that it is a one to one association with a Generator. 
// It is a cohesive component that performs operations on an arraylist of data

public class Statistics {
	
	private ArrayList<Long> dataList;
	private String generatorID; // currently attached to a generator, and maintains the name of said generator to print
	
	
	public Statistics(ArrayList<Long> threadTimesForAGenerator, String id) {
		this.dataList = threadTimesForAGenerator;
		this.generatorID = id;
	}
	
	private long calculateAverage() {
		  Long sum = (long) 0.0;
		  if(!dataList.isEmpty()) {
		    for (Long time : dataList) {
		        sum += time;
		    }
		    return sum.longValue() / dataList.size();
		  }
		  return sum; // it shouldn't return these empty values, as checked in Generator not to send empty list...
		}
	private long getMin() {
		if (!dataList.isEmpty()) {
		Long min = dataList.get(0);
			for (int i = 0; i < dataList.size(); i ++) {
				if (min > dataList.get(i)){
					min = dataList.get(i);
				}				
			}
			
		return min;
	}	
		return 0; 
	}
	private long getMax() {
		if (!dataList.isEmpty()) {
		Long max = dataList.get(0);
			for (int i = 0; i < dataList.size(); i ++) {
				if (max < dataList.get(i)){
					max = dataList.get(i);
				}
				
			}
		return max;
		}
		return 0;
	}
	
	private long getVariance() {
		long average = calculateAverage();
		long x = 0;
		for (int i = 0; i < dataList.size(); i++) {
			x = x + ((dataList.get(i)-average)*(dataList.get(i)-average));
		}
		x = x/(dataList.size()-1);
		return x;
	}
	
	// method to convert to whatever format a user would want. I have chosen milliseconds
	private double convertToMilliseconds(long x) {
		double y = x/1000000;
		return y;
	}
	
	
	public void publishResults() {
		StringBuilder data = new StringBuilder();
		
		data.append("\r\nThe average time of vehicles made by the "+generatorID+" generator to finish was: "+convertToMilliseconds(calculateAverage())+" milliseconds");
		data.append("\r\nThe slowest thread took: "+convertToMilliseconds(getMax()) +" milliseconds");
		data.append("\r\nThe fastest thread took: "+convertToMilliseconds(getMin()) +" milliseconds");
		data.append("\r\nThe variance is: "+convertToMilliseconds(getVariance()));
		data.append("\r\n-----------------------------------------\r\n");
		System.out.print(data);
		
	}
	
	
	

}
