//*****************************************(memoization)**************************************
class Solution {
    public int maxCoins(int[] nums) {
        int n=nums.length;
        int[] newBaloons=new int[n+2];
        newBaloons[0]=1;
        newBaloons[n+1]=1;
        for(int i=1;i<=n;i++) newBaloons[i]=nums[i-1];

        Integer[][] dp=new Integer[n+1][n+1];

        return maxCoinCollect(1 , n , newBaloons ,dp);
    }

    private int maxCoinCollect(int i , int j , int[] newBaloons , Integer[][] dp){
        //base case
        if(i>j) return 0;
        if(dp[i][j]!=null) return dp[i][j];

        int maxi=Integer.MIN_VALUE;
        for(int k=i; k<=j ;k++){
            //first birst the baloon you wish then solve the left and right one;
            int coins=newBaloons[k]*newBaloons[i-1]*newBaloons[j+1] 
                + maxCoinCollect(i , k-1 , newBaloons ,dp) + maxCoinCollect(k+1 , j , newBaloons , dp);

            maxi=Math.max(maxi , coins);
        }
        return dp[i][j] = maxi;
    }
}
//**********************************************(tabulation)********************************************
class Solution {
    public int maxCoins(int[] nums) {
        int n=nums.length;
        int[] newBaloons=new int[n+2];
        newBaloons[0]=1;
        newBaloons[n+1]=1;
        for(int i=1;i<=n;i++) newBaloons[i]=nums[i-1];

        int[][] dp=new int[n+2][n+2];
        
        for(int i=n ; i>=1 ;i--){
            for(int j=1 ; j<=n ;j++){
                if(i>j) continue;
                int maxi=Integer.MIN_VALUE;
                for(int k=i; k<=j ;k++){
                    //first birst the baloon you wish then solve the left and right one;
                    int coins=newBaloons[k]*newBaloons[i-1]*newBaloons[j+1] 
                        + dp[i][k-1] + dp[k+1][j];

                    maxi=Math.max(maxi , coins);
                }
                dp[i][j]=maxi;
            }
        }

        return dp[1][n];
    }

    private int maxCoinCollect(int i , int j , int[] newBaloons , int[][] dp){
        //base case
        if(i>j) return 0;
        if(dp[i][j]!=-1) return dp[i][j];

        int maxi=Integer.MIN_VALUE;
        for(int k=i; k<=j ;k++){
            //first birst the baloon you wish then solve the left and right one;
            int coins=newBaloons[k]*newBaloons[i-1]*newBaloons[j+1] 
                + maxCoinCollect(i , k-1 , newBaloons ,dp) + maxCoinCollect(k+1 , j , newBaloons , dp);

            maxi=Math.max(maxi , coins);
        }
        return dp[i][j] = maxi;
    }
}
