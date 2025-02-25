class Solution {
    public int cherryPickup(int[][] grid) {
        int m=grid.length , n=grid[0].length;
        int[][][] dp=new int[m][n][n];
        for(int[][] temp:dp){
            for(int[] temp2:temp) Arrays.fill(temp2 , -1);
        }
        return helper(0 , 0 , n-1 , grid , dp , m , n);
    }
    private int helper(int row , int col1 , int col2 , int[][] grid , int[][][] dp , int m , int n){
        if(col1<0 || col2<0 || col1>=n || col2>=n) return Integer.MIN_VALUE;
        if(dp[row][col1][col2]!=-1) return dp[row][col1][col2];
        if(row==m-1){
            if(col1==col2) return grid[row][col1];
            else return grid[row][col1]+grid[row][col2];
        }
        int max=Integer.MIN_VALUE;
        for(int idx=-1 ; idx<=1 ;idx++){
            for(int idx2=-1 ; idx2<=1 ;idx2++){
                int value=0;
                if(col1==col2) return grid[row][col1];
                else value= grid[row][col1]+grid[row][col2];
                value +=helper(row+1 , col1+idx , col2+idx2 , grid , dp , m , n);
                max= Math.max(max , value);
            }
        }
        return dp[row][col1][col2]=max;
    }
}
