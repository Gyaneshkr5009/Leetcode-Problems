class Solution {
    private int expressions=0;
    public int findTargetSumWays(int[] nums, int target) {
        if(nums==null || nums.length==0) return 0;
        int sum=0;
        findExpression(nums , target ,0 , sum);
        return expressions;
    }

    private void findExpression(int[] nums , int target , int idx , int sum){
        if(idx>=nums.length && sum==target){
            expressions++;
            return;
        }
        if(idx<nums.length) findExpression(nums , target , idx+1 , sum-nums[idx]);
        if(idx<nums.length) findExpression(nums , target , idx+1 , sum+nums[idx]);
    }
}

//***************************************************************************************************************************
class Solution {
    private int S;

    private int solve(int[] nums, int target, int i, int sum, int[][] t) {
        if (i == nums.length) {
            return sum == target ? 1 : 0;
        }

        if (t[i][sum + S] != Integer.MIN_VALUE) {
            return t[i][sum + S];
        }

        int plus = solve(nums, target, i + 1, sum + nums[i], t);
        int minus = solve(nums, target, i + 1, sum - nums[i], t);

        return t[i][sum + S] = plus + minus;
    }

    public int findTargetSumWays(int[] nums, int target) {
        int n = nums.length;
        S = Arrays.stream(nums).sum();
        int[][] t = new int[n][2 * S + 1];

        for (int[] row : t) {
            Arrays.fill(row, Integer.MIN_VALUE);
        }

        return solve(nums, target, 0, 0, t);
    }
}
