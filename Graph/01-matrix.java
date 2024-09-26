class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int n =mat.length;
        int m =mat[0].length;
        if(mat.length==0) return new int[0][0];
        int[][] visited=new int[n][m];

        for(int[] row:visited){
            Arrays.fill(row ,-1);
        }

        Queue<Pair> q=new LinkedList<>();
        //add all value having 1
        for(int i=0;i<n;i++){
            for(int j=0 ;j<m ;j++){
                if(mat[i][j]==0){
                    q.offer(new Pair(i, j, 0));
                    visited[i][j]=0;
                }
            }
        }

        int[] dRow={-1 , 0 , 1, 0};
        int[] dCol={0 , 1 , 0, -1};
        while(!q.isEmpty()){
            Pair pair=q.poll();
            int row=pair.row;
            int col=pair.col;
            int dis=pair.dis;

            for(int i=0 ;i< 4 ;i++){
                int nRow=row+dRow[i];
                int nCol=col + dCol[i];

                if(nRow>=0 && nRow<n && nCol>=0 && nCol<m && visited[nRow][nCol]==-1){
                    q.offer(new Pair(nRow , nCol , dis+1));
                    visited[nRow][nCol]=dis+1;
                }
            }
        }
        return visited;
    }
}

class Pair{
    int row;
    int col;
    int dis;
    Pair(int row , int col , int dis){
        this.row=row;
        this.col=col;
        this.dis=dis;
    }
}
