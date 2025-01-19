class Solution {
    public int maxAdjacentDistance(int[] nums) {
        if(nums==null || nums.length==0) return 0;
        int max=Math.abs(nums[nums.length-1]-nums[0]);
        for(int i=1;i<nums.length;i++){
            max=Math.max(max , Math.abs(nums[i]-nums[i-1]));
        }
        return max;
    }
}
