// time complexity:O(n*m);
//space complexity:O(n*m);
//********************************************(recursion + Memoization)**************************************
class Solution {
    public int minDistance(String word1, String word2) {
        int n=word1.length();
        int m=word2.length();
        char arr[]=word1.toCharArray();
        char arr2[]=word2.toCharArray();
        int[][] dp=new int[n+1][m+1];

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(arr[i-1]==arr2[j-1]){
                    dp[i][j]=1+dp[i-1][j-1];
                }
                else{
                    dp[i][j]=Math.max(dp[i-1][j] , dp[i][j-1]);
                }
            }
        }
        return n+m-2*dp[n][m];
    }
}
