
//***************************************************************(bfs)**************************************************************************************
class Solution {

    public int[] shortestPath(int[][] edges, int n, int m, int src) {
        if (edges == null || edges.length == 0) return new int[0];

        // Creating adjacency list for n nodes
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }

        // Filling the adjacency list based on m edges
        for (int i = 0; i < m; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        // BFS to calculate shortest paths from src
        Queue<Integer> q = new LinkedList<>();
        q.offer(src);

        int[] ans = new int[n];
        Arrays.fill(ans, Integer.MAX_VALUE); // Initialize distances with max value
        ans[src] = 0; // Distance to source is 0

        while (!q.isEmpty()) {
            int node = q.poll();

            // Explore all neighbors of the current node
            for (int neighbor : adj.get(node)) {
                // If a shorter path to neighbor is found, update it
                if (ans[node] + 1 < ans[neighbor]) {
                    ans[neighbor] = ans[node] + 1;
                    q.offer(neighbor);
                }
            }
        }

        // Replace unreachable nodes (still with max distance) with -1
        for (int i = 0; i < n; i++) {
            if (ans[i] == Integer.MAX_VALUE) {
                ans[i] = -1;
            }
        }

        return ans;
    }
}
