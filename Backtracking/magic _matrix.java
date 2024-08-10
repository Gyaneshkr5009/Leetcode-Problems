import java.util.Arrays;

public class Solution {
 
	public static int[][] fillMatrix(int n) {
		int[][] grid=new int[n][n];
		if(n == 2 || n == 0) return new int[][]{};
		// filling all the matrix with zero
		for(int i=0 ;i<grid.length; i++){
			for(int j=0 ;j<n ;j++){
				grid[i][j]=0;
			}
		}
		helper(grid , 0 ,0 , new boolean[n*n+1]);
		return grid;		
	}
	private static boolean helper(int[][]grid , int row ,int col , boolean[]used){
		if(row == grid.length) return true;
		int nRow=(col == grid.length-1 ? row+1 : row);
		int nCol=(col+1)%grid.length;

		for(int num=1 ; num<=grid.length*grid.length ;num++){
			if(!used[num] && isSafe(grid , row  ,col , num)){
				grid[row][col] = num;
				used[num]=true;
				//this helper fuctn will fill the matrix until isSafe fuctn return true;
				if(helper(grid , nRow , nCol)){
					return true;
				}
				grid[row][col] = 0; // backtraking our move to find check others; 
			}
		}
		return false;
	}

	private static boolean isSafe(int[][] grid , int row , int col , int num){
		// checking if the number is already present
		for(int i=0 ; i<grid.length ; i++){
			for(int j=0 ; j<grid.length ;j++){
				if(grid[row][col]==num) return false;
			}
		}
		int n=grid.length;
		/* checking sum of column using 
		 Magic Constant Formula =[ n*(n*n+1)/2  ];
		 (This represents the total sum of numbers that should be in any row, column, or diagonal.);
		 (Magic Constant)/(size of row/col) => gives the least sum that each individual row, column, or diagonal must reach.
		*/

		int rSum=0 , cSum=0;
		for(int i=0 ;i < n ; i++){
			rSum+=grid[row][i];
			cSum+=grid[i][col];
		}
		if(rSum+num> n*(n*n+1)/2/n) return false;
		if(cSum+num > n*(n*n+1)/2/n) return false;

		//checking digonal sum
		if (row == col) {
        	int diagSum1 = 0;
        	for (int i = 0; i < n; i++) {
            	diagSum1 += grid[i][i];
        	}
        	if (diagSum1 + num > n * (n * n + 1) / 2) return false;
    	}
		//checking antiDiagonal sum
		if(row+col == n-1){
			int antiDiagonal=0;
			for(int i=0 ;i<n ;i++){
				antiDiagonal+=grid[i][n-i-1];
			}
			if(antiDiagonal+num > n*(n*n+1)/2) return false;
		}

		return true;
	}

}
