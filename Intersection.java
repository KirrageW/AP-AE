
public class Intersection {
	
	private int nRows;
	private int nCols;
	private GridSquare[][] intersection;
	
	
	public Intersection(int nRows, int nCols) {
		this.nRows = nRows;
		this.nCols = nCols;
		intersection = new GridSquare[nRows][nCols];
	}
	
	public void drawIntersection() {
		for(int i=0;i<nRows;i++) {
			System.out.println("");
			for(int j=0;j<nCols;j++) {
				intersection[i][j] = new GridSquare();
			}
		}
		
		
		
	}
	
	
	
		

		

}
