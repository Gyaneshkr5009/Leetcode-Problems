//********************************************(tabulation + space optimization)*************************************
class Solution {
    public boolean canPartition(int[] nums) {
        int n=nums.length;
        int totalSum=0;
        for(int s:nums) totalSum+=s;
        if(totalSum%2==1) return false;
        else{
            int k=totalSum/2;
            boolean[] prev=new boolean[k+1];
            prev[0]=true;

            if(nums[0]<=k){
                prev[nums[0]]=true;
            }
            for(int ind=1;ind<n;ind++){
                boolean curr[] = new boolean[k + 1];
                curr[0] = true;
                for(int target=1; target<=k ;target++){
                    boolean notpick=prev[target];
                    boolean pick=false;
                    if(target>=nums[ind]) pick=prev[target-nums[ind]];
                    curr[target]=pick|notpick;
                }
                prev=curr;
            }
            return prev[k];
        }        
    }
}

//********************************************************(tabulation)************************************************
class Solution {
    public boolean canPartition(int[] nums) {
        int n=nums.length;
        int totalSum=0;
        for(int s:nums) totalSum+=s;
        if(totalSum%2==1) return false;
        else{
            int k=totalSum/2;
            boolean[][] dp= new boolean[n][k+1];
            //if my target is zero on any index just it will be true;
            for(int i=0;i<n;i++){
                dp[i][0]=true;
            }
            if(nums[0]<=k){
                dp[0][nums[0]]=true;
            }
            for(int ind=1;ind<n;ind++){
                for(int target=1; target<=k ;target++){
                    boolean notpick=dp[ind-1][target];
                    boolean pick=false;
                    if(target>=nums[ind]) pick=dp[ind-1][target-nums[ind]];
                    dp[ind][target]=pick|notpick;
                }
            }
            return dp[n-1][k];
        }        
    }
}
//*********************************************(memoization)******************************************
class Solution {
    public boolean canPartition(int[] nums) {
        int n=nums.length;
        //doing this is a memoization way bottomup
        //the approach is i have to find the half sum of the total if i found it true else false;
        int sum=0;
        for(int num:nums) sum+=num;
        if(sum%2!=0) return false;
        Boolean[][] dp=new Boolean[n][sum/2+1];

        return checkPossible(nums , dp , sum/2 , n-1);
    }
    private boolean checkPossible(int[] nums ,Boolean[][] dp , int target , int idx){
        if(target==0) return true;
        if(idx<0 || target<0) return false;
        if(dp[idx][target]!=null) return dp[idx][target];
        //pick
        boolean pick=checkPossible(nums, dp , target-nums[idx] , idx-1);
        //not Pick
        boolean notPick=checkPossible(nums, dp , target , idx-1);
        return dp[idx][target]=pick||notPick;
    }
}
