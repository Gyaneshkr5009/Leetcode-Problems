class Solution {
    public int removeDuplicates(int[] nums) {
        int i=0;
        //if we got a number that is unique we simply add to the front of ith index and then move index i;
        for(int j=1;j<nums.length;j++){
            if(nums[j]!=nums[i]){
                nums[i+1]=nums[j];
                i++;
            }
        }
        return i+1;
    }
}
