class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int max=Integer.MIN_VALUE;
        for(int num:nums){
            max=Math.max(num , max);
        }
        int l=1 , r=max , ans=0;

        while(l<=r){
            int mid=l+(r-l)/2;
            if(isPossible(nums , maxOperations , mid)){
                r=mid-1;
                ans=mid;
            }
            else l=mid+1;
        }
        return ans;
    }

    private boolean isPossible(int[] nums , int maxOperations, int mid){
        int totalOps=0;
        for(int num:nums){
            int ops=num/mid;
            if(num%mid==0) ops-=1;
            totalOps+=ops;
        }
        if(totalOps>maxOperations) return false;
        return true;
    }
}
