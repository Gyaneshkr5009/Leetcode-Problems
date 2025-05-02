class Solution {
    int mod=1_000_000_007;
    public int numWays(int steps, int arrLen) {
        if(steps == 0) return 1;

        int maxIdx= Math.min(arrLen , steps/2+1);

        long[][] dp =new long[maxIdx][steps+1];
        for(long[] a:dp) Arrays.fill(a, -1);

        return (int)(solve(steps , maxIdx , 0 , dp)%mod);
    }
    private long solve(int steps , int maxIdx , int idx , long[][] dp){
        //base cases
        if(idx < 0 || idx >= maxIdx) return 0;
        if(steps == 0){
            return idx == 0 ? 1 :0;
        }
        if(dp[idx][steps] != -1) return dp[idx][steps];
        //left
        long left=solve(steps-1 , maxIdx , idx-1 , dp)%mod;
        //right
        long right = solve(steps-1 , maxIdx , idx+1 , dp) % mod;
        //stays
        long stay=solve(steps-1 , maxIdx , idx , dp) % mod;

        return dp[idx][steps] = (left+right+stay)%mod;
    }
}
