//*******************************************(recursion + memoization)*************************
class Solution {
    public int numDistinct(String s, String t) {
        int n=s.length() , m=t.length();
        Integer[][] dp=new Integer[n][m];
        for(int[] a:dp) Arrays.fill(a,-1);
        return helper(s, t , n-1 , m-1 , dp);
    }
    private int helper(String s , String t , int idx1 , int idx2 , Integer[][] dp){
        if(idx2<0) return 1;
        if(idx1<0) return 0;
        
        if(dp[idx1][idx2]!=-1) return dp[idx1][idx2];
        //if both matches
        if(s.charAt(idx1)==t.charAt(idx2)){
            return dp[idx1][idx2]=helper(s,t ,idx1-1 , idx2 , dp) + helper(s, t, idx1-1 , idx2-1 , dp);
        }
        else return dp[idx1][idx2]=helper(s,t,idx1-1 , idx2 , dp);
    }
}
//*************************************************(tabulation)************************************
class Solution {
    public int numDistinct(String s, String t) {
        int n=s.length() , m=t.length();
        char[] arr1=s.toCharArray();
        char[] arr2=t.toCharArray();
        int[][] dp=new int[n+1][m+1];
        for(int i=0;i<=n;i++){
            dp[i][0]=1;
        }
        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                //if both matches
                if(arr1[i-1]==arr2[j-1]){
                    dp[i][j]=dp[i-1][j]+dp[i-1][j-1];
                }
                else dp[i][j]=dp[i-1][j];
            }
        }
        return dp[n][m];
    }
}
