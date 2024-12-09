class Solution {
    public boolean[] isArraySpecial(int[] nums, int[][] queries) {
        int n=queries.length;
        boolean[] result=new boolean[n];

        int[] breakPoints=new int[nums.length];
        for(int i=1 ; i<nums.length ;i++){
            if(nums[i]%2 == nums[i-1]%2) breakPoints[i]=1;
        }

        int[] prefixSum=new int[nums.length];
        for(int i=1 ; i<nums.length;i++){
            prefixSum[i]=prefixSum[i-1] + breakPoints[i];
        }

        int idx=0;
        for(int[] a:queries){
            int stp=a[0];
            int edp=a[1];
            if(stp<0 || edp>nums.length) result[idx++]=false;
            result[idx++]=prefixSum[edp]-prefixSum[stp]==0;
        }

        return result;
    }
}
