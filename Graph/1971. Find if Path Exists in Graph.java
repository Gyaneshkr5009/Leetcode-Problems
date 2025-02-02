class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        boolean[] visited=new boolean[n];
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] a:edges){
            adj.get(a[0]).add(a[1]);
            adj.get(a[1]).add(a[0]);
        }

        return dfs(visited , source , destination , adj);
    }
    private boolean dfs(boolean[] visited  , int node , int dest , List<List<Integer>> adj){
        if(node==dest){
            return true;
        }
        visited[node]=true;

        for(int i:adj.get(node)){
            if(!visited[i]){
                if(dfs(visited , i , dest , adj)) return true;
            }
        }
        return false;
    }
}
