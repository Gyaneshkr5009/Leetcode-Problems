// approaach is explained below the code;
//********************************************************************(BELLMAN FORD)****************************************************************
class Solution {
    static int[] bellmanFord(int V, ArrayList<ArrayList<Integer>> edges, int src) {
        
        int[] dist=new int[V]; //keep track of each notes dist from src node;
        Arrays.fill(dist , (int)1e8); // fill all index with infinite;
        dist[src]=0; // dist to reach src from src is always 0;
        
        for(int i=0;i<V-1 ;i++){
            
            //this loop fill the dist[] array if it found better option;
            for(ArrayList<Integer> edge:edges){
                // u --> v
                int u=edge.get(0);
                int v=edge.get(1);
                int cost=edge.get(2);
                
                //if we got a smaller distance then previous update it;
                if(dist[u] != 1e8 && dist[u]+cost < dist[v]){
                    dist[v]=dist[u]+cost;
                }
            }
        }
        
        //after completing the (n-1) iteration we got the shortest path of all nodes from src;
        //but for checking the [edge cycle in a graph] we have to move +1 iteration;
        //and if the dist[] remains the same means there is not an edge cycle, and if still changes there's an edge cycle;
        
        for(ArrayList<Integer> edge:edges){
            // u --> v
            int u=edge.get(0);
            int v=edge.get(1);
            int cost=edge.get(2);
            
            //if the cost still reducing return -1;
            if(dist[u]!=1e8 && dist[u] + cost < dist[v]){
                return new int[]{-1};
            }
            
        }
        return dist;
    }
}
//************************************(approach)********************************************
/*
        Initialization:
        An array dist[] is initialized with a very large value (1e8) representing infinity. The distance from the source node src to itself is set to 0 (dist[src] = 0).

    Relaxation of Edges:
        For V-1 iterations (where V is the number of vertices), the algorithm checks all edges and updates the distance of a vertex v from src if a shorter path is found via vertex u. This ensures that the shortest path is computed in V-1 iterations since a simple path in a graph can have at most V-1 edges.

    Cycle Detection:
        After V-1 iterations, a final iteration is performed to detect negative-weight cycles. If any edge can still be relaxed (i.e., the distance is further reduced), it implies the presence of a negative-weight cycle, and the function returns -1 to indicate this.

    Edge List Representation:
        The edges are represented using an adjacency list of lists, where each edge is stored as a triplet [u, v, cost], denoting an edge from u to v with a cost.

    Handling Negative Cycles:
        If no negative-weight cycle is detected, the final dist[] array containing the shortest distances from src to all other vertices is returned.

Time Complexity:

    O(V * E): The algorithm runs V-1 iterations, and for each iteration, it relaxes E edges, making the time complexity proportional to V * E, where V is the number of vertices and E is the number of edges.

Space Complexity:

    O(V): The space complexity is mainly due to the dist[] array, which stores the shortest distances for V vertices.
*/
