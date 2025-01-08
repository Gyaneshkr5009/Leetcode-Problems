class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        if(nums==null || nums.length==0) return 0;
        int n=nums.length , res=Integer.MAX_VALUE;
        int left=0 , right=n-1 , sum=0;

        for(right=0 ; right<n; right++){
            sum+=nums[right];
            while(sum>=target){
                res=Math.min(res , right-left+1);
                sum-=nums[left++];
            }
        }
        return res == Integer.MAX_VALUE?0:res;
    }
}
