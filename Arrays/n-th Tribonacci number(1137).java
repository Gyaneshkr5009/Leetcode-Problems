class Solution {
    public int tribonacci(int n) {
        if(n==0) return 0;
        if(n==1 || n==2) return 1;
        int[] dp=new int[n+1];
        dp[1]=1;
        dp[2]=1;
        return helper(n , dp);
    }
    private int helper(int n , int[] dp){
        if(n<0) return 0;
        if(dp[n]!=0) return dp[n];
        return dp[n]=helper(n-1 , dp)+helper(n-2,dp)+helper(n-3,dp);
    }
}
