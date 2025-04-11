class Solution {
    public int minPathSum(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;

        Integer[][] dp=new Integer[n][m];
        return solve(grid , n-1 , m-1 , dp , n , m);
    }
    int[][] dir={{-1,0} , {0,-1}};
    private int solve(int[][] grid , int row ,int col , Integer[][] dp , int n , int m){
        if(row==0 && col==0) return grid[row][col];
        if(dp[row][col]!=null) return dp[row][col];

        int min=(int)1e7;
        for(int[] d:dir){
            int nRow=row+d[0];
            int nCol=col+d[1];
            if(nRow>=0 && nCol>=0 && nRow<n && nCol<m){
                min=Math.min(min , solve(grid , nRow , nCol , dp , n , m));
            }
        }
        return dp[row][col]=grid[row][col]+min;
    }
}
