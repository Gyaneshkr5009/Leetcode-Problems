/*
    > Grid Validity: Check if the starting or ending cell is blocked (1), return -1 immediately if true.
    > BFS Approach: Use BFS to find the shortest path by visiting neighboring cells in all 8 possible directions (up, down, left, right, and diagonals).
    > Distance Matrix: Maintain a distance matrix to store the minimum number of steps needed to reach each cell. Start from the top-left cell (0,0) and expand outwards using BFS.
    > Directions Array: Use an array to represent the 8 possible movements.
    > Base Case: If you reach the bottom-right cell (n-1, m-1), return the distance from the top-left to this cell.
    
    Time Complexity: O(n * m)
    Space Complexity: O(n * m)
*/

//*************************************************************(using dijkstras algo)***************************************************************************
class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        if(grid == null || grid.length == 0 || grid[0][0] == 1 || grid[grid.length-1][grid[0].length-1] == 1){
            return -1;
        }
        int n=grid.length , m=grid[0].length;
        // we are avoiding (log n) on finding the min between them using min PQ , so we simply using queue;
        Queue<Pair> q=new LinkedList<>(); 
        q.offer(new Pair(0 ,0)); // inserting starting node;

        int[][] dist=new int[n][m]; // creating a matrix to store distance of all nodes;
        for(int[] a:dist) Arrays.fill(a , Integer.MAX_VALUE);
        dist[0][0]=1;

        int[] dRow={-1 , -1 , 0 , 1 , 1 , 1 , 0 , -1};
        int[] dCol={0 , 1 , 1 , 1 , 0 , -1 , -1 , -1};
        while(!q.isEmpty()){
            Pair pair=q.poll();
            int row=pair.row;
            int col=pair.col;

            //if row & col reaches the end means we found the path ;
            if(row==n-1 && col==m-1) return dist[row][col];

            for(int i=0;i<8 ;i++){
                int nRow=row+dRow[i];
                int nCol=col+dCol[i];
                if(nRow<n && nRow>=0 && nCol<m && nCol>=0 && grid[nRow][nCol]==0 && dist[row][col]+1<dist[nRow][nCol]){
                    dist[nRow][nCol]=dist[row][col]+1;
                    q.offer(new Pair(nRow , nCol));
                }
            }
        }
        // we dont find a path from [(0,0) => (n-1 , m-1)];
        return -1;

    }
}
class Pair{
    int row;
    int col;
    Pair(int row , int col){
        this.row=row;
        this.col=col;
    }
}
