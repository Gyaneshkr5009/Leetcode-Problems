class Solution {
    static long soln(int n , long[] dp){
        if(n<=1) return n;
        if(dp[n]!=-1) return dp[n];
        return dp[n]=(soln(n-1 , dp) + soln(n-2 , dp)) % 1000000007;
    }

    static long topDown(int n) {
        long[] dp =new long[n+1];
        Arrays.fill(dp , -1);
        return soln(n , dp);
    }

    static long bottomUp(int n) {
        if(n<=1) return n;
        long[] dp=new long[n+1];
        dp[0]=0;
        dp[1]=1;
        for(int i=2 ;i<=n ;i++){
            dp[i]=(dp[i-1]+dp[i-2])%1000000007;
        }
        return dp[n];
    }
}
