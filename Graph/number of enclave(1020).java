//go through surronded region problem because its just the same as surrounded problem with minor change


//**************************************************************************************************************************************************
class Solution {
    public int numEnclaves(int[][] grid) {
        if(grid==null ||grid .length==0) return 0;
        int n = grid.length;
        int m=grid[0].length;

        boolean[][] visited=new boolean[n][m];
        int[] dRow={-1 ,0 , 1 ,0};
        int[] dCol={0 , 1 , 0 , -1};

        //finding all 1's at the border of grid;
        for(int i=0 ;i<n ;i++){
           if(!visited[i][0] && grid[i][0]==1){
            dfs(i ,0 , dRow , dCol , visited , grid);
           }
           if(!visited[i][m-1] && grid[i][m-1]==1){
            dfs(i , m-1 , dRow , dCol , visited , grid);
           }
        }

        for(int i=0 ; i<m ;i++){
            if(!visited[0][i] && grid[0][i]==1){
                dfs(0 , i , dRow , dCol , visited , grid);
            }
            if(!visited[n-1][i] && grid[n-1][i]==1){
                dfs(n-1 , i , dRow, dCol , visited , grid);
            }
        }

        int cnt=0;
        for(int i=0 ;i<n ;i++){
            for(int j=0 ;j<m ;j++){
                if(visited[i][j]==false && grid[i][j]==1){
                    visited[i][j]=true;
                    cnt++;
                }
            }
        }
        return cnt;
    }

    private void dfs(int row , int col , int[] dRow , int[] dCol , boolean[][] visited , int[][] grid){
        visited[row][col]=true;
        int n =grid.length;
        int m =grid[0].length;
        for(int i=0 ;i<4 ;i++){
            int nRow=row+dRow[i];
            int nCol=col+dCol[i];

            if(nRow>=0 && nRow<n && nCol>=0 && nCol<m && visited[nRow][nCol]==false && grid[nRow][nCol]==1){
                dfs(nRow , nCol , dRow , dCol , visited , grid);
            }
        }
    }
}
