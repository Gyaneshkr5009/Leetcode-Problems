/*
    Key Approach:

    Adjacency List Representation:
        First, we convert the list of edges into an adjacency list for the graph to represent the connections between nodes.

    Tarjan's Algorithm:
        We use a Depth-First Search (DFS) to explore the graph and identify bridges (critical connections). Bridges are edges that, if removed, would increase the number of connected components in the graph.

    DFS with Discovery and Low-Link Time:
        For each node, we track two key times:
            tin[]: The discovery time (when the node is first visited).
            low[]: The lowest time of any node reachable from the current node.
        For each node v, during DFS traversal:
            We recursively perform DFS for each of its neighbors.
            If we encounter a node that hasn't been visited, we recurse deeper and update the low[] value.
            If the low[] value of a neighbor is greater than the tin[] of the current node, it means there's no back edge to an earlier node, so this edge is a bridge.

    Bridge Condition:
        If for any node v and its adjacent node u, the low[u] > tin[v], it implies that the connection v-u is a bridge. This is because there is no alternate way to reach node u or its descendants without going through v.

    Time Complexity: O(V + E), where V is the number of nodes and E is the number of edges.
        Each node and edge is visited exactly once during the DFS traversal.

    Space Complexity: O(V + E) for storing the adjacency list and auxiliary arrays.

Explanation of Core Concepts:

    DFS Traversal: The algorithm uses DFS to explore the graph, marking nodes as visited and keeping track of discovery and lowest reachable nodes.
    Back Edge: If an edge connects a node to one of its ancestors in the DFS tree, it is called a back edge.
    Bridge: An edge is a bridge if, after removing it, the graph becomes disconnected, meaning it's critical for maintaining the connectivity of the graph.
*/
//*****************************************************************(Tarjans Algorithm)********************************************************
class Solution {
    private int timer=1;  //this is the time taken for reaching a node in a graph;
    private List<List<Integer>> bridges=new ArrayList<>(); // contains all bridges of a graph;
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        if(connections==null || connections.size()==0) return new ArrayList<>();

        //creating an empty adjacent node;
        ArrayList<ArrayList<Integer>> adj=new ArrayList<>();
        for(int i=0;i< n ;i++){
            adj.add(new ArrayList<>());
        }

        //filling the adj node
        for(List<Integer> ls: connections){
            adj.get(ls.get(0)).add(ls.get(1));
            adj.get(ls.get(1)).add(ls.get(0));
        }

        int[] visited=new int[n]; // to keep track of the nodes whether they are visited or not;
        int[] tin=new int[n]; // keep track of timing of nodes when they firstly reach; eq 4 willbe reach after 1,2,3;
        int[] low=new int[n]; // min lowest time insertion of all adj nodes apart from parent;

        dfs(0 , -1 , visited , tin , low ,adj);
        return bridges;
    }

    private void dfs(int node , int parent , int[] visited , int[] tin, int[] low , ArrayList<ArrayList<Integer>> adj){
        visited[node]=1;  //now the node is visited;
        tin[node]=low[node]=timer; // set the time in which we reach the node;
        timer++;

        for(int a: adj.get(node)){
            if(a==parent) continue; // agr hmara adj node parent hai jisse abhi aaye hi hai ignore it and check others;
            if(visited[a]==0){
                dfs(a , node , visited , tin , low ,adj);
                //this will go and  do the rest  of job and filled out its tin and low;
                low[node]=Math.min(low[node], low[a]); 
                //then take the lowest node that your adj can reach;


                //after that check ki node ka timing jb hmne touch kiya chota hai kya adj node ke lowest node se agar haan mtlb they are not reachable , simply its a bridge  agar hmare curr node ki timing and uske adj node ki lowest node ki timing se bda hai means uska adj node uske reach ker sjta hai via lowest node jo ki curr node se pehle touch ho gya;
                if(low[a] > tin[node]){
                    bridges.add(Arrays.asList(node , a));
                } 
            }

            //if the node already visited , then simply update the lowest reachable node;
            else {
                low[node]=Math.min(low[node] , low[a]);
            }
        }
    }
}
