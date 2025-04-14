//***********************************(memoization)*********************************************
//time complexity:O(n*amount);
//space complexity:O(n*amount) + O(amount);

class Solution {
    //memoization
    public int change(int amount, int[] coins) {
        int n= coins.length;
        int[][] dp=new int[n][amount+1];
        for(int[] a:dp) Arrays.fill(a,-1);

        return solve(amount , coins , n-1 , dp);
    }
    private int solve(int amount , int[] coins , int idx , int[][] dp){
        if(amount==0) return 1;
        if(idx==0){
            if((amount % coins[0])==0) return 1;
            else return 0;
        }
        if(dp[idx][amount]!=-1) return dp[idx][amount];
        //not pick
        int notPick=solve(amount , coins , idx-1 , dp);
        //pick
        int pick=0;
        if(coins[idx]<=amount){
            pick =solve(amount - coins[idx] , coins , idx , dp);
        }

        return dp[idx][amount] = pick+notPick;
    }
}
//*********************************************************(tabulation)**********************************************
//time complexity:O(n*amount)
//space complexity:O(n*amount);

class Solution {
    //tabulation
    public int change(int amount, int[] coins) {
        int n= coins.length;
        int[][] dp=new int[n][amount+1];

        for(int i=0;i<n;i++){
            dp[i][0]=1;
        }
        for(int a=1 ; a <= amount ; a++){
            if(a % coins[0] == 0) dp[0][a]=1;
        }

        for(int i=1;i<n;i++){
            for(int target=1;target<= amount ;target++){
                //not pick
                int notPick=dp[i-1][target];
                //pick
                int pick=0;
                if(coins[i]<=target){
                    pick = dp[i][target-coins[i]];
                }
                dp[i][target]=pick+notPick;
            }
        }

        return dp[n-1][amount];
    }
}
//***************************************(tabulation + space optimization)*************************************
//time complexity:O(n*amount);
//space complexity:O(amount);


class Solution {
    //tabulation + space optimization;
    public int change(int amount, int[] coins) {
        int n= coins.length;
        int[] prev=new int[amount+1];
        
        for(int a=0 ; a <= amount ; a++){
            if(a % coins[0] == 0) prev[a]=1;
        }

        for(int i=1;i<n;i++){
            int[] curr=new int[amount+1];
            curr[0]=1;
            for(int target=1;target<= amount ;target++){
                //not pick
                int notPick=prev[target];
                //pick
                int pick=0;
                if(coins[i]<=target){
                    pick = curr[target-coins[i]];
                }
                curr[target]=pick+notPick;
            }
            prev=curr;
        }

        return prev[amount];
    }
}
