
//************************************************(memoization)***************************************
class Solution {
    public int longestCommonSubsequence(String text1, String text2) {
        int n=text1.length() , m =text2.length();
        int[][] dp=new int[n][m];
        for(int[] a:dp){
            Arrays.fill(a , -1);
        }
        return helper(text1 , text2 , n-1 , m-1 , dp);
    }
    private int helper(String str1 , String str2 , int idx1 , int idx2 ,int[][] dp){
        if(idx1 <0 || idx2<0) return 0;
        if(dp[idx1][idx2]!=-1) return dp[idx1][idx2];
        //for match cases;
        if(str1.charAt(idx1) == str2.charAt(idx2)){
            return 1+ helper(str1 , str2 , idx1-1 , idx2-1 ,dp);
        }
        //if not matches;
        else{
            return dp[idx1][idx2]=Math.max(helper(str1 , str2 , idx1-1 , idx2 , dp) , helper(str1 , str2 , idx1 , idx2-1 , dp));
        }
    }
}
