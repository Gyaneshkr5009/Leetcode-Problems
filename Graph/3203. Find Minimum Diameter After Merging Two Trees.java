class Solution {
    public int minimumDiameterAfterMerge(int[][] edges1, int[][] edges2) {
        int n=edges1.length+1;
        int m=edges2.length+1;
        if((edges1==null && edges2==null) || (n==0 && m==0)) return 0;
        List<List<Integer>> adj1=new ArrayList<>();
        List<List<Integer>> adj2=new ArrayList<>();
        for(int i=0;i<n;i++) adj1.add(new ArrayList<>());
        for(int i=0;i<m;i++) adj2.add(new ArrayList<>());
        build(adj1 , edges1);
        build(adj2 , edges2);

        //now i have created two graphs;
        int[] p1=new int[]{-1 , Integer.MIN_VALUE};
        boolean[] visited=new boolean[n];
        //we first find the farthest node from node 0;
        getFarthest(p1 , adj1 , 0 , 0 , visited);

        //now we have the node so we again traverse to find its farthest node to do so we get the 2 node's that having highest seperation between them;
        int[] p2=new int[]{-1 , Integer.MIN_VALUE};
        Arrays.fill(visited,false);
        getFarthest(p2 , adj1, p1[0] ,0 , visited);
        int d1=p2[1];

        //now doing the above process for 2nd tree;
        p1=new int[]{-1 , Integer.MIN_VALUE};
        visited=new boolean[m];
        getFarthest(p1 , adj2 , 0 , 0 , visited);

        p2=new int[]{-1, Integer.MIN_VALUE};
        Arrays.fill(visited,false);
        getFarthest(p2 , adj2, p1[0] , 0 , visited);
        int d2=p2[1];

        return Math.max(Math.max(d1,d2) , (d1+1)/2 +(d2+1)/2+1);
    }

    private void getFarthest(int[] p ,List<List<Integer>> adj , int node , int dis , boolean[] visited){
        int d=p[1];
        visited[node]=true;
        if(dis>d){
            p[0]=node;
            p[1]=dis;
        }

        for(int num:adj.get(node)){
            if(!visited[num]){
                getFarthest(p , adj , num , dis+1,visited);
            }
        }
    }

    private void build(List<List<Integer>> adj, int[][] edges) {
        for (int[] edge : edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }
    }
}
