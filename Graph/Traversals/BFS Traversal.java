class Solution {
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        ArrayList<Integer> bfs =new ArrayList<>();
        if(adj==null || adj.length==0) return bfs;
        
        boolean vis[]=new boolean[V];
        Queue<Integer> q=new LinkedList<>();
        q.add(0);
        vis[0]==true;
        
        while(!q.isEmpty()){
            int node=q.poll();
            bfs.add(node);
            
            for(int i:adj.get(node)){
                if(vis[i]==false){
                    vis[i]=true;
                    q.add(i);
                }
            }
        }
        return bfs;
    }
}
