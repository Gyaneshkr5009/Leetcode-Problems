class Solution {
    public long mostPoints(int[][] questions) {
        if(questions.length==0) return 0;
        int totalSum=0;
        Long[] dp=new Long[questions.length];
        return solve(questions , 0, dp);
    }
    private long solve(int[][] questions , int idx , Long[] dp){
        if(idx>=questions.length) return 0;
        if(dp[idx]!=null) return dp[idx];
        //if we solve that question , then we cant solve the next 2 ;
        long solve=questions[idx][0] + solve(questions , idx+1+questions[idx][1],dp);
        //if skip the question
        long skip=solve(questions , idx+1,dp);
        return dp[idx]=Math.max(solve , skip);
    }
}
