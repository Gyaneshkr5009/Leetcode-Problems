class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        int n=nums.length;
        for(int i=0 ; i< n ;i++){
            if(nums[i]%2==0){
                nums[i]=0;
            }
            else nums[i]=1;
        }
        return atMost(nums , k)-atMost(nums , k-1);
    }
    public int atMost(int [] nums , int k){
        int left=0;
        int right=0;
        int cnt=0;
        int sum=0;
        while(right<nums.length){
            sum+=nums[right++];
            while(left<right && sum>k){
                sum-=nums[left++];
            }
            cnt+=right-left+1;
        }
        return cnt;
    }
}
