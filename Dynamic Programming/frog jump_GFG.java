class Solution {
    int minCost(int[] height) {
        int[] dp=new int[height.length+1];
        return solve(height.length-1 , dp , height);
    }
    private int solve(int idx , int[] dp , int[] height){
        if(dp[idx]!=0) return dp[idx];
        if(idx==0) return 0;
        
        int left=solve(idx-1 , dp , height) + Math.abs(height[idx-1] - height[idx]);
        int right=Integer.MAX_VALUE;
        if(idx>1){
            right=solve(idx-2 , dp , height) + Math.abs(height[idx-2] - height[idx]);
        }
        return dp[idx]=Math.min(left , right);
    }
}
