class Solution {
    int[] dp;
    public int minCostClimbingStairs(int[] cost) {
        if(cost==null || cost.length==0) return 0;
        int n=cost.length; // this is the total steps we length of the staircase;
        dp=new int[n];
        return Math.min(helper(cost , n-1) , helper(cost,n-2));
    }
    private int helper(int[] cost , int n){
        if(n<0) return 0;
        if(n==0 || n==1) return cost[n];
        if(dp[n]!=0) return dp[n];
        return dp[n]=cost[n]+Math.min(helper(cost , n-1) ,helper(cost , n-2));
    }
}
***********************************************************************************************************************************
  class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n];
        for (int i=0; i<n; i++) {
            if (i<2) dp[i] = cost[i];
            else dp[i] = cost[i] + Math.min(dp[i-1], dp[i-2]);
        }
        return Math.min(dp[n-1], dp[n-2]);
    }
}
