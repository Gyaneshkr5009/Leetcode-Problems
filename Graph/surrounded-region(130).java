//time complexity:O(n*m)+;
//space complexity:O(n*m)+;
//***********************************************************************************(dfs approach)******************************************
class Solution {
    public void solve(char[][] board) {
        if(board==null || board.length==0) return;
        int n=board.length;
        int m=board[0].length;
        
        int[] dRow={-1 ,0 ,1 ,0};
        int[] dCol={0 ,1 , 0 ,-1};

        boolean[][] visited=new boolean[n][m];

        //traversing all four courners of board;

        for(int i=0 ;i< n ;i++){
            if(!visited[i][0] && board[i][0]=='O'){
                dfs(i , 0 , dRow , dCol , visited , board);
            }
            if(!visited[i][m-1] && board[i][m-1]=='O'){
                dfs(i,m-1 , dRow , dCol , visited , board);
            }
        }

        for(int i=0 ;i<m ;i++){
            if(!visited[0][i] && board[0][i]=='O'){
                dfs( 0 , i , dRow , dCol , visited , board);
            }
            if(!visited[n-1][i] && board[n-1][i]=='O'){
                dfs(n-1 , i , dRow , dCol , visited, board);
            }
        }

        //now all the corners have picked up and marked all 0's that are in contect with the boundary 0's through dfs traversal;
        for(int i=0 ;i<n;i++){
            for(int j=0 ;j< m ;j++){
                if(!visited[i][j] && board[i][j]=='O'){
                    visited[i][j]=true;
                    board[i][j]='X';
                }
            }
        }
    }

    private void dfs (int row , int col , int[] dRow , int[] dCol , boolean[][] visited , char[][] board){
        visited[row][col]= true; //marking true as we start traversal;
        int n=board.length;
        int m=board[0].length;

        //traversing all four ways =>{up, right, bottom , left};
        for(int i=0 ; i < 4 ;i++){ 
            int nRow = row+dRow[i];
            int nCol=col + dCol[i];

            if(nRow>=0 && nRow<n && nCol>=0 && nCol<m && visited[nRow][nCol]==false && board[nRow][nCol]=='O'){
                dfs(nRow , nCol , dRow , dCol , visited , board);
            }
        }
    }
}
