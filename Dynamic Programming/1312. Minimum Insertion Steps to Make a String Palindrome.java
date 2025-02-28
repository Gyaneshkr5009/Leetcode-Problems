class Solution {
    public int minInsertions(String s) {
        String reverse =new StringBuilder(s).reverse().toString();
        int n=s.length();
        int[][] dp= new int[n][n];
        for(int[] a:dp) Arrays.fill(a ,-1);
        return n-helper(s , reverse , n-1 , n-1 , dp);
    }
    private int helper(String s , String rev , int idx1,  int idx2 , int[][] dp){
        if(idx1<0 || idx2<0) return 0;
        if(dp[idx1][idx2]!=-1) return dp[idx1][idx2];
        //for pick
        if(s.charAt(idx1)==rev.charAt(idx2)){
            dp[idx1][idx2]= 1+ helper(s, rev , idx1-1 , idx2-1 , dp);
        }
        else dp[idx1][idx2]=Math.max(helper(s, rev , idx1-1 , idx2 , dp) , helper(s, rev , idx1 , idx2-1 , dp));
        return dp[idx1][idx2];
    }
}
