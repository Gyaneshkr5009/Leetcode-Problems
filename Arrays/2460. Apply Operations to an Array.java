class Solution {
    public int[] applyOperations(int[] nums) {
        int n=nums.length;
        int[] ans=new int[n];
        int idx=0;
        for(int i=0;i<n-1;i++){
            if(nums[i]==0) continue;
            if(nums[i] == nums[i+1]){
                ans[idx++]=nums[i]*2;
                nums[i+1]=0;
            }
            else ans[idx++]=nums[i];
        }
        if(nums[n-1]!=0) ans[idx++]=nums[n-1];
        return ans;
    }
}
