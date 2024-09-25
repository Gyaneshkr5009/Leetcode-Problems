class Solution {
    public int orangesRotting(int[][] grid) {
        if(grid==null || grid.length==0) return 0;
        int n =grid.length;
        int m =grid[0].length;

        int[][] visited=new int[n][m];
        Queue<Pair> q=new LinkedList<>();

        int cntFresh=0;

        //finding all nodes having 2 value;
        for(int i=0; i< n ;i++){
            for(int j=0 ;j<m ;j++){
                if(grid[i][j]==2) q.add(new Pair(i , j , 0));
                else if(grid[i][j]==1) cntFresh++;
                else visited[i][j]=0;
            }
        }

        int time=0;
        int[] dRow={-1 , 0 , 1 , 0};
        int[] dCol={0 , 1 , 0 , -1};
        while(!q.isEmpty()){
            Pair node=q.poll();
            int row=node.row;
            int col=node.col;
            time=Math.max(time , node.time);

            for(int i=0 ;i < 4 ;i++){
                int nRow=row+dRow[i];
                int nCol=col+dCol[i];

                if(nRow>=0 && nRow<n && nCol>=0 && nCol<m && visited[nRow][nCol]==0 && grid[nRow][nCol]==1){
                    q.offer(new Pair(nRow , nCol , time+1));
                    visited[nRow][nCol]=2;
                    cntFresh--;
                }
            }
        }

        if(cntFresh>0) return -1;
        return time;
    }
}

class Pair{
    int row;
    int col;
    int time;

    Pair(int row, int col , int time){
        this.row=row;
        this.col=col;
        this.time=time;
    }
}
