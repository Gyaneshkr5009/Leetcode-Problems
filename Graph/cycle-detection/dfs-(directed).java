class Solution {
    // Function to detect cycle in a directed graph.
    public boolean isCyclic(int V, ArrayList<ArrayList<Integer>> adj) {
        if(adj.size()==0) return false;
        boolean[] visited=new boolean[V];
        boolean[] pathVis=new boolean[V];
        
        for(int i=0 ;i< V;i++){
            if(visited[i]==false){
                if(dfs(i , adj , visited , pathVis)) return true;
            }
        }
        return false;
    }
    
    private boolean dfs(int node , ArrayList<ArrayList<Integer>> adj , boolean[] visited , boolean[] pathVis){
        visited[node]=true;
        pathVis[node]=true;
        
        for(int i:adj.get(node)){
            //when the node is not viisted
            if(!visited[i]){
                if(dfs(i , adj , visited , pathVis)) return true;
            }
            
            //if the node has been previously viisted
            //but it has to be visited on the same path
            else if(pathVis[i]) return true;
        }
        pathVis[node]=false;
        return false;
    }
}
