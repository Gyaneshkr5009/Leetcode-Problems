class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int n=matrix.length , m=matrix[0].length;
        int min=(int)1e7;
        Integer[][] dp=new Integer[n][m];
        
        for(int i=0;i<m;i++){
            min=Math.min(min ,solve(n,m, matrix , 0 , i ,dp));
        }
        return min;
    }
    private int solve(int n , int m, int[][] matrix ,int idx , int nextIdx ,Integer[][] dp){
        //base case
        if(nextIdx<0 || nextIdx>=m) return (int)1e7;
        if(idx==n-1) return matrix[idx][nextIdx];
        if(dp[idx][nextIdx]!=null) return dp[idx][nextIdx];

        int min=(int)1e7;
        int left=matrix[idx][nextIdx] + solve(n , m, matrix , idx+1 , nextIdx-1 ,dp);
        int bottom=matrix[idx][nextIdx]+solve(n , m , matrix, idx+1 , nextIdx , dp);
        int right=matrix[idx][nextIdx]+solve(n , m , matrix , idx+1 , nextIdx+1 ,dp);
        min=Math.min(left , Math.min(bottom , right));
        return dp[idx][nextIdx] = min;
    }
}
