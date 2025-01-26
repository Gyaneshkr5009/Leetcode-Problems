class Solution {
    public int countPartitions(int[] nums) {
        int totalSum=0;
        int cnt=0, sum=0 , n=nums.length;
        for(int i=0;i<n;i++){
            totalSum+=nums[i];
        }
        for(int i=0;i<n-1;i++){
            sum+=nums[i];
            totalSum-=nums[i];
            if((totalSum-sum)%2==0) cnt++;
        }
        return cnt;
    }
}
