/*
    
    Time complexity: O(E log V)
    where E is the number of edges and
    V is the number of vertices in the graph.

    Space complexity: O(V+E)

*/
//*********************************************************(Dijkstra algorithm)********************************************************************************
class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        if(times==null || times.length==0) return -1;
        //creating an adj list to store all adj node;
        ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        // Populate adjacency list with edges and times
        for (int[] edge : times) {
            adj.get(edge[0] - 1).add(new Pair(edge[1] - 1, edge[2])); // Assuming 1-based indexing
        }
        
        int[] minTime = new int[n];
        Arrays.fill(minTime, Integer.MAX_VALUE);
        minTime[k-1] = 0; // start node

        PriorityQueue<Pair> pq=new PriorityQueue<>((x,y)-> x.time - y.time);
        pq.offer(new Pair(k-1,0));
        while(!pq.isEmpty()){
            Pair pair=pq.poll();
            int node= pair.node;
            int time=pair.time;
            for(Pair a:adj.get(node)){
                int adjNode=a.node;
                int adjT=a.time;
                if(time+adjT < minTime[adjNode]){
                    minTime[adjNode]=adjT+time;
                    pq.offer(new Pair(adjNode ,adjT+time));
                }
            }
        }
        // Find the maximum time to reach all nodes
        int ans = 0;
        for (int t : minTime) {
            if (t == Integer.MAX_VALUE) return -1;
            ans = Math.max(ans, t);
        }
        return ans;
    }
}
//constructing a pair to store all nodes with time;
class Pair{
    int time;
    int node;
    Pair(int node , int time){
        this.node=node;
        this.time=time;
    }
}
