//******************************************(memoization)*********************
//tine complexity:O(n*target)
//space complexity:O(n*target) + O(auxilary stack space(n));
import java.util.*;
public class Solution {
    public static int unboundedKnapsack(int n, int w, int[] profit, int[] weight) {
        int[][] dp=new int[n][w+1];
        for(int[] d:dp) Arrays.fill(d, -1);

        return solve(w , profit , weight , n-1 ,dp);
    }
    private static int solve(int target ,int[] profit , int[] weight , int idx , int[][] dp){
        if(target==0) return 0;
        if(idx==0){
            if(target%weight[0]==0) return (target/weight[0])*profit[0];
            else return 0;
        }

        if(dp[idx][target]!=-1) return dp[idx][target];
        //not pick
        int notPick=solve(target , profit , weight , idx-1 ,dp);
        int pick=0;
        if(weight[idx]<=target){
            pick=solve(target-weight[idx] , profit , weight , idx , dp)+profit[idx];
        }
        return dp[idx][target] = Math.max(pick , notPick);
    }
}
//**************************************************(tabulation)*******************************************
//time complexity:O(n*target);
//space complexity:O(n*target);
import java.util.*;
public class Solution {
    public static int unboundedKnapsack(int n, int w, int[] profit, int[] weight) {
        int[][] dp=new int[n][w+1];

        for(int i=1;i<=w;i++){
            if(i%weight[0]==0) dp[0][i]=(i/weight[0])*profit[0];
            else dp[0][i]=0;
        }

        for(int i=0;i<n;i++){
            if(w==0) dp[i][0]=0;
        }

        for(int i=1;i<n;i++){
            for(int wt=1; wt<=w ;wt++){
                //not pick
                int notPick=dp[i-1][wt];
                //pick
                int pick=0;
                if(weight[i]<=wt){
                    pick=dp[i][wt - weight[i]] + profit[i];
                }
                dp[i][wt]=Math.max(pick , notPick);
            }
        }

        return dp[n-1][w];
    }
}
//***********************************************(tabulation + space optimization)********************
//time complexity:O(n*target);
//space complexity:O(target);
import java.util.*;
public class Solution {
    public static int unboundedKnapsack(int n, int w, int[] profit, int[] weight) {
        int[] prev=new int[w+1];

        for(int i=0;i<=w;i++){
            if(i%weight[0]==0) prev[i]=(i/weight[0])*profit[0];
            else prev[i]=0;
        }

        for(int i=1;i<n;i++){
            int[] curr=new int[w+1];
            curr[0]=0;
            for(int wt=1; wt<=w ;wt++){
                //not pick
                int notPick=prev[wt];
                //pick
                int pick=0;
                if(weight[i]<=wt){
                    pick=curr[wt - weight[i]] + profit[i];
                }
                curr[wt]=Math.max(pick , notPick);
            }
            prev=curr;
        }

        return prev[w];
    }
}
