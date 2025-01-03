//time complexity:O(n);
//space complexity:O(1); as i do not use external space but instead i modified the original and return it as a result;
//approach : prefixSum and simple math;
//********************************************************************************************************************
class Solution {
    public int[] leftRightDifference(int[] nums) {
        if(nums==null || nums.length==0) return new int[0];
        int totalSum=0;
        for(int i:nums) totalSum+=i;
        //now we have theprefix sum so we iterate once more and check 
        // if (prefixSum[i] > prefixSum[n-1] - prefixSum[i];
        int count=0  ;
        int leftSum=0;
        for (int i = 0; i < nums.length; i++) {
            int val=nums[i];
            int rightSum = totalSum - leftSum - val;
            nums[i] = Math.abs(rightSum-leftSum);
            leftSum += val;
        }
        return nums;
    }
}

//***********************************************************************************************************
// everything just same except Space complexity :O(n);
class Solution {
    public int[] leftRightDifference(int[] nums) {
        if(nums==null || nums.length==0) return new int[0];
        int totalSum=0;
        for(int i:nums) totalSum+=i;
        //now we have theprefix sum so we iterate once more and check 
        // if (prefixSum[i] > prefixSum[n-1] - prefixSum[i];
        int[] ans=new int[nums.length];
        int count=0;
        int leftSum=0;
        for (int i = 0; i < nums.length; i++) {
            int rightSum = totalSum - leftSum - nums[i];
            ans[i] = Math.abs(rightSum-leftSum);
            leftSum += nums[i];
        }
        return ans;
    }
}
