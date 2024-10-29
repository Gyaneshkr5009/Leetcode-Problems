//time Complexity =(n*m) = space Complexity;
//************************************************************************************************(Dp)**********************************************
class Solution {
    public int maxMoves(int[][] grid) {
        if(grid==null || grid.length==0) return 0;
        int n = grid.length , m =grid[0].length;
        // we will strt from the last col from last to first and store the step of all row element in a col;
        
        int[][] dp =new int[n][m]; // all grid with initially with 0;

        int maxSteps=0;
        for(int col=m-2 ; col>=0 ;col--){
            //move to all rows in a particular column that strts from 2nd last col;
            //as all row elements in last col have 0 steps , as there is noone after them to move, they are the last one;
            for(int row=0 ;row<n ;row++){
                //checking for the top-right;
                if(row>0 && grid[row][col] < grid[row-1][col+1]){
                    dp[row][col] = Math.max(dp[row][col] , dp[row-1][col+1]+1);
                }

                //now checking for the right one;
                if(grid[row][col] < grid[row][col+1]){
                    dp[row][col] = Math.max(dp[row][col] , dp[row][col+1]+1);
                }

                //checking for the bottom-right one;
                if(row<n-1 && grid[row][col] < grid[row+1][col+1]){
                    dp[row][col] = Math.max(dp[row][col] , dp[row+1][col+1] + 1);
                }
            }
        }
        //now we have all max steps stores in 1st column , so we fin the max one among all rows in 0th col;
        //read the whole question;
        for(int row=0 ;row<n;row++){
            maxSteps=Math.max(maxSteps, dp[row][0]);
        }
        return maxSteps;
    }
}
//***********************************************************************(Optimal Approach)********************************************************
//Time Complexity: O(n×m)
//Space Complexity: O(n×m)
class Solution {
    public int maxMoves(int[][] grid) {
        if(grid==null || grid.length==0) return 0;
        int n=grid.length;
        int m =grid[0].length;

        int[][] dp =new int[n][m];
        for(int[] a:dp){
            Arrays.fill(a , -1);
        }

        int ans=0;
        for(int row=0 ; row<n ;row++){
            ans=Math.max(ans , dfs(row , 0 , grid , dp));
        }
        return ans;
    }

    private int[] dir={-1 ,0 , 1};
    private int dfs(int row , int col , int[][] grid , int[][]dp){
        int moves=0;
        if(dp[row][col]!=-1) return dp[row][col];
        for(int i=0 ;i< 3 ;i++){
            int nRow=row+dir[i];
            int nCol=col+1;
            if(nRow>=0 && nRow<grid.length && nCol>=0 && nCol<grid[0].length && grid[row][col] <  grid[nRow][nCol]){
                moves=Math.max(moves , dfs(nRow , nCol , grid , dp) + 1);
            }
        }
        return dp[row][col] = moves;
    }
}
