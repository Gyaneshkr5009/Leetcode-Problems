//****************************************(tabulation + space optimization)**********************
//time complexity:O(n*amount)
//space complexity:O(amount);
class Solution {
    //tabulation;
    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        int max=Integer.MAX_VALUE;
        int[] prev=new int[amount+1];
        //base case if any amount%Coins[0]==0 means i can get that sum with this number;
        for(int a=0; a <= amount ; a++){
            if(a%coins[0]==0) prev[a]=a/coins[0];
            else prev[a]=max;
        }
        
        
        for(int i=1;i<n;i++){
            int[] curr=new int[amount+1];
            curr[0]=0;
            for(int a=1;a<=amount;a++){
                int notPick=prev[a];
                //pick -> do not decrement the index as i can take it again
                int pick=max;
                if(coins[i]<=a) {
                    int val=curr[a-coins[i]];
                    if(val!=max) pick=1+val;
                }
                curr[a]=Math.min(pick , notPick);
            }
            prev=curr;
        }
        return prev[amount]==max?-1:prev[amount];
    }
}
//**************************************(tabulation)****************************************************
class Solution {
    //tabulation;
    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        int[][] dp=new int[n][amount+1];
        //base case if any amount%Coins[0]==0 means i can get that sum with this number;
        for(int a=0; a <= amount ; a++){
            if(a%coins[0]==0) dp[0][a]=a/coins[0];
            else dp[0][a]=Integer.MAX_VALUE;
        }
        
        
        for(int i=1;i<n;i++){
            for(int a=0;a<=amount;a++){
                int notPick=dp[i-1][a];
                //pick -> do not decrement the index as i can take it again
                int pick=Integer.MAX_VALUE;
                if(coins[i]<=a) {
                    int val=dp[i][a-coins[i]];
                    if(val!=Integer.MAX_VALUE) pick=1+val;
                }
                dp[i][a]=Math.min(pick , notPick);
            }
        }
        return dp[n-1][amount]==Integer.MAX_VALUE?-1:dp[n-1][amount];
    }
    private int solve(int[] coins , int amount ,Integer[][] dp , int idx){
        //base case;
        if(idx==0){
            //if the amount is divisible by 0th index means i can turn it to 0 other wise i can not make it zero;
            if(amount%coins[0]==0) return amount/coins[0];
            else return Integer.MAX_VALUE;
        }
        
        if(dp[idx][amount]!=null) return dp[idx][amount];
        //not pick
        int notPick=solve(coins , amount , dp , idx-1);
        //pick -> do not decrement the index as i can take it again
        int pick=Integer.MAX_VALUE;
        if(coins[idx]<=amount) {
            int val=solve(coins , amount-coins[idx] ,dp , idx);
            if(val!=Integer.MAX_VALUE) pick=1+val;
        }
        return dp[idx][amount]=Math.min(pick , notPick);
    }
}
//*****************************************(memoization)****************************************************
class Solution {
    public int coinChange(int[] coins, int amount) {
        int n=coins.length;
        Integer[][] dp=new Integer[n][amount+1];

        int ans= solve(coins,amount,dp , n-1);
        return ans==Integer.MAX_VALUE?-1:ans;
    }
    private int solve(int[] coins , int amount ,Integer[][] dp , int idx){
        //base case;
        if(idx==0){
            //if the amount is divisible by 0th index means i can turn it to 0 other wise i can not make it zero;
            if(amount%coins[0]==0) return amount/coins[0];
            else return Integer.MAX_VALUE;
        }
        
        if(dp[idx][amount]!=null) return dp[idx][amount];
        //not pick
        int notPick=solve(coins , amount , dp , idx-1);
        //pick -> do not decrement the index as i can take it again
        int pick=Integer.MAX_VALUE;
        if(coins[idx]<=amount) {
            int val=solve(coins , amount-coins[idx] ,dp , idx);
            if(val!=Integer.MAX_VALUE) pick=1+val;
        }
        return dp[idx][amount]=Math.min(pick , notPick);
    }
}
