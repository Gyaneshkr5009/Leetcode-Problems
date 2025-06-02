class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        int m=grid.length , n=grid[0].length;
        if (grid[0][0] == 1 || grid[m - 1][n - 1] == 1) return 0;
        int[][] dp=new int[m][n];
        for(int[] a:dp){
            Arrays.fill(a ,-1);
        }
        return solve(0,0 ,dp , m , n , grid);
    }
    private int solve(int row , int col , int[][] dp , int m , int n , int[][] grid){
        if(row>=m || col>=n || grid[row][col]==1) return 0;
        //base case
        if (row == m - 1 && col == n - 1) return 1;

        if(dp[row][col]!=-1) return dp[row][col];
        int right = solve(row, col + 1, dp, m, n, grid);
        int down = solve(row + 1, col, dp, m, n, grid);

        return dp[row][col] = right + down;
    }
}
//**********************************************************(tabulation algorithm with only 1D dp)************************
class Solution {
    public int uniquePathsWithObstacles(int[][] grid) {
        int m=grid.length , n=grid[0].length;
        if (grid[0][0] == 1 || grid[m - 1][n - 1] == 1) return 0;

        //going further optimization using 1d dp and two variable;
        int[] dp=new int[n];
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                //base case;
                if(i==0 && j==0){
                    dp[0]=1;
                    continue;
                }
                if(grid[i][j] == 1) {
                    dp[j]=0; //marking that index as 0;
                    continue;
                }

                int top=(i>0) ? dp[j] : 0;
                int left=(j>0) ? dp[j-1] :0;

                dp[j]=top+left;
            }
        }

        return dp[n-1];
    }
}
