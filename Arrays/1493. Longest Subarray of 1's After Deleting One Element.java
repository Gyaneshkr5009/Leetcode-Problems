class Solution {
    public int longestSubarray(int[] nums) {
        int n=nums.length;
        int left=0 , right=0 , window=0;

        int cnt0=0;
        while(right<n){
            if (nums[right] == 0) {
                cnt0++;
            }
            while (cnt0 > 1) {
                if (nums[left] == 0) {
                    cnt0--;
                }
                left++;
            }
            window = Math.max(window, right - left);
            right++;
        }
        return window;
    }
}
