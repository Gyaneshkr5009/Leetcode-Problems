//time Complexity:O(n);
//space Complexity:O(1);
//approach : using prefixSum Method and normal mathematical operation as they say
//***********************************************************************************************************
class Solution {
    public int minimumAverageDifference(int[] nums) {
        if(nums==null || nums.length==0) return 0;
        int n =nums.length;
        long totalSum=0;
        for(int i=0 ;i<n; i++){
            totalSum+=nums[i];
        }
        //now we have theprefix sum so we iterate once more and check 
        // if (prefixSum[i] > prefixSum[n-1] - prefixSum[i];
        int idx=0 , min=Integer.MAX_VALUE;
        long sum=0;
        for(int i=0; i<n ;i++){
            sum+=nums[i];
            long leftAverage=sum/(i+1);
            long rightAverage= (i == n-1)?0:(totalSum-sum)/(n-i-1);
            if(Math.abs(leftAverage - rightAverage) < min){
                min=(int)Math.abs(leftAverage - rightAverage);
                idx=i;
            }
        }
        return idx;
    }
}
