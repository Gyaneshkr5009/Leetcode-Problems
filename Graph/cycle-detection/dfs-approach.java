//Time Complexity: O(V + E)
//Space Complexity: O(V)

/*approach =>   DFS Traversal: Use Depth-First Search (DFS) to explore the graph while tracking visited nodes.
                Parent Tracking: Maintain the parent node during DFS to avoid backtracking and mistakenly detecting a cycle.
                Cycle Detection: If a visited node is encountered and it’s not the parent, a cycle exists.
                Visited Array: Ensure all nodes are checked by initializing and updating a visited array to avoid revisiting nodes.
*/
//*************************************************************************************************************************************
class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        if(adj.size()==0) return false;
        int[] visited=new int[V];
        for(int i=0 ;i<V;i++){
            if(visited[i]==0){
                if(dfs(i , -1 , adj , visited)) return true;
            }
        }
        return false;
    }
    private boolean dfs(int node , int parent , ArrayList<ArrayList<Integer>> adj , int[] visited){
        visited[node]=1;
        for(int a:adj.get(node)){
            if(visited[a]==0){
                if(dfs(a , node , adj , visited)) return true;
            }
            else if(a!=parent) return true;
        }
        return false;
    }
}
