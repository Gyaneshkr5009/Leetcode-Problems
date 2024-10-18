/*
      Kosaraju's algorithm is used to find all Strongly Connected Components (SCCs) in a directed graph. An SCC is a subgraph where every node can reach every other node in the subgraph.
Approach:

    Step 1: DFS to Fill Stack by Finish Time
        Perform a DFS traversal on the original graph.
        Add nodes to a stack based on their finish time (i.e., when their DFS traversal is complete).

    Step 2: Transpose the Graph
        Reverse the direction of all edges in the graph to create the transpose graph.
        This helps in isolating SCCs in the reverse graph since now no edges will leave an SCC.

    Step 3: DFS on Transpose Graph
        Using the nodes in the stack (from step 1), perform DFS on the transposed graph.
        Every time you start a new DFS from an unvisited node, you identify an SCC.

    Count SCCs:
        The number of DFS calls in the transposed graph gives the number of SCCs.

Key Points:

    DFS Traversal: Explore all nodes in the graph, ensuring that nodes with no further paths are finished first and added to the stack.
    Transpose Graph: Reverse edges to help isolate SCCs during the second DFS.
    DFS on Transpose: DFS is repeated on the transposed graph using the nodes popped from the stack.

Time Complexity:

    O(V + E) where V is the number of vertices and E is the number of edges.
        Each node and edge is visited twice (once for the original DFS and once for the DFS on the transposed graph).

Space Complexity:

    O(V + E) for storing the adjacency list and auxiliary structures like the stack and visited arrays.
*/
//************************************************************************************************************************************************************
class Solution
{
    private void step3Dfs(int node , int[] visited , ArrayList<ArrayList<Integer>> adjT){
        visited[node]=1;
        
        for(int a: adjT.get(node)){
            if(visited[a]==0){
                step3Dfs(a, visited , adjT);
            }
        }
    }
    //Function to find number of strongly connected components in the graph.
    public int kosaraju(int n, ArrayList<ArrayList<Integer>> adj)
    {
        if(adj==null || adj.size()==0) return 0;
        //step 1: dfs , store and sort all nodes on the basis of finishing time;
        Stack<Integer> st=new Stack<>();
        
        int[] visited=new int[n]; //to keep track off whether the node is visited or not;
        for(int i=0;i<n;i++){
            if(visited[i]==0){
                dfsToFillStack(i , visited , st, adj);
            }
        }
        //now we have all the nodes in stack filled on the basis of their finishing time;
        
        //Step 2: reverse all edges of graph so that on dfs no edges connect to other SSC;
        //   SSC1 <== SSC2 <== SSC3 ... etc; this will help us to find all SSC by seperating them from each other;
        
        // creating transpose adj arrayList;
        ArrayList<ArrayList<Integer>> adjT=new ArrayList<>();
        for(int i=0;i< n ;i++){
            adjT.add(new ArrayList<>());
        }
        
        //makeing all nodes unvisited again , and filling adjT;
        for(int i=0;i<n;i++){
            visited[i]=0;
            for(int a:adj.get(i)){
                // i -> a
                // a -> i  , reversing edges
                adjT.get(a).add(i);
            }
        }
        
        int SSC=0;  // track , no of SSC(strongly Connected Component) in a graph;
        
        //Step3: take out one by one from stack and again dfs to mark visited and that pai is SSC;
        while(!st.isEmpty()){
            int node=st.pop();
            if(visited[node]==0){
                SSC++;
                step3Dfs(node , visited , adjT);
            }
        }
        return SSC;
        
    }
    
    //this fuctn will  add nodes to stack from the end of dfs to start node of dfs;
    private void dfsToFillStack(int node , int[] visited , Stack<Integer> st , ArrayList<ArrayList<Integer>> adj){
        visited[node]=1; // visited the node;
        
        for(int a: adj.get(node)){
            if(visited[a]==0){
                dfsToFillStack(a, visited , st , adj);
            }
        }
        
        //adding node into stack after complete dfs traversal;
        st.add(node);
    }
}
