//****************************************************(memoization)**********************************
public class Solution {
	public static int maximumNonAdjacentSum(ArrayList<Integer> nums) {
		int n=nums.size();
		int[] dp=new int[n];
		Arrays.fill(dp , -1);
		return solve(n-1 , nums , dp);
	}
	private static int solve(int idx , ArrayList<Integer> nums , int[] dp){
		if(idx==0) return nums.get(idx);
		if(idx<0) return 0;
		if(dp[idx]!=-1) return dp[idx];

		//pick
		int pick=nums.get(idx) + solve(idx-2 , nums ,dp);
		//notPick
		int notPick=solve(idx-1 , nums ,dp);
		return dp[idx]=Math.max(pick , notPick);
	}
}

//***************************************************(tabulation)***********************************
public class Solution {
	public static int maximumNonAdjacentSum(ArrayList<Integer> nums) {
		int n=nums.size();
		int[] dp=new int[n];
		dp[0]=nums.get(0);
		for(int i=1;i<nums.size();i++){
			int pick=nums.get(i);
			if(i>1) pick+=dp[i-2];
			int notPick=dp[i-1];
			dp[i]=Math.max(pick , notPick);
		}
		return dp[n-1];
	}
	
}
