class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int n=nums.length;
        long ans=0;

        int minPos=-1 , maxPos=-1;
        int left=0 ;
        for(int i = 0 ; i < n ; i++){
            //if number is beyond boundary reset everything
            if(nums[i] > maxK || nums[i] < minK){
                left=i+1;
                minPos=-1;
                maxPos=-1;
            }

            if(nums[i] == minK) minPos = i;
            if(nums[i] == maxK) maxPos = i;

            if(minPos != -1 && maxPos != -1 && nums[minPos] == minK && nums[maxPos] == maxK){
                ans+=(Math.min(minPos , maxPos) - left + 1);
            }
        }
        return ans; 
    }
}
