//time complexity:O(2*n*m);
//space complexity:O(n+m);
//*******************************************************(optimal Approach)************************************
class Solution {
    public int countServers(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int[] rows=new int[n];
        int[] cols=new int[m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1){
                    rows[i]++;
                    cols[j]++;
                }
            }
        }
        int cnt=0;
        
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]==1 && (rows[i]>1 || cols[j]>1)) cnt++;
            }
        }
        
        return cnt;
    }
}

//***********************************************************************************************************************

//time complexity:O((n*m)*(n+m));
//space complexity:O(1);
//*****************************************************************(brute force)********************************************
class Solution {
    public int countServers(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int cnt=0;
        for(int row=0;row<n;row++){
            for(int col=0;col<m;col++){
                if(grid[row][col]==1){
                    boolean canCommunicate=false;
                    //checking row
                    for(int i=0;i<m;i++){
                        if(grid[row][i]==1 && i!=col) canCommunicate=true;
                    }
                    if(canCommunicate) cnt++;
                    else{
                        for(int i=0;i<n;i++){
                            if(grid[i][col]==1 && i!=row) canCommunicate=true;
                        }
                        if(canCommunicate) cnt++;
                    }
                }
            }
        }
        return cnt;
    }
}
