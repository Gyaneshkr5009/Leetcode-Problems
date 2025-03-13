class Solution {
    public int minZeroArray(int[] nums, int[][] queries) {
        //solving using diff array technique;
        int n=nums.length;
        int q=queries.length;
        if(checkZeroArray(nums)) return 0;
        
        //using binary search to optimized answer
        int l=0 , r=q-1 , k=-1;
        while(l<=r){
            int mid=l+(r-l)/2;
            if(checkWithDiffArrayTech(nums , queries ,mid)){//if we got true means there is the possibility so we look for the left;
                r=mid-1;
                k=mid+1;
            }
            else l=mid+1;
        }
        return k;
    }
    private boolean checkZeroArray(int[] nums){
        for(int a:nums) if(a>0) return false;
        return true;
    }
    private boolean checkWithDiffArrayTech(int[] nums, int[][] queries , int mid){
        int n=nums.length;
        int[] diff=new int[n]; // creating a diff array to calculate the variation;
        for(int i=0;i<=mid;i++){
            int strt=queries[i][0];
            int edp=queries[i][1];
            int val=queries[i][2];
            diff[strt]+=val;
            if(edp+1<n) diff[edp+1]-=val;
        }
        //we have calculated cummulative value;
        int cumulative=0;
        for(int i=0;i<n;i++){
            cumulative+=diff[i];
            diff[i]=cumulative;
            if(nums[i]-diff[i]>0) return false;
        }
        return true;
    }
}
