/*
Algorithm Overview:

    Prim's algorithm finds the minimum spanning tree (MST) by growing a single tree, starting from an arbitrary node.
    Use a min-heap (priority queue) to pick the edge with the smallest weight that connects a visited node to an unvisited node.

Key Steps:

    Initialize a priority queue with the starting node (node 0, weight 0).
    Maintain a visited array to ensure each node is processed once.
    For each node, add its adjacent nodes (unvisited) to the priority queue.
    Accumulate edge weights when visiting new nodes.

Min-Heap Operation:

    The min-heap helps extract the minimum weight edge connecting the current tree to an unvisited node efficiently.

Visited Array:

    Ensures that no node is processed more than once, avoiding cycles in the MST.

Time Complexity:

    O(E log V), where E is the number of edges, and V is the number of vertices. Log V comes from priority queue operations.

Space Complexity:

    O(V + E) for the adjacency list, priority queue, and visited array.
*/
//*******************************************************************************************************************
class Solution {
    static int spanningTree(int V, int E, List<List<int[]>> adj) {
        
        //creating min heap to get min path ;(
        PriorityQueue<Pair> pq=new PriorityQueue<>((x,y) -> x.weight-y.weight);
        pq.offer(new Pair(0,0));
        
        int sum=0;
        
        //creating a visited array to keep track of whether the node is visited or not;
        int[] visited=new int[V];
        
        while(!pq.isEmpty()){
            Pair pair=pq.poll();
            int node=pair.node;
            int weight=pair.weight;
            
            if(visited[node]==1) continue;
            //if the node is not visited mak it visted and add its weight to sum;
            visited[node]=1;
            sum+=weight;
            
            for(int i=0 ;i<adj.get(node).size() ;i++){
                int adjN=adj.get(node).get(i)[0];
                int adjW=adj.get(node).get(i)[1];
                
                //here we only adding adjNode and pair to pq and not marking as visited;
                if(visited[adjN]==0){
                    pq.offer(new Pair(adjN , adjW));
                }
            }
        }
        return sum;
    }
}

//creating a class that store the node and their weight;
class Pair{
    int node;
    int weight;
    Pair(int node , int weight){
        this.node=node;
        this.weight=weight;
    }
}
