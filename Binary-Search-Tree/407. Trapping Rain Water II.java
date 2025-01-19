class Solution {
    public int trapRainWater(int[][] heightMap) {
        if(heightMap==null || heightMap.length==0) return 0;
        int n=heightMap.length , m=heightMap[0].length;
        boolean[][] visited=new boolean[n][m];
        PriorityQueue<Pair> pq=new PriorityQueue<>((a,b) -> Integer.compare(a.val , b.val));

        //for border value traversal;
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                //right and left border 
                if(j==0 || j==m-1){
                    pq.offer(new Pair(heightMap[i][j] , i , j));
                    visited[i][j]=true;
                }
                //top and bottom border
                if((i==0 || i==n-1)&&(j>0 && j<m-1)){
                    pq.offer(new Pair(heightMap[i][j] , i , j));
                    visited[i][j]=true;
                }
            }
        }
        int res=0;
        while(!pq.isEmpty()){
            Pair pair=pq.poll();
            int maxAllowed=pair.val;
            int row=pair.row;
            int col=pair.col;
            //all dir;
            for(int i=0;i<4;i++){
                int nRow=row+dir[i][0];
                int nCol=col+dir[i][1];
                if(nRow>0 && nRow<n-1 && nCol>0 && nCol <m-1 && !visited[nRow][nCol]){
                    res += Math.max(maxAllowed - heightMap[nRow][nCol], 0);
                    pq.offer(new Pair(Math.max(maxAllowed, heightMap[nRow][nCol]), nRow, nCol));
                    visited[nRow][nCol] = true;
                }
            }
        }
        return res;
    }
    private int[][] dir={{-1 ,0} , {0,1} , {1,0} , {0,-1}};
}
class Pair{
    int val;
    int row;
    int col;
    Pair(int val , int row, int col){
        this.val=val;
        this.row=row;
        this.col=col;
    }
}
