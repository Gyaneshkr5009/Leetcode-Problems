//**********************************************************(tabulation)********************************************
class Solution {
    public String shortestCommonSupersequence(String str1, String str2) {
        int n=str1.length() , m=str2.length();
        char[] arr1=str1.toCharArray();
        char[] arr2=str2.toCharArray();
        int[][] dp=new int[n+1][m+1];

        for(int i=1;i<=n;i++){
            for(int j=1;j<=m;j++){
                if(arr1[i-1]==arr2[j-1]){
                    dp[i][j]=1+dp[i-1][j-1];
                }
                else dp[i][j]=Math.max(dp[i-1][j] , dp[i][j-1]);
            }
        }

        StringBuilder sb=new StringBuilder();
        int i=n , j=m;
        while(i>0 && j>0){
            if(arr1[i-1]==arr2[j-1]){
                sb.append(arr1[i-1]);
                i--;
                j--;
            }
            else {
                if(dp[i-1][j] > dp[i][j-1]){
                    sb.append(arr1[i-1]);
                    i--;
                }
                else {
                    sb.append(arr2[j-1]);
                    j--;
                }
            }
        }
        while(i>0) {
            sb.append(arr1[i-1]);
            i--;
        }
        while(j>0) {
            sb.append(arr2[j-1]);
            j--;
        }
        return sb.reverse().toString();
    }
}
