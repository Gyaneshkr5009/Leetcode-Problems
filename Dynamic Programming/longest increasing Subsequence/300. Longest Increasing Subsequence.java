//*******************************************(memoization)**********************************
class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;

        int[][] dp=new int[n][n+1];
        for(int[] row:dp) Arrays.fill(row , -1);

        return findLIS(n-1 , nums, -1 ,dp);
    }
    private int findLIS(int idx , int[] nums ,int prev , int[][] dp){
        if(idx < 0) return 0;

        if (dp[idx][prev + 1] != -1) return dp[idx][prev + 1];

        //pick
        int pick=0;
        if(prev == -1 || nums[idx]<nums[prev]){
            pick=1 + findLIS(idx-1 , nums, idx , dp);
        }
        
        //not pick
        int notPick=findLIS(idx-1 , nums , prev , dp);

        return dp[idx][prev+1] = Math.max(pick , notPick);
    }
}
//***************************************(tabulation)*********************************
class Solution {
    public int lengthOfLIS(int[] nums) {
        int n=nums.length;

        int[][] dp=new int[n+1][n+1];
        
        for(int idx=n-1; idx >=0 ;idx--){
            for(int prev=idx-1;prev>=-1 ;prev--){
                //pick
                int pick=0;
                if(prev == -1 || nums[idx] > nums[prev]){
                    pick=1 + dp[idx+1][idx+1];
                }
                
                //not pick
                int notPick=dp[idx+1][prev+1];
                dp[idx][prev+1]=Math.max(pick , notPick);
            }
        }

        return dp[0][0];
    }
}
