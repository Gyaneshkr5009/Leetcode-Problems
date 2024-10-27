//time complexity = O(n*m)  = space complexity;
//******************************************************************(Optimal approach using Dynamic programming)*************************************
class Solution {
    int n,m;
    public int countSquares(int[][] matrix) {
        if(matrix==null || matrix.length==0) return 0;
        n=matrix.length;
        m=matrix[0].length;

        //filling dp with -1;
        int[][] dp =new int[n][m];
        for(int[] a:dp){
            Arrays.fill(a , -1);
        }

        int cntSqr=0;
        for(int i=0;i<n;i++){
            for(int j=0 ; j<m ;j++){
                if(matrix[i][j]==1){
                    cntSqr+=solve(i , j , matrix, dp);
                }
            }
        }
        return cntSqr;
    }
    //we will call solve fuctn that will check(horizontally , vertically and diagonal) through recursion and pass all squares with the src node , and if any node is 0 return 0 as no squares can be formed;

    private int solve(int row , int col , int matrix[][] , int[][] dp){
        if(row>=n || col >=m) return 0;
        if(matrix[row][col]==0) return 0;
        if(dp[row][col]!=-1) return dp[row][col];

        //these right, diag, and below state how many one on there right so if both provide 2 means 2 square can be formed; and if every direction provide different no of nodes then take min of them cause min sqr can be formed;
        int rightSqr=solve(row , col+1 , matrix ,dp);
        int diagonalSqr=solve(row+1 , col+1 , matrix,dp);
        int belowSqr=solve(row+1 , col , matrix,dp);

        // +1 because it include itself when returning all squares;
        return dp[row][col] = 1+Math.min(rightSqr , Math.min(diagonalSqr , belowSqr));
    }
}


//****************************************************************(Brute Force Approach)************************************************************
class Solution {
    int n,m;
    public int countSquares(int[][] matrix) {
        if(matrix==null || matrix.length==0) return 0;
        n=matrix.length;
        m=matrix[0].length;

        int cntSqr=0;
        for(int i=0;i<n;i++){
            for(int j=0 ; j<m ;j++){
                if(matrix[i][j]==1){
                    cntSqr+=solve(i,j,matrix);
                }
            }
        }
        return cntSqr;
    }
    //we will call solve fuctn that will check(horizontally , vertically and diagonal) through recursion and pass all squares with the src node , and if any node is 0 return 0 as no squares can be formed;

    private int solve(int row , int col , int matrix[][]){
        if(row>=n || col >=m) return 0;
        if(matrix[row][col]==0) return 0;

        //these right, diag, and below state how many one on there right so if both provide 2 means 2 square can be formed; and if every direction provide different no of nodes then take min of them cause min sqr can be formed;
        int rightSqr=solve(row , col+1 , matrix);
        int diagonalSqr=solve(row+1 , col+1 , matrix);
        int belowSqr=solve(row+1 , col , matrix);

        // +1 because it include itself when returning all squares;
        return 1+Math.min(rightSqr , Math.min(diagonalSqr , belowSqr));
    }
}
