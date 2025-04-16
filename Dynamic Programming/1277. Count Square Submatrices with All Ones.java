//***************************************************(memoization)******************************
//time complexity:O(n*m)
//space complexity:O(n*m) + O(m)
class Solution {
    public int countSquares(int[][] matrix) {
        int n=matrix.length , m=matrix[0].length;

        int ans=0;

        int[][] dp=new int[n][m];
        for(int[] d:dp) Arrays.fill(d , -1);

        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(matrix[i][j]==1){
                    ans+=findSquares( i , j , matrix, dp);
                }
            }
        }
        return ans;
    }
    private int findSquares(int i , int j , int[][] matrix , int[][] dp){
        if(i>=matrix.length || j>=matrix[0].length) return 0;
        if(matrix[i][j] == 0) return 0;
        if(dp[i][j]!=-1) return dp[i][j];

        int rightSquare=findSquares(i , j+1 , matrix ,dp);
        int dignlSquare=findSquares(i+1 , j+1 , matrix, dp);
        int bottomSquare=findSquares(i+1 , j , matrix, dp);

        return dp[i][j] = 1+ Math.min(rightSquare , Math.min(dignlSquare , bottomSquare));
        
    }
}

//****************************************(tabulation)********************************************
//time complexity:O(n*m);
//space complexity:O(n*m);
class Solution {
    public int countSquares(int[][] matrix) {
        int n=matrix.length , m=matrix[0].length;

        int ans=0;

        int[][] dp=new int[n+1][m+1];

        for(int i=n-1;i>=0;i--){
            for(int j=m-1;j>=0;j--){
                if(matrix[i][j]==1){
                    int rightSquare=dp[i][j+1];
                    int dignlSquare=dp[i+1][j+1];
                    int bottomSquare=dp[i+1][j];
                    dp[i][j] = 1+ Math.min(rightSquare , Math.min(dignlSquare , bottomSquare));
                }
                ans+=dp[i][j];
            }
        }
        return ans;
    }
}

//*****************************************************(tabultaion + space optimization)*********************************
//time complexity:O(n*m);
//space complexity:O(2m);
class Solution {
    public int countSquares(int[][] matrix) {
        int n=matrix.length , m=matrix[0].length;

        int ans=0;

        int[] prev=new int[m+1];
        
        for(int i=n-1;i>=0;i--){
            int[] curr=new int[m+1];
            curr[m]=0;
            for(int j=m-1;j>=0;j--){
                if(matrix[i][j]==1){
                    int rightSquare=curr[j+1];
                    int dignlSquare=prev[j+1];
                    int bottomSquare=prev[j];
                    curr[j] = 1+ Math.min(rightSquare , Math.min(dignlSquare , bottomSquare));
                }
                ans+=curr[j];
            }
            prev=curr;
        }
        return ans;
    }
}

//***********************************************(tabulation with O(n) and variable )*************************************
//tiem complexity:O(n*m);
//space complexity:O(m);
class Solution {
    public int countSquares(int[][] matrix) {
        int n = matrix.length, m = matrix[0].length;
        int ans = 0;

        int[] prev = new int[m + 1];

        for (int i = n - 1; i >= 0; i--) {
            int prevTemp = 0;
            for (int j = m - 1; j >= 0; j--) {
                int currTemp = prev[j];
                
                if (matrix[i][j] == 1) {
                    int rightSquare = prevTemp;
                    int diagonalSquare = prev[j+1];
                    int bottomSquare = prev[j];
                    
                    prev[j] = 1 + Math.min(rightSquare, Math.min(diagonalSquare, bottomSquare));
                    ans += prev[j];
                } else {
                    prev[j] = 0;
                }
                
                prevTemp = currTemp;
            }
        }
        return ans;
    }
}
