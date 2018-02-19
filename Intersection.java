
public class Intersection {
	
	private int nRows;
	private int nCols;
	private Grid[][] intersection;
	
	
	public Intersection(int nRows, int nCols) {
		this.nRows = nRows;
		this.nCols = nCols;
		intersection = new Grid[nRows][nCols];
	}
	
	public void drawIntersection() {
		for(int i=0;i<nRows;i++) {
			System.out.println("");
			for(int j=0;j<nCols;j++) {
				intersection[i][j] = new Grid();
			}
		}
		
		
		
	}
	
	
	
		

		

}
