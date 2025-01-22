//time complexity:O(n*m);
//space complexity:O(n*m);
//****************************************************************(bfs)******************************************
class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int n=isWater.length;
        int m=isWater[0].length;
        Queue<Pair> q=new LinkedList<>();
        int[][] vis=new int[n][m];

        for(int[] a:vis){
            Arrays.fill(a , -1);
        }

        for(int i=0;i<n;i++){
            for(int j=0;j<m ;j++){
                if(isWater[i][j]==1){ //its a Water
                    vis[i][j]=0;
                    q.offer(new Pair(i ,j));
                }
            }
        }
        //now we have all the water in the vis apply bfs algo
        while(!q.isEmpty()){
            int val=q.size();
            for(int i=0;i<val;i++){
                Pair pair=q.poll();
                int row=pair.row;
                int col=pair.col;
                for(int j=0 ;j< 4; j++){
                    int nRow=row+dir[j][0];
                    int nCol=col+dir[j][1];

                    if(nRow>=0 && nCol>=0 && nRow<n && nCol<m && vis[nRow][nCol]==-1){
                        vis[nRow][nCol]=vis[row][col]+1;
                        q.offer(new Pair(nRow , nCol));
                    }
                }
            }
        }
        return vis;
    }
    private int[][] dir={{-1 , 0}, {0 ,1} ,{1, 0} , {0 , -1}}; //top , right , down ,left
}

class Pair{
    int row ,col;
    Pair(int row , int col){
        this.row=row;
        this.col=col;
    }
}
