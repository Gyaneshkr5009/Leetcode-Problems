class Solution {
    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n=nums.length;
        int q=queries.length;
        int[] diff=new int[n];
        for(int[] query:queries){
            int s=query[0];
            int r=query[1];
            diff[s]+=1;
            if(r+1<n) diff[r+1]-=1;
        }
        //finding the cummulative sum of all index;
        int sum=0;
        for(int i=0;i<n;i++){
            sum+=diff[i];
            diff[i]=sum;
            if(nums[i]-diff[i]>0) return false;
        }
        return true;
    }
}
