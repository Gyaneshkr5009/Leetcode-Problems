*/
    Graph Representation: Use an adjacency list to store the graph where each road connects two nodes with a certain travel time.

    Distance Array: Maintain a times[] array to track the minimum time to reach each node from the starting node. Initialize all times to infinity (Long.MAX_VALUE), except for the source node, which is set to 0.

    Path Count Array: Use the arrived[] array to track how many different ways you can reach a node using the minimum time.

    BFS with Priority Queue:
        Implement a priority queue that stores nodes and their current shortest times (to always process the next closest node).
        For each node, explore its neighbors and update the shortest time for neighboring nodes if a shorter path is found.
        If an equivalent shortest path is found, update the arrived[] count by adding the number of ways you can arrive at the current node.

    Modulo Operation: Since the result can be large, apply MOD = 1_000_000_007 to the path counts to avoid overflow.

    Final Result: Return the number of ways to reach the destination node modulo MOD.

    Time Complexity: O(m log n)
    Space Complexity: O(n + m)
*/
//***************************************************************(dijkstra's Alogrith)***************************************************
class Solution {
    int MOD = 1_000_000_007;
    public int countPaths(int n, int[][] roads) {
        if(n==1) return 1;
        if(roads==null || roads.length==0) return 0;

        //creating an array to keep track of all adj nodes;
        ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        int m=roads.length;
        for(int i=0;i<m;i++){
            adj.get(roads[i][0]).add(new Pair(roads[i][1] , roads[i][2]));
            adj.get(roads[i][1]).add(new Pair(roads[i][0] , roads[i][2]));
        }

        long[] arrived=new long[n]; // this will store how many times we reach a particular node;
        arrived[0]=1;
 
        long[] times=new long[n]; // stores all min times to reach nodes;
        Arrays.fill(times , Long.MAX_VALUE);
        times[0]=0;

        //now using bfs traversal to figure out how many times we reach the node;
        PriorityQueue<Pair> pq=new PriorityQueue<>((x,y) -> Long.compare(x.time,y.time));
        pq.offer(new Pair(0 ,0)); // node 0 && time=0;

        while(!pq.isEmpty()){
            Pair pair=pq.poll();
            int node=pair.node;
            long time=pair.time;

            for(Pair p: adj.get(node)){
                int adjNode=p.node;
                long adjT=p.time;

                if(time + adjT < times[adjNode]){
                    times[adjNode]=time+adjT;
                    arrived[adjNode]=arrived[node]; // reseting the arriving count;
                    pq.offer(new Pair(adjNode , times[adjNode]));
                }

                //this is for the last node;
                if(time+adjT==times[adjNode]){
                    arrived[adjNode] = (arrived[adjNode] + arrived[node]) % MOD;
                }
            }
        }
        return (int)(arrived[n-1]%MOD);
    }
}
class Pair{
    int node;
    long time;
    Pair(int node , long time){
        this.node=node;
        this.time=time;
    }
}
