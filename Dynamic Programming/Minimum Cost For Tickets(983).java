class Solution {
    public int mincostTickets(int[] days, int[] costs) {
        if(days==null || days.length==0 || costs==null || costs.length==0) return 0;
        int n=days.length;
        int[] dp=new int[n];
        return helper(days , costs, 0 , dp);
    }
    private int helper(int[] days , int[] costs , int idx , int[] dp){
        if(idx >= days.length) return 0;
        if(dp[idx]!=0) return dp[idx];

        int oneDayPass = costs[0] + helper(days, costs, getNextIndex(days, idx, days[idx] + 1), dp);
        int sevenDayPass = costs[1] + helper(days, costs, getNextIndex(days, idx, days[idx] + 7) , dp);
        int thirtyDayPass = costs[2] + helper(days, costs, getNextIndex(days, idx, days[idx] + 30) , dp);

        dp[idx] = Math.min(oneDayPass, Math.min(sevenDayPass, thirtyDayPass));
        return dp[idx];
    }
    private int getNextIndex(int[] days, int currentIndex, int validUntil) {
        int nextIndex = currentIndex;
        while (nextIndex < days.length && days[nextIndex] < validUntil) {
            nextIndex++;
        }
        return nextIndex;
    }
}
