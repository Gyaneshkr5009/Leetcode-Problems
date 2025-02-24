class Solution {
    public int maximumPoints(int arr[][]) {
        int n=arr.length;
        int[][] dp=new int[n][4]; // where idx 3 resembles that previosly nothing choosen;
        for(int[] a:dp){
            Arrays.fill(a , -1);
        }
        return solve(n-1 , 3 , dp , arr);
    }
    private int solve(int day , int last , int[][] dp , int[][] arr) {
        //base case;
        if(day==0){
            int max=Integer.MIN_VALUE;
            for(int i=0;i<3;i++){
                if(i!=last){
                    max=Math.max(arr[0][i] , max);
                }
            }
            return max;
        }
        
        if(dp[day][last]!=-1) return dp[day][last];
        
        int max=Integer.MIN_VALUE;
        for(int i=0;i<3;i++){
            if(i!=last){
                int total=solve(day-1 , i , dp , arr) + arr[day][i];
                max=Math.max(max , total);
            }
        }
        return dp[day][last]=max;
    }
}
