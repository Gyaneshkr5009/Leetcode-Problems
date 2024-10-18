/*
      Problem Context:

    You are given a 2D grid of heights, and the task is to find the path with the minimum effort (difference in heights between adjacent cells).
    Effort is defined as the maximum height difference on the path from the top-left to the bottom-right.

Approach:

    Use Dijkstra's Algorithm to find the shortest path based on the minimum effort required to move from one cell to another.

Priority Queue (Min-Heap):

    A PriorityQueue is used to always process the cell with the smallest effort first.
    The PriorityQueue stores Pair objects with (effort, row, col).

Effort Calculation:

    For each neighboring cell (nRow, nCol), calculate the new effort as:
        newEffort = max(abs(heights[current] - heights[neighbor]), currentEffort)
    If the new effort is smaller than the previously known effort for that neighbor, update the effort and add the neighbor to the queue.

Matrix Boundaries:

    Ensure that the next cell (nRow, nCol) is within the bounds of the matrix (i.e., valid row and column indices).

Distance Array:

    Maintain a dist array that stores the minimum effort required to reach each cell. Initialize it to Integer.MAX_VALUE except for the starting point (0, 0).

Termination:

    As soon as you reach the bottom-right corner, return the effort value since it will be the minimum effort.

Time Complexity:

    O(V log V + E) where V is the number of cells and E is the number of edges (4 edges per cell in a grid).

Space Complexity:

    O(V) for storing the distance array, priority queue, and auxiliary structures.
*/
//**********************************************************************************************************************************************************
class Solution {
    public int minimumEffortPath(int[][] heights) {
        //this questions says that find the path having min efforts to move from one node to another;
        if(heights==null || heights.length==0) return 0;

        PriorityQueue<Pair> pq=new PriorityQueue<>((x,y)-> x.distance - y.distance);
        int n =heights.length;
        int m =heights[0].length;
        int[][] dist=new int[n][m];
        for(int i=0;i<n;i++){
            Arrays.fill(dist[i] , Integer.MAX_VALUE);
        }

        dist[0][0]=0;
        pq.add(new Pair(0 , 0 , 0));
        int[] dRow={-1 , 0 , 1 , 0};
        int[] dCol={0 , 1, 0, -1};
        while(!pq.isEmpty()){
            Pair pair=pq.poll();
            int row=pair.row;
            int col=pair.col;
            int diff=pair.distance;

            if(row==n-1 && col == m-1) return diff;

            for(int i=0;i<4;i++){
                int nRow=row+dRow[i];
                int nCol=col+dCol[i];

                if(nRow>=0 && nCol>=0 && nRow<n && nCol<m){
                    int newEffort=Math.max(Math.abs(heights[row][col] - heights[nRow][nCol]) , diff);
                    if(newEffort < dist[nRow][nCol]){
                        dist[nRow][nCol]=newEffort;
                        pq.offer(new Pair(newEffort , nRow , nCol));
                    }
                }
            }
        }
        return 0;
    }
}

class Pair{
    int row , col , distance;
    Pair(int distance , int row , int col){
        this.distance=distance;
        this.row=row;
        this.col=col;
    }
}
