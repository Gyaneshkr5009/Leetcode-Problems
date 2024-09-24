//space complexity:O(2*n);
//time complexity:O(n);

class Solution {
    public List<List<Integer>> printGraph(int V, int edges[][]) {
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0 ; i<V ;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int[] edge : edges){
            int u=edge[0];
            int v=edge[1];
            
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
        return adj;
    }
}
