/*
        Topological Sort (Kahn's Algorithm): Use BFS to perform topological sorting, where nodes with zero in-degree are processed first.
        In-degree Calculation: Calculate the in-degree of each node (number of incoming edges).
        Cycle Detection Condition: If the number of processed nodes (in topological order) is less than the total number of vertices, a cycle exists.
        Queue Processing: Continuously reduce in-degrees and add nodes with zero in-degree to the queue.
*/
//Time Complexity: O(V + E)
//Space Complexity: O(V)
//*******************************************************************************************************************************
class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        //normal topo short bfs
        if(adj==null || adj.size()==0) return false;
        
        int[] indegree=new int[V];
        for(int i=0;i<V ;i++){
            for(int a:adj.get(i)){
                indegree[a]++;
            }
        }
        
        Queue<Integer> q=new LinkedList<>();
        
        for(int i=0;i<V;i++){
            if(indegree[i]==0) q.offer(i);
        }
        
        int cnt=0;
        int i=0;
        while(!q.isEmpty()){
            int node=q.poll();
            cnt++;
            for(int a:adj.get(node)){
                indegree[a]--;
                if(indegree[a]==0) q.offer(a);
            }
        }
        if(cnt==V) return false;
        return true;
    }
}
