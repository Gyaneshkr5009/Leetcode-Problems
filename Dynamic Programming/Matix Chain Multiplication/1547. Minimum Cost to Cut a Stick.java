//*************************************************(memoization)*******************************************
class Solution {
    public int minCost(int n, int[] cuts) {
        //solving using Matrix chain multiplication and creating a new array of size +2 that includes 0 and n as last values;
        int m=cuts.length;
        int[] allCuts=new int[m+2];
        allCuts[0]=0;
        allCuts[m+1]=n;
        for(int i=0;i<cuts.length;i++){
            allCuts[i+1]=cuts[i];
        }

        Arrays.sort(allCuts);
        int[][] dp=new int[m+2][m+2];
        for(int[] d:dp) Arrays.fill(d, -1);

        return minCost(1 , m , allCuts , dp);
    }
    private int minCost(int i , int j , int[] allCuts , int[][] dp){
        if(i>j) return 0;

        if(dp[i][j] !=-1) return dp[i][j];

        int min=Integer.MAX_VALUE;
        for(int k=i; k<=j ;k++){
            int cost= allCuts[j+1]-allCuts[i-1] + minCost(i , k-1 ,allCuts , dp) + minCost(k+1 , j , allCuts , dp);
            min=Math.min(min , cost);
        }
        return dp[i][j] = min;
    }
}

//************************************************(tabultaion)************************************************
class Solution {
    public int minCost(int n, int[] cuts) {
        //solving using Matrix chain multiplication and creating a new array of size +2 that includes 0 and n as last values;
        int m=cuts.length;
        int[] allCuts=new int[m+2];
        allCuts[0]=0;
        allCuts[m+1]=n;
        for(int i=0;i<cuts.length;i++){
            allCuts[i+1]=cuts[i];
        }

        Arrays.sort(allCuts);
        int[][] dp=new int[m+2][m+2];

        for(int i=m ; i>=1 ;i--){
            for(int j= 1; j<=m; j++){
                if(i>j) continue;
                int min=Integer.MAX_VALUE;
                for(int k=i; k<=j ;k++){
                    int cost= allCuts[j+1]-allCuts[i-1] + dp[i][k-1] + dp[k+1][j];
                    min=Math.min(min , cost);
                }
                dp[i][j]=min;
            }
        }

        return dp[1][m];
    }
}
