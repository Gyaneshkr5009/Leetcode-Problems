class Solution {
    public int minDistance(String word1, String word2) {
        int n=word1.length() , m=word2.length();
        char[] arr1=word1.toCharArray();
        char[] arr2=word2.toCharArray();
        Integer[][] dp=new Integer[n][m];
        return helper(arr1 , arr2 , n-1 , m-1 , dp);
    }
    private int helper(char[] arr1 , char[] arr2 , int idx1 , int idx2 , Integer[][] dp){
        if(idx1<0){
            return idx2+1;
        }
        if(idx2<0) return idx1+1;

        if(dp[idx1][idx2] != null) return dp[idx1][idx2];

        //if both character matches then shift indexes;
        if(arr1[idx1]==arr2[idx2]) dp[idx1][idx2]=0+helper(arr1 , arr2 , idx1-1 , idx2-1 , dp);
        else{
            //insert operation
            int insert=1+helper(arr1 , arr2, idx1 , idx2-1 , dp);
            //delete operation
            int delete=1+helper(arr1 , arr2, idx1-1 , idx2 , dp);
            //replace
            int replace=1+helper(arr1 , arr2 , idx1-1 , idx2-1 ,dp);
            dp[idx1][idx2]=Math.min(Math.min(insert , delete) , replace);

        }
        return dp[idx1][idx2];
    }
}
