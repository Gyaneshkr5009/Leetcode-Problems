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
