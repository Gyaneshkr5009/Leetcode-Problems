//****************************************************(Tabulation)*******************************
class Solution {
    public int maximumJumps(int[] nums, int target) {
        int n = nums.length;
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        dp[0] = 0;

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (Math.abs(nums[j] - nums[i]) <= target && dp[j] != -1) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        return dp[n - 1];
    }
}

//************************************************(Memoization)*********************************
class Solution {
    public int maximumJumps(int[] nums, int target) {
        Integer[] dp= new Integer[nums.length];
        return solve(nums, target , nums.length-1 , dp) ;
    }
    private int solve(int[] nums, int target , int idx , Integer[] dp){
        //base case
        if(idx == 0) return 0;
        if(dp[idx] != null) return dp[idx];
        int ans=-1;
        for(int i=0;i<idx;i++){
            if (Math.abs(nums[i] - nums[idx]) <= target) {
                int sub = solve(nums, target, i, dp);
                if (sub != -1) {
                    ans = Math.max(ans, sub + 1);
                }
            }
        }
        return dp[idx]=ans;
    }
}
//************************************************(Recursion)**********************************
