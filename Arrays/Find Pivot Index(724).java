//time Complexity:O(n);
//space complexity:O(1);
//approach : if (totalSum - sum == sum-currentelement);  means(left==right)?yes its a pivot :else not;
//********************************************************************************************
class Solution {
    public int pivotIndex(int[] nums) {
        if(nums==null || nums.length==0) return -1;
        long totalSum=0;
        for(int i:nums) totalSum+=i;

        int sum=0;
        for(int i=0 ; i< nums.length ;i++){
            sum+=nums[i];
            if(sum-nums[i] == totalSum-sum) return i;
        }
        return -1;
    }
}
