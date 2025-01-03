//time complexity:o(n);
//space complexity:(1);
//approach :- we precompute the totalSum then subtracting with current sum to check if current sum is still bigger or not;

//****************************************************************************************************************************
class Solution {
    public int waysToSplitArray(int[] nums) {
        if(nums==null || nums.length==0) return 0;
        int n =nums.length;
        long totalSum=0;
        for(int i=0 ;i<n; i++){
            totalSum+=nums[i];
        }
        //now we have theprefix sum so we iterate once more and check 
        // if (prefixSum[i] > prefixSum[n-1] - prefixSum[i];
        int count=0  ;
        long sum=0;
        for(int i=0; i<n-1 ;i++){
            sum+=nums[i];
            if(sum >= totalSum-sum) count++;
        }
        return count;
    }
}

//******************************************************************************************************************************
//time complexity: same;
//space complexity:O(n);
//approach : also same;

class Solution {
    public int waysToSplitArray(int[] nums) {
        if(nums==null || nums.length==0) return 0;
        int n =nums.length;
        long[] prefixSum=new long[n];
        long sum=0;
        for(int i=0 ;i<n; i++){
            sum+=nums[i];
            prefixSum[i]=sum;
        }
        //now we have theprefix sum so we iterate once more and check 
        // if (prefixSum[i] > prefixSum[n-1] - prefixSum[i];
        int count=0;
        for(int i=0; i<n-1 ;i++){
            if(prefixSum[i] >= (prefixSum[n-1] - prefixSum[i])){
                count++;
            }
        }
        return count;
    }
}
