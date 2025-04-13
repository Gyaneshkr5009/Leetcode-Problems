import java.util.*;
import java.io.*;

public class Solution {
    public static int findWays(int nums[], int tar) {
        int n=nums.length;
        
        Integer[][] dp=new Integer[n][tar+1];
        return solve(nums , dp , n-1 ,tar);
    }
    static int mod=(int)1e9+7;
    private static int solve(int[] nums, Integer[][] dp , int idx ,int target){
        if (idx == 0) {
            if(nums[0]==0 && target==0) return 2;
            if(target==0 || target==nums[0]) return 1;
            return 0;
        }
        if(dp[idx][target]!=null) return dp[idx][target];

        int notPick= solve(nums , dp , idx-1,target)%mod;
        int pick=0;
        if(nums[idx]<=target) pick = solve(nums, dp , idx-1 , target-nums[idx])%mod;
        return dp[idx][target]=(pick + notPick)%mod;
    }
}
