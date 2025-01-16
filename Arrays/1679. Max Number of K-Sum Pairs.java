class Solution {
    public int maxOperations(int[] nums, int k) {
        int n=nums.length;
        int left=0 , right=n-1 , cnt=0;
        Arrays.sort(nums);
        while(left<right){
            if(nums[left]+nums[right]==k){
                cnt++;
                left++;
                right--;
            }
            else if(nums[left]+nums[right]>k){
                right--;
            }
            else if(nums[left]+nums[right]<k) left++;
        }
        return cnt;
    }
}
