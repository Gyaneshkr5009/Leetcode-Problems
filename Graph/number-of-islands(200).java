
// check surrounding regions problem for this just similar except we just only need to count the islands;
class Solution {
    public int numIslands(char[][] grid) {
        if(grid.length==0) return 0;
        int n = grid.length;
        int m = grid[0].length;
        boolean[][] visited=new boolean[n][m];

        int[] dRow={-1 , 0 , 1 , 0};
        int[] dCol={0 , 1 , 0 , -1};
        
        int cntIslands=0;
        //trversing all borders of grid that have 1 and through dfs traversal mrking all attached items as true;
        for(int i=0;i<n ;i++){
            if(!visited[i][0] && grid[i][0]=='1'){
                dfs(i , 0  ,dRow , dCol ,  visited , grid);
                cntIslands++;
            }
            if(!visited[i][m-1] && grid[i][m-1]=='1'){
                dfs(i , m-1 , dRow , dCol , visited , grid);
                cntIslands++;
            }
        }

        for(int i=0 ;i<m ;i++){
            if(visited[0][i]==false && grid[0][i]=='1'){
                dfs(0 , i , dRow , dCol , visited , grid);
                cntIslands++;
            }
            if(visited[n-1][i]==false && grid[n-1][i]=='1'){
                dfs(n-1 , i , dRow , dCol , visited , grid); 
                cntIslands++;
            }
        }

        for(int i=0 ;i< n;i++){
            for(int j=0 ;j<m ;j++){
                if(visited[i][j]==false && grid[i][j]=='1'){
                    dfs(i , j , dRow , dCol , visited , grid);
                    cntIslands++;
                }
            }
        }
        return cntIslands;
    }

    private void dfs(int row , int col , int[] dRow , int[] dCol , boolean[][] visited , char[][] grid){
        visited[row][col]=true;
        int n=grid.length;
        int m=grid[0].length;

        for(int i=0 ;i<4 ;i++){
            int nRow=row+dRow[i];
            int nCol=col + dCol[i];

            if(nRow>=0 && nRow<n && nCol>=0 && nCol<m && !visited[nRow][nCol] && grid[nRow][nCol]=='1'){
                dfs(nRow , nCol , dRow , dCol , visited , grid);
            }
        }
    }
}
