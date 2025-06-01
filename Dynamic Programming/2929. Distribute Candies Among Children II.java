//*************************************************(tabulation + space optimization)**************
class Solution {
    public long distributeCandies(int n, int limit) {
        long[][] dp=new long[4][n+1]; // children and candies
        
        //base case for one child;
        for(int i=0 ; i<=n ;i++){
            if(i<=limit) dp[1][i] = 1;
        }

        for(int child =2; child <= 3; child++) {
            long[] prefix = new long[n+2];
            for(int i = 0; i <= n; i++) {
                prefix[i + 1] = prefix[i] + dp[child - 1][i];
            }
            for(int candies = 0; candies <= n; candies++) {
                int l = Math.max(0, candies - limit);
                dp[child][candies] = prefix[candies + 1] - prefix[l];
            }
        }

        return dp[3][n];
    }
}
//***********************************************************(tabulation)****************************************
class Solution {
    public long distributeCandies(int n, int limit) {
        int[][] dp=new int[4][n+1]; // children and candies
        
        //base case for one child;
        for(int i=0 ; i<=n ;i++){
            if(i<=limit) dp[1][i] = 1;
        }

        for(int child=2;child<=3 ;child++){
            for(int candies=0 ; candies<=n ;candies++){
                for (int given=0; given <= Math.min(limit, candies); given++) {
                    dp[child][candies] += dp[child-1][candies-given];
                }
            }
        }

        return dp[3][n];
    }
}

//*****************************************************(memoization)*****************************************
class Solution {
    public long distributeCandies(int n, int limit) {
        int[][] dp=new int[4][n+1]; // children and candies
        for(int[] i :dp) Arrays.fill(i , -1);
        return solve(n , limit , 3 , dp);
    }
    private int solve(int n , int limit , int children , int[][] dp){
        if(children == 1) {
            return n<=limit ? 1 :0;
        }

        if(dp[children][n] != -1) return dp[children][n];

        int ans=0;
        for(int i=0;i<=limit ;i++){
            if(n>=i){
                ans+=solve(n-i , limit , children-1 ,dp);
            }
        }
        return dp[children][n] = ans;
    }
}
