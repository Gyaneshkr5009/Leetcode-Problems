class Solution {
    public int longestPalindromeSubseq(String s) {
        String reverse=new StringBuilder(s).reverse().toString();
        int n=s.length();
        int[][] dp=new int[n][n];
        for(int[] a:dp) Arrays.fill(a ,-1);
        return solve(n-1 , n-1 , s , reverse , dp);
    }
    private int solve(int idx1 , int idx2 , String s , String reverse , int[][] dp){
        if(idx1 < 0 || idx2<0) return 0;
        if(dp[idx1][idx2]!=-1) return dp[idx1][idx2];

        //pick
        if(s.charAt(idx1)==reverse.charAt(idx2)){
            dp[idx1][idx2]=1+solve(idx1-1 , idx2-1 , s , reverse , dp);
        }
        else {
            dp[idx1][idx2]=Math.max(solve(idx1 , idx2-1 , s , reverse , dp) , solve(idx1-1 , idx2 , s , reverse , dp));
        }
        return dp[idx1][idx2];
    }
}
