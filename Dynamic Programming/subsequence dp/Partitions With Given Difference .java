import java.util.* ;
import java.io.*; 
public class Solution {
	public static int countPartitions(int n, int d, int[] arr) {
		int totalSum=0;
		for(int num:arr) totalSum+=num;
		if(totalSum-d<0 || (totalSum-d)%2==1) return 0;
		int target=(totalSum-d)/2;

		Integer[][] dp=new Integer[n][target+1];
		return solve(arr , dp , n-1 , target);
	}
	private static int solve(int[] nums, Integer[][] dp , int idx ,int target){
        if (idx == 0) {
            if(nums[0]==0 && target==0) return 2;
            if(target==0 || target==nums[0]) return 1;
            return 0;
        }
        if(dp[idx][target]!=null) return dp[idx][target];

        int notPick= solve(nums , dp , idx-1,target);
        int pick=0;
        if(nums[idx]<=target) pick = solve(nums, dp , idx-1 , target-nums[idx]);
        return dp[idx][target]=(pick + notPick);
    }
}
