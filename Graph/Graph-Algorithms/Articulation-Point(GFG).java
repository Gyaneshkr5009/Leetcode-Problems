/*
      Key Approach:

    Adjacency List Representation:
        The graph is represented using an adjacency list, where each node is connected to other nodes via edges.

    Articulation Point Definition:
        An articulation point (cut vertex) in a graph is a vertex, that when removed, increases the number of connected components in the graph. These points are critical for maintaining the graph's connectivity.

    Tarjan's Algorithm for Articulation Points:
        Tarjan's algorithm uses DFS to explore the graph and find articulation points. The algorithm relies on the discovery time (tin[]) and the lowest time reachable (low[]) for each node during DFS traversal.

    DFS with Discovery and Low-Link Time:
        During DFS traversal, for each node v, we track:
            tin[v]: Discovery time of the node v.
            low[v]: The lowest discovery time of any node that can be reached from v or its descendants.
        For each node, we update its low[] based on the low[] values of its adjacent nodes (children in DFS tree).

    Articulation Point Conditions:
        A node u is an articulation point if:
            Condition 1: It is the root node of the DFS tree and has more than one child.
            Condition 2: For any non-root node u, there exists a child v such that low[v] >= tin[u]. This means that the subtree rooted at v cannot connect to any ancestors of u, making u critical for connecting the subtree.

    Marking Articulation Points:
        We use an additional array mark[] to flag nodes that are articulation points.
        If the node meets the above conditions, it is marked as an articulation point.

    Time Complexity: O(V + E), where V is the number of vertices and E is the number of edges.
        Each node and edge is visited exactly once during the DFS traversal.

    Space Complexity: O(V + E) for storing the adjacency list and auxiliary arrays.

Explanation of Core Concepts:

    DFS Traversal: A recursive DFS is used to explore the graph, where each node's discovery and lowest reachable times are calculated.
    Backtracking: When backtracking from a node, its low[] value is updated based on its child nodes, and the conditions for articulation points are checked.
    Root Condition: For the root node, the articulation point condition is different—if it has more than one child, it is a cut vertex because removing it disconnects its children from each other.
*/
//*************************************************************(tarjans approach)**********************************************************
class Solution
{
    //Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> articulationPoints(int n,ArrayList<ArrayList<Integer>> adj)
    {
        if(adj==null || adj.size()==0) return new ArrayList<>();
        
        int[] visited=new int[n];// to keep track of the nodes whether they are visited or not;
        int[] tin=new int[n]; // keep track of timing of nodes when they firstly reach; eq 4 willbe reach after 1,2,3;
        int[] low=new int[n]; // min of all adj nodes apart from parent & visited node;
        int[] mark=new int[n]; //this will mark all nodes that are articulation point;
        
        //checking in all component of graph;
        for(int i=0;i< n;i++){
            if(visited[i]==0){
                dfs(0 , -1, visited , tin , low , mark , adj);
            }
        }
        
        //list to store all articulation points;
        ArrayList<Integer> ans=new ArrayList<>();
        
        //those who had marked after dfs traversal , added to the ans list;
        for(int i=0 ;i< n ;i++){
            if(mark[i]==1){
                ans.add(i);
            }
        }
        //if ans list is 0 then return -1;
        if(ans.size()==0){
            ans.add(-1);
        }
        return ans;
    }
    
    private int timer=1;
    
    private void dfs(int node , int parent , int[] visited , int[] tin , int[] low , int[] mark , ArrayList<ArrayList<Integer>> adj){
        visited[node]=1;
        tin[node]=low[node]=timer;
        timer++;
        
        int child=0;
        for(int a: adj.get(node)){
            if(a==parent) continue; // agr hmara adj node parent hai jisse abhi aaye hi hai ignore it and check others;
            if(visited[a]==0){
                dfs(a, node , visited,  tin , low , mark , adj);
                //this will go and  do the rest  of job and filled out its tin and low;
                 
                low[node]=Math.min(low[node] , low[a]);
                
                if(low[a] >= tin[node] && parent!=-1){
                    mark[node]=1;
                }
                child++;
                
            }
            else{
                low[node]=Math.min(low[node] , tin[a]);
            }
        }
        if(child>1 && parent==-1) mark[node]=1;
    }
}
