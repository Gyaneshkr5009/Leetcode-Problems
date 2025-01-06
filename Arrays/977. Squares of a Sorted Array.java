class Solution {
    public int[] sortedSquares(int[] nums) {
        if(nums==null || nums.length==0) return nums;

        int left=0 , right=nums.length-1;
        int[] res = new int[nums.length];
        int idx = right;
        while(left<=right){
            int sqr1=nums[left]*nums[left];
            int sqr2=nums[right]*nums[right];
            if(sqr1>sqr2){
                res[idx]=sqr1;
                left++;
            }
            else {
                res[idx]=sqr2;
                right--;
            }
            idx--;
        }
        return res;
    }
}
