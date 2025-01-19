class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target + 1];
        Arrays.fill(dp, -1);
        dp[0]=-1;
        return helper(nums, target, dp);
    }
    private int helper(int[] nums, int target, int[] dp) {
        if(target<0) return 0;
        if(target==0) dp[target]=1;
        if(dp[target]!=-1) return dp[target];
        int cnt=0;
        for(int num:nums){
            cnt+=helper(nums, target-num , dp);
        }
        dp[target]=cnt;
        return dp[target];
    }
}
