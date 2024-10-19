//approach is simple we prioritize stops then distance, we iterate through bfs and when we get lesser dis within stops limit updating it .
/*
    Graph Representation: Store the graph as an adjacency list where each node is paired with its destination and cost.

    BFS Traversal: Perform a BFS where each state is represented by the current node, distance so far, and the number of stops.

    Distance Array: Keep track of the minimum cost to reach each node from the source using a distance array. Initialize all distances as infinity (Integer.MAX_VALUE), except the source node, which starts with a distance of 0.

    Stop Limitation: If the number of stops exceeds the given limit k, stop exploring further.

    Updating Distances: For each neighboring node, if the new distance is less than the previously recorded distance and within the stops limit, update the distance and add it to the queue.

    Final Result: After the BFS completes, if the destination is still unreached, return -1, otherwise return the minimum distance to reach the destination.

    Time Complexity: O(n + m)
    Space Complexity: O(n)
*/
//********************************************************************************************************************************************
class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        ArrayList<ArrayList<Pair>> adj=new ArrayList<>();  //this will store all adj node with cost to reach them;
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        int m=flights.length;
        //storing all adj nodes with distance in the form of pair;
        for(int i=0;i<m;i++){
            adj.get(flights[i][0]).add(new Pair(flights[i][1] , flights[i][2]));
        }

        //we cant use priorityQueue as it is useless stops are increasing by +1 so everthing got pile up like normal dfs;
        Queue<Triplet> q=new LinkedList<>();
        q.offer(new Triplet(0 , src , 0)); //for the strt node dist=0 and stops is also 0;

        //dist array to store the min cost ;
        int[] dist=new int[n];
        Arrays.fill(dist , Integer.MAX_VALUE);
        dist[src]=0;

        while(!q.isEmpty()){
            Triplet tr=q.poll();
            int stops=tr.stops;
            int node=tr.node;
            int dis=tr.distance;
            if(stops > k) continue; // no need to explore further , because it exceeds stops limit given;
            for(Pair it : adj.get(node)){
                int adjNode=it.node;
                int adjDist=it.distance;

                //if we got a lesser distance then previous and stops not reached its limit means we can consider that;
                if(dis+adjDist < dist[adjNode] && stops<=k){
                    dist[adjNode]=dis+adjDist;
                    q.offer(new Triplet(stops+1 , adjNode , dist[adjNode]));
                }
            }
        }

        //if distance node still unreached store -1;
        if(dist[dst]==Integer.MAX_VALUE) dist[dst]=-1;

        return dist[dst];
    }
}

class Triplet{
    int stops;
    int node;
    int distance;
    Triplet(int stops , int node , int distance){
        this.stops=stops;
        this.node=node;
        this.distance=distance;
    }
}

class Pair{
    int node;
    int distance;
    Pair(int node , int distance){
        this.node=node;
        this.distance=distance;
    }
}
