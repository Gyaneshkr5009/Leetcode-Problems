//*******************************************************************************************
//bitonic means a series that goes on increasing then decreasing or simply increasing from both side like a mountain;
// eq: 1,2,3,5,7,6,4,3,2,1;   <== this is bitonic 
// eq2: 1,2,3,4,5,6,7,3 ; this is also bitonic
// eq3: 1,2,3,4 or 4,3,2,1 these are also bitonic; which has a peak at the end or at the end;
class Solution {
    //approach
    public int minimumMountainRemovals(int[] nums) {
        int n=nums.length;

        //this sp is to calculate the LIS rom front;
        int[] dp=new int[n];
        for(int i=0;i<n;i++){
            dp[i]=1;
            for(int j=0 ; j<i ;j++){
                if(nums[j] < nums[i] && dp[j]+1 > dp[i]){
                    dp[i]=1+dp[j];
                }
            }
        }

        //this dp is to calculate the LIS from the back;
        int[] dp2=new int[n];
        for(int i=n-1;i>=0;i--){
            dp2[i]=1;
            for(int j=n-1 ; j>i ;j--){
                if(nums[j] < nums[i] && dp2[j]+1 > dp2[i]){
                    dp2[i]=1+dp2[j];
                }
            }
        }

        int length=0;
        // we check from index 1 to n-2 as the mountains can't be at start or end;  
        for(int i=1;i<n-1;i++){
            if(dp[i]>1 && dp2[i]>1){
                length =Math.max(length, dp[i] + dp2[i] -1);
            }
        }
        // To make a mountain array, remove elements not part of the longest bitonic subsequence.
        // So, result = total length - max bitonic length.
        return n-length;
    }

}
