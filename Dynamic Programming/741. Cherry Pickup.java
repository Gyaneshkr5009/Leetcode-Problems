/*
     1. Simulate Both Trips as a Single Journey

    Instead of doing two separate traversals (go & return), you simulate two people moving simultaneously from (0,0) to (n-1,n-1).

    Why this works? Because step count of both is the same: r1 + c1 == r2 + c2.

    You're essentially encoding both trips into a single 3D DP problem, reducing complexity and avoiding double visits.

👬 2. Two People, Same Move Count, Four Possibilities

    You use dfs(r1, c1, r2) — and compute c2 = r1 + c1 - r2.

    This gives 4 ways to move (↓↓, →→, ↓→, →↓) — trying all possible combinations both people can take in lockstep.

    You let the recursion handle all valid paths — the DP ensures overlapping work isn't repeated.

🍒 3. Avoid Double Counting Cherries

    If both are on the same cell (r1 == r2 && c1 == c2), you only count cherry once.

    That simulates first person picking it up on forward path, and on return, the cherry is already gone.

⛔ 4. Handling Invalid Paths

    If any of the four positions (r1, c1, r2, c2) are out of bounds or on a thorn (-1), return -1.

    Also, if no valid moves from a point (max == -1), you mark that state as -1 in memo table and stop going further.

*/

class Solution {
    public int cherryPickup(int[][] grid) {
        int n=grid.length;
        if(grid[0][0]==-1 || grid[n-1][n-1]==-1) return 0;

        Integer[][][] dp=new Integer[n][n][n];
        int res=Math.max(0 , dfs(grid, 0 , 0 ,0 ,dp));
        return res;
    }
    private int dfs(int[][] grid , int r1 , int c1 ,int r2 , Integer[][][] dp){
        int n=grid.length;
        int c2=r1+c1-r2;
        if(c1>=n || r1>=n || r2>=n || c2>=n || grid[r1][c1]==-1 || grid[r2][c2]==-1) return -1;

        if (r1 == n - 1 && c1 == n - 1 && r2 == n-1 && c2 == n-1) {
            return grid[r1][c1];
        }

        if (dp[r1][c1][r2] != null) return dp[r1][c1][r2];

        int cheries=0;
        if(r1==r2 && c1==c2){
            cheries=grid[r1][c1];
        }
        else{
            cheries=grid[r1][c1]+grid[r2][c2];
        }

        int max=Math.max(
            Math.max(dfs(grid, r1+1 , c1 , r2+1,dp) , dfs(grid , r1,c1+1,r2,dp)),
            Math.max(dfs(grid , r1+1 , c1, r2, dp) , dfs(grid , r1 , c1+1 , r2+1 , dp))
        );
        if(max==-1) return dp[r1][c1][r2]=-1;
        return dp[r1][c1][r2]=cheries+max;
    }
}
