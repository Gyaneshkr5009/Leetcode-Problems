class Solution {
    public int findMaxFish(int[][] grid) {
        int n=grid.length;
        int m=grid[0].length;
        int maxFish=0;
        boolean[][] visited=new boolean[n][m];
        for(int i=0;i<n;i++){
            for(int j=0;j<m;j++){
                if(grid[i][j]>0 && !visited[i][j]){
                    int currentFish = dfs(n, m, i, j, grid, visited);
                    maxFish = Math.max(maxFish, currentFish);
                }
            }
        }
        return maxFish;
    }
    private int[][] dir={{-1,0} , {0 , 1} , {1, 0} , {0 , -1}};
    private int dfs(int rows , int cols , int row, int col , int[][] grid , boolean[][] visited){
        if (row < 0 || row >= rows || col < 0 || col >= cols || visited[row][col] || grid[row][col] <= 0) return 0;
        visited[row][col]=true;
        int sum=grid[row][col];

        for(int i=0;i<4;i++){
            int nRow = row + dir[i][0];
            int nCol = col + dir[i][1];
            sum+=dfs(rows, cols , nRow , nCol , grid , visited);
        }
        return sum;
    }
}
