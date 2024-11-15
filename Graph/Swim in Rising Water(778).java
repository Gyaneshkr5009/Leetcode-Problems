class Solution {
    public int swimInWater(final int[][] grid) {
        final int n = grid.length;
        final Queue<int[]> queue = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        final int[][] directions = new int[][] { { 0, 1 }, { 1, 0 }, { 0, -1 }, { -1, 0 } };
        final boolean[][] visited = new boolean[n][n];

        queue.offer(new int[] { grid[0][0], 0, 0 });

        while(!queue.isEmpty()) {
            final int[] curr = queue.poll();
            final int t = curr[0], i = curr[1], j = curr[2];

            if(i == n - 1 && j == n - 1)
                return t;
                
            visited[i][j] = true;

            for(final int[] direction : directions) {
                final int x = i + direction[0], y = j + direction[1];

                if(x < n && y < n && x >= 0 && y >= 0 && !visited[x][y])
                    queue.offer(new int[] { Math.max(t, grid[x][y]), x, y });
            }
        }

        return -1;
    }
}
