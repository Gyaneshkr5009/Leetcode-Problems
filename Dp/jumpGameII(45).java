//time complexity : O(n^2)
//space complexity:O(n)

//*************************************************************(Brute Force Approach)***********************************************************************
class Solution {
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, -1);
        if(nums==null || nums.length==0) return 0;
        return fuctn(nums , 0 ,dp);
    }
    private int fuctn(int[] nums , int idx , int[] dp ){
        if(idx>=nums.length-1) return dp[idx];
        if(dp[idx]!=-1) return dp[idx];
        int min = Integer.MAX_VALUE;
        for(int i=1 ;i<=nums[idx] ;i++){
            int jumps=fuctn(nums , idx+i , dp);
            if (jumps != Integer.MAX_VALUE) {
                min = Math.min(min, jumps + 1);
            }
        }
        dp[idx]=min;
        return dp[idx];
    }
}
//***********************************************************(optimal approach)*****************************************************************************
//time complexity:O(n)
//space complexity:O(1)

class Solution {
    public int jump(int[] nums) {
        int start=0 , range=0 , jumps=0;
        while(range < nums.length-1){
            int farthest=0;
            for(int i=start ;i<=range ;i++){
                farthest=Math.max(farthest , i+nums[i]);
            }
            start=range+1;
            range=farthest;
            jumps++;
        }
        return jumps;
    }
}
