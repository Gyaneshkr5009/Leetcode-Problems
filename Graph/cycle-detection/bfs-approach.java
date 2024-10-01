/* approach=>
        BFS with Parent Tracking: Use BFS to explore the graph while tracking the parent node for each visited node to prevent backtracking.
        Queue-Based Cycle Detection: Process nodes level-by-level with a queue, and if a visited node is found that is not the parent, a cycle is detected.
        Visited Array: Maintain a boolean visited array to track visited nodes and avoid revisiting them.
        Cycle Condition: A cycle is confirmed if a node is revisited during BFS, excluding its parent.
*/

//Time Complexity: O(V + E)
//Space Complexity: O(V)
//********************************************************************************************************************************************
class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        if(adj.size()==0) return false;
        boolean[] visited=new boolean[V];
        
        for(int i=0 ;i<V;i++){
            if(!visited[i]){
                if(checkForCycle(i ,V, adj , visited)) return true;
            }
        }
        return false;
    }
    
    private boolean checkForCycle(int num ,int V, ArrayList<ArrayList<Integer>> adj , boolean[] visited){
        visited[num]=true;
        Queue<Pair> q=new LinkedList<>();
        q.offer(new Pair(num , -1));
        
        while(!q.isEmpty()){
            Pair pair=q.poll();
            int node=pair.node;
            int parent=pair.parent;
            
            for(int a:adj.get(node)){
                if(visited[a]==false){
                    visited[a]=true;
                    q.offer(new Pair(a , node));
                }
                else if(a!=parent){
                    return true;
                }
            }
        }
        return false;
    }
}

class Pair{
    int node;
    int parent;
    Pair(int node , int parent){
        this.node=node;
        this.parent=parent;
    }
}
