/*
    Reverse Graph: Reverse the edges of the graph and calculate the in-degree for each node.
    Queue for Zero In-degree: Initialize a queue with nodes that have zero in-degrees (no outgoing edges in the original graph).
    Process Nodes: Perform BFS, adding nodes to the safe list when their in-degrees reach zero after processing.
    Sort and Return: Sort the safe nodes and return them as the result.

    Time Complexity: O(V + E)
    Space Complexity: O(V)
*/
//************************************************************************************(topo short)******************************************
class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> safeNodes=new ArrayList<>();
        if(graph==null || graph.length==0) return safeNodes;
        int n= graph.length;
        int[] indegree=new int[n];
        
        //reversing graph and calculating indegree of them
        ArrayList<ArrayList<Integer>> adjrev=new ArrayList<>();
        for(int i=0;i<n ;i++) adjrev.add(new ArrayList<>());
        for(int i=0;i<n;i++){
            // i->a
            // a->i
            for(int a:graph[i]){
                adjrev.get(a).add(i);
                indegree[i]++;
            }
        }

        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<n ;i++){
            if(indegree[i]==0) q.add(i);
        }

        while(!q.isEmpty()){
            int node=q.poll();
            safeNodes.add(node); // adding to safeNode;
            for(int a:adjrev.get(node)){
                indegree[a]--;
                if(indegree[a]==0) q.offer(a);
            }
        }

        Collections.sort(safeNodes);
        return safeNodes;
    }
}
