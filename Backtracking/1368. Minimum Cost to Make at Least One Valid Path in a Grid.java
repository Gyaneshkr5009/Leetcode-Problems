//*********************************************************(Brute Force)***********************************
class Solution {
    public int minCost(int[][] grid) {
        int n=grid.length , m=grid[0].length;
        boolean[][] visited=new boolean[n][m];
        int[][] dir={{-1 , 0} , {0 , 1} , {1, 0} , {0 , -1}};
        helper(0 , 0 , grid, 0 , visited ,n , m , dir);
        return res;
    }
    private int res=Integer.MAX_VALUE;
    //1->Right  , 2->Left , 3->Down , 4->Up
    private void helper(int row, int col , int[][] grid , int cost , boolean[][] visited , int n , int m , int[][] dir){
        if (row<0 || col<0 || row>=n || col>=m || visited[row][col]) return ;
        if(row==n-1 && col==m-1){
            res=Math.min(res, cost);
            return;
        }

        visited[row][col]=true;
        int gridDir=grid[row][col];
        
        for(int i=0;i<4;i++){
            int nRow=row+dir[i][0];
            int nCol=col+dir[i][1];
            int dirCost=0;

            if(nRow<n && nCol<m && nRow>=0 && nCol>=0 && !visited[nRow][nCol]){
                if((gridDir==1 && i!=1) || (gridDir==2 && i!=3) || (gridDir==3 && i!=2) || (gridDir==4 && i!=0)) dirCost=1;
                int newCost=cost+dirCost;
                helper(nRow , nCol , grid , newCost , visited , n , m , dir);
            }
        }
        visited[row][col]=false;
    }
}

//********************************************************(optimized Approach)*******************************
// T.C: O(m*n * log(m*n))
// S.C: O(m*n)
class Solution {
    private int[][] dir = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0])); 
        int[][] result = new int[m][n];
        for (int[] row : result) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }

        pq.offer(new int[]{0, 0, 0}); 
        result[0][0] = 0;

        while (!pq.isEmpty()) {
            int[] curr = pq.poll(); 
            int currCost = curr[0];
            int i = curr[1];
            int j = curr[2];

            if (result[i][j] < currCost) {
                continue;
            }

            int gridDir = grid[i][j];

            for (int dirIdx = 0; dirIdx < 4; dirIdx++) {
                int newI = i + dir[dirIdx][0];
                int newJ = j + dir[dirIdx][1];

                if (newI >= 0 && newJ >= 0 && newI < m && newJ < n) {
                    int dirCost = (gridDir - 1 != dirIdx) ? 1 : 0;

                    int newCost = currCost + dirCost;

                    if (newCost < result[newI][newJ]) {
                        result[newI][newJ] = newCost;
                        pq.offer(new int[]{newCost, newI, newJ});
                    }
                }
            }
        }
        return result[m - 1][n - 1];
    }
}
