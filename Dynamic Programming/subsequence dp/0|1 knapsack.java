//*****************************************************(memoization)**********************************
import java.util.* ;
import java.io.*; 

public class Solution{
    static int knapsack(int[] weight, int[] value, int n, int maxWeight) {
        Integer[][] dp=new Integer[n][maxWeight+1];
        
        return maxSteal(weight , value , maxWeight ,n-1 , dp);
    }
    private static int maxSteal(int[] weight , int[] value , int maxWeight , int idx , Integer[][] dp){
        //base case
        if(idx==0){
            if(weight[0]<=maxWeight) return value[0];
            else return 0;
        }

        if(dp[idx][maxWeight]!=null) return dp[idx][maxWeight];
        //pick
        int pick=Integer.MIN_VALUE;
        if(weight[idx]<=maxWeight){
            pick=maxSteal(weight , value , maxWeight-weight[idx] , idx-1 , dp) + value[idx];
        }
        //not Pick
        int notPick=maxSteal(weight , value , maxWeight , idx-1 , dp);

        return dp[idx][maxWeight]=Math.max(pick , notPick);
    }
}

//*****************************************************(tabulation)******************************************
import java.util.* ;
import java.io.*; 

public class Solution{
    static int knapsack(int[] weight, int[] value, int n, int maxWeight) {
        int[][] dp=new int[n][maxWeight+1];
        for(int w=weight[0];w<=maxWeight;w++){
            dp[0][w]=value[0];
        }

        for(int i=1;i<n;i++){
            for(int w=0; w<=maxWeight;w++){
                int pick=Integer.MIN_VALUE;
                if(weight[i]<=w){
                    pick=dp[i-1][w-weight[i]] + value[i];
                }
                //not Pick
                int notPick=dp[i-1][w];
                dp[i][w]=Math.max(pick , notPick);
            }
        }
        
        return dp[n-1][maxWeight];
    }
}
//************************************************(tabulation + memory Optimize)********************
import java.util.* ;
import java.io.*; 

public class Solution{
    static int knapsack(int[] weight, int[] value, int n, int maxWeight) {
        int[] prev=new int[maxWeight+1];
        for(int w=weight[0];w<=maxWeight;w++){
            prev[w]=value[0];
        }

        for(int i=1;i<n;i++){
            int[] curr=new int[maxWeight+1];
            for(int w=0; w<=maxWeight;w++){
                int pick=Integer.MIN_VALUE;
                if(weight[i]<=w){
                    pick=prev[w-weight[i]] + value[i];
                }
                //not Pick
                int notPick=prev[w];
                curr[w]=Math.max(pick , notPick);
            }
            prev=curr;
        }
        
        return prev[maxWeight];
    }
}
