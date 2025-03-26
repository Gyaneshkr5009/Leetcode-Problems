class Solution {
    public int minMoves2(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        int median=nums[n/2];

        int cnt=0;
        for(int num:nums){
            int diff=Math.abs(num-median);
            cnt+=diff;
        }
        return cnt;
    }
}
