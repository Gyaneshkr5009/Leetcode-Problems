class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp=new int[m][n];
        for(int[] a:dp){
            Arrays.fill(a ,-1);
        }
        return solve(m-1 , n-1 , dp , m , n);
    }
    private int[][] dir={{-1 ,0} , {0,-1}};
    private int solve(int row , int col , int[][] dp , int m , int n){
        //base case
        if(row==0 && col==0){
            return 1;
        }
        if(dp[row][col]!=-1) return dp[row][col];
        int ans=0;
        for(int[] d:dir){
            int nRow=row+d[0];
            int nCol=col+d[1];
            if(nRow<m && nRow>=0 && nCol<n && nCol>=0){
                ans+=solve(nRow , nCol , dp , m , n);
            }
        }
        return dp[row][col]=ans;
    }
}
