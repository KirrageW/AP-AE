// makes intersection of grids.......


public class Spec1Main {
	
	public static void main(String args[]) {
		
		int m = 20;
		int n = 20;
		Grid[][] intersection = new Grid[m][n];
		for(int i=0;i<m;i++) {
			System.out.println("");
			for(int j=0;j<n;j++) {
				intersection[i][j] = new Grid();
			}
		
		}
	}		
}
