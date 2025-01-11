//time complexity:O(n);
//spcae complexity:O(1);
//******************************************************************************
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n=nums.length ,mul=1;
        if(nums==null || n==0) return nums;
        int zeroFlag=0;
        for(int i:nums){
            if(i!=0) mul*=i; //we prevent our mul from zero as that can lead to 0;
            if(i==0) zeroFlag++;
        }
        if(zeroFlag>1){
            Arrays.fill(nums , 0);
            return nums;
        }
        for(int i=0 ; i<n ; i++){
            if(nums[i]==0) nums[i]=mul;
            else if(zeroFlag==1) nums[i]=0;
            else nums[i]=mul/nums[i];
        }
        return nums;
    }
}
