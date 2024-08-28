class Solution {
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int subIslands = 0;
        int m = grid2.length; // number of rows
        int n = grid2[0].length; // number of columns

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid2[i][j] == 1 && checkSubIsland(grid1, grid2, i, j)) { // Found a sub-island
                    subIslands++;
                }
            }
        }

        return subIslands;
    }
    private boolean checkSubIsland(int[][] grid1, int[][] grid2, int i, int j) {
        if (i < 0 || i >= grid1.length || j < 0 || j >= grid1[0].length) {
            return true;
        }

        if (grid2[i][j] != 1) { // we only need to check land (grid2[i][j] == 1)
            return true;
        }

        grid2[i][j] = -1; // mark visited

        boolean result = (grid1[i][j] == 1); // grid1[i][j] must have 1 to be a sub-island

        // Perform DFS in all four directions (down, up, right, left)
        result = result & checkSubIsland(grid1, grid2, i + 1, j); // Down
        result = result & checkSubIsland(grid1, grid2, i - 1, j); // Up
        result = result & checkSubIsland(grid1, grid2, i, j + 1); // Right
        result = result & checkSubIsland(grid1, grid2, i, j - 1); // Left

        return result;
    }
}
