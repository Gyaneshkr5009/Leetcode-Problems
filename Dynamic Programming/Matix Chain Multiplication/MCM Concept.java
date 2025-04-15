/*
     Problem statement

    Given a chain of matrices A1, A2, A3,.....An. Your task is to find out the minimum cost to multiply these matrices. The cost of matrix multiplication is defined as the number of scalar multiplications. A Chain of matrices A1, A2, A3,.....An is represented by a sequence of numbers in an array ‘arr’ where the dimension of 1st matrix is equal to arr[0] * arr[1] , 2nd matrix is arr[1] * arr[2], and so on.
    For example:
    
    For arr[ ] = { 10, 20, 30, 40}, matrix A1 = [10 * 20], A2 = [20 * 30], A3 = [30 * 40]
    
    Scalar multiplication of matrix with dimension 10 * 20 is equal to 200.

*/

//*********************************************(memoization)***********************************
import java.util.* ;
import java.io.*; 

public class Solution {
	public static int matrixMultiplication(int[] arr , int n) {
		int[][] dp=new int[n][n];
		for(int[] d: dp) Arrays.fill(d,-1);
		return MCM(arr, 1 , n-1 , dp);
	}
	private static int MCM(int[] arr , int i , int j , int[][] dp){
		//base case if we got single matrix return 0 as there are no other matrix to perform operations;
		if(i==j) return 0;

		if(dp[i][j] !=-1) return dp[i][j];
		
		long min=Long.MAX_VALUE;

		for(int k=i; k<=j-1 ;k++){
			long operations = (long)arr[i-1]* arr[k] * arr[j] + MCM(arr , i,k , dp) + MCM(arr ,k+1 , j ,dp);
			min=Math.min(min , operations);
		}
		return dp[i][j] = (int)min;
	}
}
