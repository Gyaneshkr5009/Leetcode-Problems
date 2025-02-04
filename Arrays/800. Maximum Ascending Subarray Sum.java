class Solution {
    public int maxAscendingSum(int[] nums) {
        int left=0 , right=1;
        int sum=nums[left] , ans=nums[left];
        while(right<nums.length){
            if(nums[left]<nums[right]){
                sum+=nums[right];
                left++;
            }
            else{
                left=right;
                ans=Math.max(sum , ans);
                sum=nums[left];
            }
            right++;
        }
        ans=Math.max(ans, sum);
        return ans;
    }
}
