/*
          Problem: Find the minimum time to travel from the top-left to bottom-right of a grid where movement depends on current time and grid values.
          Approach: Implemented Dijkstra's algorithm using a priority queue to process cells in order of their time.
          Key Logic:
              If the next cell's value ≤ current time + 1, move immediately.
              Otherwise, wait or adjust based on even/odd differences.
          Complexity:
              Time: O(n⋅m⋅log⁡(n⋅m))O(n⋅m⋅log(n⋅m)), where n×mn×m is the grid size.
              Space: O(n⋅m)O(n⋅m) for the result and visited arrays.
*/

//********************************************************************************(dijkstra's algo)***********************************************
class Solution {
    public int minimumTime(int[][] grid) {
        if(grid==null || grid.length==0) return -1;
        if(grid[0][1]>1 && grid[1][0]>1) return -1;
        int n=grid.length , m = grid[0].length;

        int[][] result= new int[n][m];
        result[0][0]=0;

        for(int[] a:result){
            Arrays.fill(a , Integer.MAX_VALUE);
        }

        boolean[][] visited=new boolean[n][m];

        PriorityQueue<Pair> pq=new PriorityQueue<>((x,y) -> x.time - y.time);
        pq.offer(new Pair(0 , 0 , 0)); // stores time , row ,col;

        int[] dRow={-1 , 0 , 1 , 0};
        int[] dCol={0 , 1 , 0 , -1};

        while(!pq.isEmpty()){
            Pair pair =pq.poll();
            int row=pair.row;
            int col=pair.col;
            int time=pair.time;

            if(row==n-1 && col==m-1) {
                return result[row][col];
            }

            if(visited[row][col]) continue;
            visited[row][col]=true;

            for(int i=0 ;i < 4 ;i++){
                int nRow=row+dRow[i];
                int nCol=col+dCol[i];

                if(nRow <n && nCol<m && nRow>=0 && nCol>=0){
                    int nextTime;
                    if(grid[nRow][nCol]<=time+1){
                        nextTime=time+1;
                    }
                    else if((grid[nRow][nCol]-time)%2==1){
                        nextTime=grid[nRow][nCol];
                    }
                    else{
                        nextTime=grid[nRow][nCol]+1;
                    }

                    if(nextTime < result[nRow][nCol]){
                        result[nRow][nCol]=nextTime;
                        pq.offer(new Pair(nextTime , nRow , nCol));
                    }
                }
            }
        }
        return result[n-1][m-1];
    }
    
}

class Pair{
    int time , row, col;
    Pair(int time ,  int row , int col){
        this.time=time;
        this.row=row;
        this.col=col;
    }
}
